package com.codingbear.domain;

import java.sql.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class TodoDTO {
	private String title;
	
	// @DateTimeFormat(pattern = "yyyy/MM/dd") //  "yyyy/MM/dd"의 형식의 문자열을 자동으로 날짜 타입으로 변환
	private Date dueDate;
}

