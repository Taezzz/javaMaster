create table book(
    bNo number primary key,
    bName varchar2(30) not null,
    writer varchar2(20) not null,
    price number not null,
    stock number not null
);
create sequence book_seq;

alter table book
modify writer varchar2(50);


insert into book
values(book_seq.nextval, '绢赴空磊', '辫历磊',15000, 3);
insert into book
values(book_seq.nextval, '备款根', '捞历磊',12000, 1);
insert into book
values(book_seq.nextval, '冕氢傈', '冠历磊',12000, 5);

select * from book;

drop table member;

create table member(
    mNo number primary key,
    mName varchar2(15) not null,
    phone number,
    sex varchar2(3),
    birthday varchar2(15),
    loan varchar2(3)
);
create sequence member_seq;

insert into member
values(member_seq.nextval, '辫己怕', '01057929118', '巢', '98-05-11','O');

insert into member
values(member_seq.nextval, '捞己怕', '01057929318', '巢', '96-05-11','X');

insert into member
values(member_seq.nextval, '冠己怕', '01057319118', '巢', '90-01-11','O');

insert into member
values(member_seq.nextval, '碍己怕', '01057929118', '巢', '98-05-11','O');

commit;

select * from member;

SELECT * FROM book WHERE bName = '单固救救';

SELECT * FROM member;

delete from member where mNo = 46  and loan = 'X';


create table loan(
    mNo number ,
    mName varchar2(30),
    bNo number,
    bName varchar2(30),
    FOREIGN KEY (mNo)
    REFERENCES member(mNo)
    ON DELETE CASCADE,
    FOREIGN KEY (bNo)
    REFERENCES book(bNo)
    ON DELETE CASCADE
);

drop table loan;
select * from loan;
select * from book;
select * from member;

insert into loan
values(61, '碍己怕', 2, '备款根根根');
insert into loan
values(62, '碍己怕', 3, '备款根根根');

update member set loan = 'X' where mNo = 61;

select * from member;

commit;

select * from loan;

update member set loan = 'X' where not exists(select * from loan where mNo = 45);

select * from member;

