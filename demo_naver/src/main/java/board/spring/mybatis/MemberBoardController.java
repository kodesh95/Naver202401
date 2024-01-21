package board.spring.mybatis;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberBoardController {
	@Autowired
	@Qualifier("memberServiceImpl")
	MemberService service;
	
	@GetMapping("/boardlogin")
	public String loginForm() {
		return "board/loginform";
	}
	
	@PostMapping("/boardlogin")
	String loginProcess(String memberid, String pw, HttpSession session) {
		 MemberDTO dto = service.oneMember(memberid);
		 if(dto != null) {
		  if(dto.getPw().equals(pw)) {
			  //정상로그인
			  session.setAttribute("sessionid", memberid);
			  //sesssion.setAttribute("memberdto", dto);
		  }
		  else {
			  //암호 다른 경우
			  //session.setAttribute("sessionid", "암호 다시 입력하세요");
		  }
		 }
		 else {
			// members 존재x 
			// session.setAttribute("sessionid","회원가입부터 하세요");
		 }
		return "board/start"; 
		 
	}
	
	@RequestMapping("/boardlogout")
	String logout(HttpSession session){
		if(session.getAttribute("sessionid") != null) {
		session.removeAttribute("sessionid");
	}
		return "board/start";
	}
	
	//http:localhost;9070/getwriter/xxx
	@RequestMapping("/getwriter/{writer}")
	@ResponseBody
	MemberDTO getwriter(@PathVariable("writer") String memberid){
		 MemberDTO dto = service.oneMember(memberid);
		 return dto;
	}
	
}
