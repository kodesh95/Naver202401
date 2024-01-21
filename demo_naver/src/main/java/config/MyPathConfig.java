package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //servlet-context.xml파일 대신 현재클래스 설정 대신
public class MyPathConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/upload/**").addResourceLocations("file:///c:/fullstack/upload/");
		registry.addResourceHandler("/upload/**").addResourceLocations("file:///usr/mydir/upload/");
	}
// 	http://ip:port/upload/파일명

}
