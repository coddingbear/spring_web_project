select * from tbl_board order by bno desc;

insert into tbl_board(bno, title, content, writer, parent )
(select seq_board.nextval, title, content, writer, seq_board.currval from tbl_board);

SELECT * FROM tbl_board ORDER BY bno + 1 desc;

-- order by 보다 인덱스
SELECT 
    /*+ INDEX_DESC(tbl_board pk_board) */
    *
FROM tbl_board
WHERE bno > 0;


-- 게시판 테이블 기본키 지정
ALTER TABLE tbl_board ADD CONSTRAINT pk_board PRIMARY KEY (bno);

select * from tbl_board where bno > 0;

select * from tbl_board where bno = 100;

-- 인덱스를 이요한 접근 시 ROWNUM
SELECT /*+ INDEX_ASC(tbl_board pk_board) */
    rownum rn, bno, title, content
FROM tbl_board;

SELECT /*+ INDEX_DESC(tbl_board pk_board) */
    rownum rn, bno, title, content
FROM tbl_board
WHERE rownum <= 10;

-- 아무 결과가 나오지 않는다.
SELECT /*+ INDEX_DESC(tbl_board pk_board) */
    rownum rn, bno, title, content
FROM tbl_board
WHERE rownum > 10 AND rownum <= 20;

-- ROWNUM은 반드시 1이 포함되도록 해야 한다.
SELECT /*+ INDEX_DESC(tbl_board pk_board) */
    rownum rn, bno, title, content
FROM tbl_board
WHERE rownum <= 20;

-- 2페이지 데이터 처리
SELECT bno, title, content
FROM (
    SELECT /*+ INDEX_DESC(tbl_board pk_board) */
        rownum rn, bno, title, content
    FROM tbl_board
    WHERE rownum <= 20 )
WHERE rn > 10;
    
