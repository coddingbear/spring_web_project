package org.codingbear.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.Setter;

@Component // 스프링에게 해당 클래스가 스프링에서 관리해야 하는 대상임 표시 -> 빈 생성
@Data // lombok에서 setter , 생성자, toString() 등 자동 생성하도록 하는 애너테이션
public class Restaurant {
	@Setter(onMethod_ = @Autowired) // @Setter는 자동으로 setChef()를 컴파일 시 생성합니다. 
	private Chef chef;  // setter 메소드에 @Autowired 애너테이션을 추가하도록 합니다.
}
