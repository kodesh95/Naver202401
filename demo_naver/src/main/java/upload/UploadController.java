package upload;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class UploadController {
 //1개결과뷰
//	폼화면
	@GetMapping("/fileupload")
	String  uploadform(){
		return "upload/uploadform";
	}
	
	@PostMapping("/fileupload")
	ModelAndView  uploadresult(UploadDTO dto) throws IOException{
		//요청파라미터명 = dto 변수명 자동 전당 주입
		String savePath = "/usr/mydir/upload/";
		String filename1 = null , newfilename1 = null, filename2 =null, newfilename2= null;
	
		//클라이언트 파일 전송한다 - http stream - 파일형태로 서버 전송받는다
		MultipartFile file1 = dto.getFile1();
		if(!file1.isEmpty()) {
			filename1 = file1.getOriginalFilename();
			String beforeext1 = filename1.substring(0, filename1.indexOf("."));//memberlist
			String ext1 = filename1.substring(filename1.indexOf("."));//.jsp
			newfilename1 = beforeext1 + "(" + UUID.randomUUID().toString() + ")" + ext1;
			//System.out.println(newfilename1);
			File savefile1 = new File(savePath + newfilename1);//empty file 생성
			file1.transferTo(savefile1);//업로드 스트림을 서버내부 파일형태 저장 
		}
		
		MultipartFile file2 = dto.getFile2();
		if(!file2.isEmpty()) {
			filename2 = file2.getOriginalFilename();
			String beforeext2 = filename2.substring(0, filename2.indexOf("."));//memberlist
			String ext2 = filename2.substring(filename2.indexOf("."));//.jsp
			newfilename2 = beforeext2 + "(" + UUID.randomUUID().toString() + ")" + ext2;
			
			File savefile2 = new File(savePath + newfilename2);
			file2.transferTo(savefile2);
		}

 
		ModelAndView mv = new ModelAndView();
		mv.addObject("saveresult1", filename1 + " 파일을 " + savePath + newfilename1 
				+ " 파일으로 저장했습니다.");
		mv.addObject("saveresult2", filename2 + " 파일을 " + savePath + newfilename2 
				+ " 파일으로 저장했습니다.");
		mv.setViewName("upload/uploadresult");
		
		return mv;

	}
	
}


