-- 데이터 베이스 생성
DROP  DATABASE  jpatest;
create database jpatest character set utf8mb4;

-- 사용자 계정 생성 (jpauser)
drop user 'jpauser'@'localhost';
create user 'jpauser'@'localhost' identified by 'jpauser';

drop user 'jpauser'@'%';
create user 'jpauser'@'%' identified by 'jpauser';

-- 권한 부여
grant all privileges on jpatest.* to 'jpauser'@'localhost';
grant all privileges on jpatest.* to 'jpauser'@'%';

-- 샘플 테이블 생성 (Java jpa_exam 프로젝트와 연동하는 테이블의 생성)
DROP TABLE jpatest.cashbook;
CREATE TABLE jpatest.cashbook
(
	seq int AUTO_INCREMENT PRIMARY KEY 
	, today datetime DEFAULT current_timestamp
	, item_type varchar(20)
	, detail varchar(200) NOT NULL 
	, amount int 
	, note varchar(500)
);

SELECT * FROM jpatest.cashbook;

