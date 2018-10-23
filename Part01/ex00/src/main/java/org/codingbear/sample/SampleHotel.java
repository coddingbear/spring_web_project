package org.codingbear.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Component
@ToString // toString() 메소드를 자동 생성합니다.
@Getter // 인스턴스 변수로 선언된 모든 것에 대한 getter 메소드를 자동 생성합니다.
@AllArgsConstructor // 인스턴스 변수로 선언된 모든 것을 파라미터로 받는 생성자를 자동 생성합니다.
public class SampleHotel {
	private Chef chef;
	
	/* @AllArgsConstructor 에 의해 자동 생성 됩니다.
	public SampleHotel(Chef chef) {
		this.chef = chef;
	}
	*/
}
