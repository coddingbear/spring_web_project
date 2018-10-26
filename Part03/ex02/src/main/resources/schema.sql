CREATE SEQUENCE seq_board;

--  답변식 게시판 테이블 
CREATE TABLE tbl_board (
	bno NUMBER(10, 0),               -- 게시글 번호
	title VARCHAR2(200) NOT NULL,    -- 글 제목
	content VARCHAR2(2000) NOT NULL, -- 글 내용 
	writer VARCHAR2(50) NOT NULL,    -- 글 쓴이
	parent NUMBER(10, 0) NOT NULL,   -- 상위 게시글 번호
	seqno NUMBER(10, 0) DEFAULT 0,   -- 답변 순서
	depth NUMBER(10, 0) DEFAULT 0,   -- 답변 깊이
	regdate DATE DEFAULT SYSDATE,    -- 작성일
	updatedate DATE DEFAULT SYSDATE  -- 수정일
);
-- 게시판 테이블 기본키 지정
ALTER TABLE tbl_board ADD CONSTRAINT pk_board PRIMARY KEY (bno);