package com.codingbear.controller;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.codingbear.domain.SampleDTO;
import com.codingbear.domain.SampleDTOList;
import com.codingbear.domain.TodoDTO;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	/*
	@RequestMapping("/")
	public void basic() {
		log.info("basic................................");
	}
	*/
	
	// @RequestMapping의 변환
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get ...........................");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get ..................");
	}
	
	// 6.3 Controller의 파라미터 수집
	// http://localhost:8080/sample/ex01?name=AAA&age=10
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("" + dto); // SampleDTO(name=AAAA, age=10)
		return "ex01";
	}
	
	// 6.3.1 파라미터 수집과 반환
	// http://localhost:8080/sample/ex02?name=AAA&age=10
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, 
					   @RequestParam("age") int age) {
		log.info("name: " + name); // name: AAA
		log.info("age: " + age);   // age: 10
		return "ex02";
	}
	
	// 6.3.2 리스트, 배열 처리
	// http://localhost:8080/sample/ex02List?ids=111&ids=222&ids=333
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids: " + ids); // ids: [111, 222, 333]
		return "ex02List";
	}
	
	// http://localhost:8080/sample/ex02Array?ids=AAA&ids=BBB&ids=CCC
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("array ids: " + Arrays.toString(ids)); // array ids: [AAA, BBB, CCC]
		return "ex02Array";
	}
	
	// 6.3.3 객체 리스트
	// http://localhost:8080/sample/ex02Bean?list[0].name=aaaa&list[2].name=bbb
	// http://localhost:8080/sample/ex02Bean?list%5B0%5D.name=aaa&list%5B2%5D.name=bbb
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list dtos: " + list); 
		// list dtos: SampleDTOList(list=[SampleDTO(name=aaa, age=0), SampleDTO(name=null, age=0), SampleDTO(name=bbb, age=0)])
		
		return "ex02Bean";
	}
	
	// 6.3.4 @InitBinder 사용 
	/*
	@InitBinder // 스프링 Controller에서  파라미터를 바인딩할 때 자동으로 호출되어 파라미터를 변환 처리한다. 
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	*/

	
	// http://localhost:8080/sample/ex03?title=test&dueDate=2018/01/01
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo: " + todo); // TodoDTO(title=test, dueDate=Thu Nov 01 00:00:00 KST 2018)
		return "ex03"; 
	}
	
}
