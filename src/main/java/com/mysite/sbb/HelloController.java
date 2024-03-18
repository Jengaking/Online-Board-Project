package com.mysite.sbb;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 브라우저의 요청을 처리한다.
public class HelloController {
	@GetMapping("/hello") // http://localhost:8080/hello 메소드와 url을 매핑한다. GET 방식 처리
	@ResponseBody
	public String hello() {
		return "점프 투 스프링 부트";
	}
}
