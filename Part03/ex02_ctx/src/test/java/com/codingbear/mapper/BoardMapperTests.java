package com.codingbear.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codingbear.domain.BoardVO;
import com.codingbear.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // xml 컨텍스트
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	// 게시글 목록 테스트
	@Test
	public void testGetList() {
		//mapper.getList().forEach(board->log.info(board));
		mapper.getListWithPaging(new Criteria(2, 10)).forEach(board -> log.info(board));
	}
	
	// 새 게시글 생성 테스트
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		mapper.insert(board);
		
		log.info(board);
	}
	
	// 게시글 가져오기 테스트
	@Test
	public void testRead() {
		// 존재하는 게시물 번호로 테스트
		BoardVO board = mapper.read(5L);
		
		log.info(board);
	}
	
	// 게시글 삭제 테스트
	@Test
	public void testDelete() {
		log.info("DELETE COUNT: " + mapper.delete(3L));
	}
	
	// 게시글 수정 테스트
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		// 실행전 존재하는 번호인지 확인할 것
		board.setBno(5L);
		board.setTitle("수정된 내용");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: " + count);
	}
	
	// 페이징 테스트와 수정
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		// 10개씩 3 페이지 목록 보기
		cri.setPageNum(3);
		cri.setAmount(10);
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
	
}
