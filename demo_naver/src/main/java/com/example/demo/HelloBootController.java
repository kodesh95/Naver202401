package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloBootController {
@RequestMapping("/helloboot")
String helloboot(){
	return "helloboot";
}

@RequestMapping("/helloajax")
@ResponseBody	
public String helloajax() {
	return "{\"model\" : \"스프링 ajax 시작합니다\"}";
}
}

// 자동완성 불가능-알집x