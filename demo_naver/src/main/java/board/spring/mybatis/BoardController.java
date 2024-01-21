package board.spring.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {//board테이블관련작업  .  members테이블
	@Autowired
	@Qualifier("boardServiceImpl")
	BoardService service;
	
	@RequestMapping("/")
	String start(){
		return "board/start";
	}
	@GetMapping("/boardwrite")
	String writeForm(){
		return "board/writingform";
	}


	@PostMapping("/boardwrite")
	ModelAndView writeProcess(BoardDTO dto) {
		//title, contents, writer, pw
		//seq, viewcount, writing값 없음(sql상 처리)
		service.registerBoard(dto);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/start");// 모델 없고 뷰만 설정
		return mv;
	}
	
	@RequestMapping("boardlist")
	ModelAndView boardList(@RequestParam(value="pagenum", required=false , defaultValue="1") int pagenum){
		int pagecount = 3;
		int [] limit = new int[2];
		limit[0] = (pagenum-1) * pagecount;
		limit[1] = pagecount;
		ModelAndView mv = new ModelAndView();
		
		List<BoardDTO> list = service.boardList(limit);
		mv.addObject("boardlist", list);
		int totalcount = service.getTotalBoard();
		mv.addObject("totalcount", totalcount);
		
		mv.addObject("pagecount", pagecount);
		mv.setViewName("board/list");
		return mv;
	
	}
	
	@RequestMapping("/boarddetail")
	ModelAndView boarddetail(int seq){
		//seq 번호에 해당하는 게시물 viewcount 1개 증가 sql(update)
		//seq 번호에 해당하는 게시물 1개 sql -MemberDTO-모델 저장
		BoardDTO dto = service.updateViewcountAndGetDetail(seq);
		ModelAndView mv = new ModelAndView();
		mv.addObject("detaildto", dto);
		mv.setViewName("board/detail");
		return mv;
		
		
	}
	
	@RequestMapping("/boarddelete")
	String boarddelete(int seq) {
		service.deleteBoard(seq);
		return "redirect:/boardlist"; //모델3(페이지리스트, 전체갯수,한페이지목록)
	}
	
	@PostMapping("/boardupdate")
	String boardupdate(BoardDTO dto) {
		service.updateBoard(dto);
		//return "redirect:/boardlist";
		return "redirect:/helloboot";
	}
	
}
//year month day hour
//date_format(?, '%h%m%d')


