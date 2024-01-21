package upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
//sts3 - servlet 2.xx javax.servlet.xxxx
//sts4 - servlet 6.0  jakarta.servlet.xxxx

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DownloadController {

	@GetMapping("/filedownloadlist")
	ModelAndView downloadlist() {
		ModelAndView mv = new ModelAndView();
		// c:'fullstack/upload 파일명 추출 모델
		File f = new File("c:/fullstack/upload/");
		String[] filearray = f.list();
		
		mv.addObject("filearray" , filearray);
		// upload/download.jsp
		mv.setViewName("upload/download");
		return mv;
	}
	@GetMapping("/filedownloadresult")
	void downloadresult(String filename, HttpServletResponse response) throws IOException{
		response.setContentType("application/download");
		response.setHeader("Content-Disposition", "attachment;filename=\"" + filename +"\"");
		File f = new File("c:/fullstack/upload/" + filename);
		response.setContentLength((int)f.length());
		
		OutputStream out = response.getOutputStream();
		FileInputStream fi = new FileInputStream(f);
		FileCopyUtils.copy(fi, out);
		fi.close();
		out.close();
	}
	
}
