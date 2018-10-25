package com.codingbear.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

// 6.3.3 객체 리스트
@Data
public class SampleDTOList {
	private List<SampleDTO> list;
	
	public SampleDTOList() {
		list = new ArrayList<>();
	}
}
