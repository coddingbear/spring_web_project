package org.codingbear.sample;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
@RequiredArgsConstructor // @NonNull과 같이 사용하여 특정한 인스턴스 변수에 대한 파라미터를 갖는 생성자를 자동 생성합니다. 
public class SampleHotel {
	@NonNull
	private Chef chef;
	
	/*
	public SampleHotel(Chef chef) {
		this.chef = chef;
	}
	*/
}
