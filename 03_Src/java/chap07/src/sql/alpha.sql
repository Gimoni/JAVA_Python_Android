--
-- DDL (Data Definition Language)
-- create
-- alter
-- drop
-- truncate
--

drop table alpha;

create table alpha (
	no		number primary key,
	line	number,
	col		number,
	fg		varchar2(7 char),
	bg		varchar2(7 char),
	ch		char(1 char)
);


-- DDL 문 (무조건 자동 커밋. 되돌리기 불가능.. )
truncate table alpha;

-- DQL ( Data Query Language)
select
* from alpha;



-- 전체 카운트
select count(*) from alpha;

-- fg & bg 의 중복을 제거한 데이터
select distinct fg, bg from alpha;

-- fg 데이터만 보기
select distinct fg from alpha;

-- bg 데이터만 보기 
select distinct bg from alpha;

-- ch 데이터만 보기
select distinct ch from alpha;


-- alpha테이블에서 fg와 bg가 같은 데이터 
select *
  from alpha
 where fg=bg;

 -- select문 
 -- 전체 카운트에서 line과 column 에서의 중복을 제외한 데이터 수 확인. 
with duple as (
	select distinct line, col
  	  from alpha
)
select count(*)from duple;

select count(distinct to_char(line, '00')||to_char(col, '00'))
  from alpha;


-- 전체 카운트에서 fg와 bg 가 같은 경우(중복)를 제외한 데이터 수(count) 확인.
with duple as (
	select distinct fg, bg
  	  from alpha
)
select count(*) from duple;


-- 전체 카운트에서 ch의 중복을 제외한 데이터의 수 확인.
with duple as (
	select distinct ch
  	  from alpha
)
select count(*) from duple;

select count(distinct line + col)
  from alpha;
  
-- 
select line, col, to_char(line, '00') || to_char(col, '00')
  from alpha;
  
  
select count(distinct to_char(line, '00') || to_char(col, '00'))
  from alpha;
  



  
  
--
-- CRUD ( Create Retrive Update Delete)
-- DML ( Data Manipulation Langueage)
-- insert
-- update
-- delete
--

select * from alpha;
-- insert 문의 기본 문형.. 
insert into alpha values (1, 1, 1, 'Black', 'Red', 'A');
insert into alpha values (2, 2, 2, 'Black', '대한민국화이팅', 'B');
insert into alpha values (3, 3, 3, 'Yellow', 'Blue', '가');


select *
  from alpha
 where line=1 and col=1
 order by no desc;
-- order by no (asc);
 
 
select * 			
  from alpha
 order by line asc, col asc;
 
select *
  from alpha
 order by no desc;
 
select *
  from alpha
 order by line asc;
           decode(fg, 'Black', 30,
                  'Red', 31,
                  'Green', 32,
                  'Yellow', 33,
                  'Blue', 34,
                  'Magenta', 35,
                  'Cyan', 36,
                  'White', 37, 99) asc;
                  
                  
                  
with tmp as (
select max(no) as no  
  from alpha
 group by line, col
 order by line, col
)

select * 
  from alpha
 where no in (select no from tmp)
order by line asc, col asc, fg asc;



