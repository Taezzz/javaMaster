-- 사원 테이블(사원번호, 사원명, 연락처, 이메일, 입사일자, 급여)
drop table emp purge;
create table emp(
    emp_no number primary key, -- emp_seq.nextval
    emp_name varchar2(40) not null,
    emp_phone varchar2(12) not null, -- 02-1234-5678
    email varchar2(30) not null,
    hire_date date default sysdate,
    salary number
);
-- CRUD (Create, Read, Update, Delete)

create sequence emp_seq;
insert into emp (emp_no, emp_name, emp_phone, email,salary)
values(emp_seq.nextval, 'kildongHong', '01-1234-5678','kildong@email',2000);
insert into emp (emp_no, emp_name, emp_phone, email,salary)
values(emp_seq.nextval, 'kildongPark', '02-1234-8765','pkildong@email',3000);

select *
from emp
order by emp_no;

update emp
set salary = salary + 500
    ,emp_phone = '01-1111-1111'
where emp_name = 'kildongPark';

delete from emp
where emp_no = 2;

commit;

drop table member;
create table member(
    mem_no number primary key,
    mem_name varchar2(15) not null,
    mem_phone varchar2(13) not null,
    mem_birth varchar2(10),
    mem_sex varchar2(3),
    mem_email varchar2(30)
);

create sequence mem_seq;
insert into member(mem_no, mem_name, mem_phone, mem_birth ,mem_sex)
values(mem_seq.nextval, '김성태', '01-1234-5678','98-05-11','남');

select * from member;




