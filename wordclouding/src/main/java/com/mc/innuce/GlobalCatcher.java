package com.mc.innuce;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// controller에서 발생하는 예외를 모두 처리해준다.
//@ControllerAdvice //모든 패키지 처리
@ControllerAdvice("com.mc.innuce") // 해당 패키지만 처리
public class GlobalCatcher {

//try-catch 블럭을 대신해준다.
	@ExceptionHandler({NullPointerException.class,FileNotFoundException.class})
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex",ex);
		return "error";
	}

//	try-catch 블럭을 대신해준다.
	@ExceptionHandler(IOException.class)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex",ex);
		return "error";
	}
//	try-catch 블럭을 대신해준다.
	@ExceptionHandler(Exception.class)
	public String catcher3(Exception ex, Model m) {
		m.addAttribute("ex",ex);
		return "error";
	}
}




