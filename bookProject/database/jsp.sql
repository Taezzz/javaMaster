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
values(book_seq.nextval, '�����', '������',15000, 3);
insert into book
values(book_seq.nextval, '�����', '������',12000, 1);
insert into book
values(book_seq.nextval, '������', '������',12000, 5);

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
values(member_seq.nextval, '�輺��', '01057929118', '��', '98-05-11','O');

insert into member
values(member_seq.nextval, '�̼���', '01057929318', '��', '96-05-11','X');

insert into member
values(member_seq.nextval, '�ڼ���', '01057319118', '��', '90-01-11','O');

insert into member
values(member_seq.nextval, '������', '01057929118', '��', '98-05-11','O');

commit;

select * from member;

SELECT * FROM book WHERE bName = '���̾Ⱦ�';

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
values(61, '������', 2, '���������');
insert into loan
values(62, '������', 3, '���������');

update member set loan = 'X' where mNo = 61;

select * from member;

commit;

select * from loan;

update member set loan = 'X' where not exists(select * from loan where mNo = 45);

select * from member;

