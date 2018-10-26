package com.codingbear.service;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.codingbear.config.RootConfig;
import com.codingbear.domain.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

// 9.2 비즈니스 계층의 구현과 테스트
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class}) // Java Config 파일
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}

	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성한 글 - 비즈니스 계층");
		board.setContent("새로 작성한 내용 - 비즈니스 계층");
		board.setWriter("newbie");
		
		service.register(board);
		
		log.info("생성된 게시물의 번호: " + board.getBno());
	}
	
	@Test
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testGet() {
		log.info(service.get(1L));
	}
	
	@Test
	public void testDelete() {
		// 게시물 번호의 존재 여부를 확인하고 테스트할 것
		log.info("REMOVE RESULT: " + service.remove(2L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = service.get(1L);
		
		if(board == null) {
			return ;
		}
		board.setTitle("제목을 수정합니다.");
		log.info("MODIFY RESULTL: " +  service.modify(board));
	}
}
