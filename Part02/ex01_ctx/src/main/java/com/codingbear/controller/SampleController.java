package com.codingbear.controller;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.codingbear.domain.SampleDTO;
import com.codingbear.domain.SampleDTOList;
import com.codingbear.domain.TodoDTO;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping("/")
	public void basic() {
		log.info("basic................................");
	}
		
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
	
	//6.4.1 @ModelAttribute 애너테이션
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto: " + dto);
		log.info("page: " + page);
		
		return "/sample/ex04";
	}
	
	// 6.5.3 객체 타입 : Controller의 메서드 리턴타입을 VO, DTO 타입의 객체 타입으로 지정
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06 .........................");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
	}
	
	// 6.5.4 ResponseEntity 도입 -> jackson-databind 라이브러리 추가
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("/ex07 .........................");
		
		// {"name":"홍길동","age":10}
		String msg = "{\"name\":\"홍길동\",\"age\":10}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
	// 6.5.5 파일 업로드 처리 -> commons-fileupload 라이브러리 추가
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload .....................");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file -> {
			log.info("-----------------------------------------");
			log.info("name: " + file.getOriginalFilename());
			log.info("size: " + file.getSize());
		});
	}
}
