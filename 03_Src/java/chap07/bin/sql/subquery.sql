-- SUB QUERY 

select *
  from emp e
 where empno = 1001;    
 
 
select *
  from emp e
 where empno = (
            select empno
              from emp 
             where ename = '이문세'
            );   
            
select *
  from emp e, (select * from emp) m;
  

select (select 1 from dual)
  from dual;
  
-- sub query   
select *   
  from emp
 where empno in (
            select empno
              from emp 
             where deptno = 10
             );



-- 서브쿼리에서 그룹함수 사용 
-- 평균 급여보다 적은 급여를 받는 사원 출력 . 
select *
  from emp 
 where sal < ( select avg(sal)
               from emp
              ); 
              
-- 평균 급여보다 많은 급여를 받는 사원 출력 . 
select *
  from emp 
 where sal > ( select avg(sal)
               from emp
              ); 
              
-- 다중 행 서브쿼리

select *
  from emp 
 where sal > all (
                -- 부서 10번 소속 직원의 급여. 
                select sal 
                  from emp 
                 where deptno = 10
                );
                -- 전체 직원 중 10번 부서 소속 직원의 급여보다 더 많은 급여를 받는 직원
select *
  from emp 
 where sal < any (
                -- 부서 10번 소속 직원의 급여. 
                select sal 
                  from emp 
                 where deptno = 10
                );  
                -- 부서 10번 소속 직원의 가장 큰 급여 보다 적은 급여를 받는 직원                

select * 
  from emp 
 where sal < any (300, 400, 500);
 

select * 
  from emp
 where exists (select * from emp where mgr is null);
 
 
-- 서브쿼리 테이블 생성하기 ( 복제 테이블 생성) 
drop table emp01;

create table emp01
as
select * from emp where sal > 400;

select * from emp01;

-- 서브쿼리 테이블의 구조만 복사하기 
create table emp02
as 
select * from emp where 1!=1;

select * from emp02; 


select count(*) from alpha;

create table alpha800
as 
select * 
  from alpha
 where no in ( 
            select max(no)
              from alpha
             group by line, col
                );

select * from alpha800;

-- 테이블의 구조만 복사하기
create table alpha800_1
as
select * from alpha where 1=0;

select * from alpha800_1;

insert into alpha800_1
select * from alpha where line =1 and col = 1;

select max(no) from alpha800_1 group by line, col;

-- 서브쿼리를 이용한 데이터 변경
update emp 
   set sal = (
        select max(sal)
          from emp 
         where deptno=30
   )
 where deptno = 10;
 
select * from emp where deptno = 10;

rollback;

select * from emp;

-- 서브쿼리를 이용한 데이터 삭제
delete from emp;
select * from emp;
rollback;

delete from emp 
 where deptno = (select deptno from dept where dname = '영업부');
rollback;



--======================================

create table random (
    no number, 
    cnt number
);


select * from random;

select * 
  from random
 order by no;
 
select count(*) from random;
select count(distinct no) from random;

delete from random;

commit;
rollback;

update random
   set cnt= (select cnt from random where no = 1) + 1 
 where no = 1;




-- at programming, insert or update about random number 1~1000.
-- if there number missing , you should insert the number 
-- otherwise you may update the number of count (cnt) 
-- the count is working until the row number will be 1000. 
-- the for function )cycling of code will be finish.
-- forcount = (cnt)sum 

