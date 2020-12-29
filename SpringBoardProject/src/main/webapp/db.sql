	
create table board_tbl_01(
	seq number not null,
	writer nvarchar2(20),
	content long,
	subject nvarchar2(50),
	passwd varchar2(20),
	regdate date default sysdate,	
	ip varchar2(20),	
	readcnt number,
	commentcnt number(6),
	ref number(6),
	re_step number(6)	
);


-- article
insert into board_tbl_01(seq, regdate, writer, content, subject, passwd, ip, readcnt, ref, re_step, commentcnt)
values((select nvl(max(seq), 0)+1 from board_tbl_02), sysdate, ?, ?, ?, ?, ?, ?, (select nvc(max(ref), 0) + 1 from board_tbl_1), 0, 0);


-- comment
insert into board_tbl_01(seq, writer, content, subject, passwd, regdate, ip, readcnt, ref, re_step)
values((select nvl(max(seq), 0)+1 from board_tbl_02), ?, ?, ?, ?, ?, ?, ?, ?, (select nvc(max(re_step), 0)+1) from board_tbl_1 where ref = ?);



-- article list
select rownum, p.* from 
    (select rownum as rnum, k.* from 
    (select * from board_tbl_01 where searchCondition like '%'||'?'||'%' and re_step = 0 order by ref desc) k 
    where rownum <= 100	)p  where rnum >= 1;

    
-- comment list
select rownum, p.* from 
    (select rownum as rnum, k.* from 
    (select * from board_tbl_01 where re_step != 0 and ref = ? order by re_step asc) k 
    where rownum <= 100	)p  where rnum >= 1;
    
    
-- article search
select * from board_tbl_01 where seq = ?;

-- delete board
delete from board_tbl_01 where seq = ?;

-- update board
update board_tbl_01 set writer =?, content = ?, subject = ?, passwd = ?
where seq = ?;

-- readcnt update
update board_tbl_01 set readcnt = readcnt + 1 where seq = ?;

-- commnet cnt
select count(*) from board_tbl_01 where ref = ?;
