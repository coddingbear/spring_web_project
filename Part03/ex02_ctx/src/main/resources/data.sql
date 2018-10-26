-- 게시판 테이블 더미 데이터 입력
INSERT INTO tbl_board (bno, title, content, writer, parent)
VALUES (seq_board.nextval, '텍스트 제목 -01', '테스트 내용 .....', 'user00', seq_board.currval);
INSERT INTO tbl_board (bno, title, content, writer, parent)
VALUES (seq_board.nextval, '텍스트 제목 -02', '테스트 내용 .....', 'user01', seq_board.currval);
INSERT INTO tbl_board (bno, title, content, writer, parent)
VALUES (seq_board.nextval, '텍스트 제목 -03', '테스트 내용 .....', 'user02', seq_board.currval);
INSERT INTO tbl_board (bno, title, content, writer, parent)
VALUES (seq_board.nextval, '텍스트 제목 -04', '테스트 내용 .....', 'user03', seq_board.currval);
INSERT INTO tbl_board (bno, title, content, writer, parent)
VALUES (seq_board.nextval, '텍스트 제목 -05', '테스트 내용 .....', 'user04', seq_board.currval);