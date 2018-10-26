package com.codingbear.mapper;

import java.util.List;
import com.codingbear.domain.BoardVO;

public interface BoardMapper {
	
	/**
	 * 글 목록 가져오기
	 * @return List<BoardVO>
	 */
	//@Select("SELECT * FROM tbl_board WHERE bno > 0")
	public List<BoardVO> getList();
	
	/**
	 * 글 저장하기 : insert만 처리되고 생성된 PK 값을 알 필요가 없는 경우
	 * @param board
	 */
	public void insert(BoardVO board);
	
	/**
	 * 글 저장하기 : insert문이 실행되고 생성된 PK 값을 알아야 하는 경우
	 * @param board 게시글 정보
	 */
	public void insertSelectKey(BoardVO board);
	
	/**
	 * 글 상세 보기
	 * @param bno 글번호
	 * @return
	 */
	public BoardVO read(Long bno);
	
	/**
	 * 글 삭제 하기
	 * @param bno 글번호
	 * @return int - 데이터가 삭제되면 1이상의 값을 반환한다.
	 */
	public int delete(Long bno);
	
	/**
	 * 글 수정 하기
	 * @param board 게시글 정보
	 * @return int
	 */
	public int update(BoardVO board);
}
