package com.codingbear.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

// 6.6  Controller의 Exception 처리
@ControllerAdvice // Controller의 공통적인 예외사항에 대해 별도로 처리
@Log4j
public class CommonExceptionAdvice {
	
	@ExceptionHandler(Exception.class) // 해당 메서드가 () 들어가는 예외 타입을 처리하도록 한다.
	public String except(Exception ex, Model model) {
		log.error("Exception ......." + ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		return "error_page";
	}
}
