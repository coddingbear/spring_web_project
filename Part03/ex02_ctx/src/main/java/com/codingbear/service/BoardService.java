package com.codingbear.service;

import java.util.List;

import com.codingbear.domain.BoardVO;
import com.codingbear.domain.Criteria;

// 9.1 비즈니스 계층 설정
public interface BoardService {
	
	/**
	 * 게시글 등록
	 * @param board
	 */
	public void register(BoardVO board);
	
	/**
	 * 게시글 보기
	 * @param bno
	 * @return
	 */
	public BoardVO get(Long bno);
	
	/**
	 * 게시글 수정
	 * @param board
	 * @return
	 */
	public boolean modify(BoardVO board);
	
	/**
	 * 게시글 삭제
	 * @param bno
	 * @return
	 */
	public boolean remove(Long bno);
	
	/**
	 * 게시글 목록
	 * @return
	 */
	// public List<BoardVO> getList();
	public List<BoardVO> getList(Criteria cri);  // 목록보기 페이징처리
}
