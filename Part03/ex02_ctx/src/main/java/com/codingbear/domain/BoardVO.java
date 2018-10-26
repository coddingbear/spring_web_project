package com.codingbear.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private Long bno;         // 게시글 번호
	private String title;     // 제목
	private String content;   // 내용
	private String writer;    // 작성자 아이디
	private Long parent;      // 원글 번호
	private Long seqno;       // 답글 순서
	private Integer depth;    // 답글 깊이
	private Date regdate;     // 작성일자
	private Date updateDate;  // 수정일자
}

