package com.codingbear.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 검색의 기준 클래스
 * @author CodingBear
 */
@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum; // 페이지 번호
	private int amount;  // 페이지당 게시글 수
	
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
