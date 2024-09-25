-- 사용자 계정 생성 (jpauser)
DROP USER 'jpauser'@'localhost';
CREATE USER 'jpauser'@'localhost' identified BY 'jpauser';

DROP USER 'jpauser'@'%';
CREATE USER 'jpauser'@'%' identified BY 'jpauser';

-- 권한 부여
GRANT ALL PRIVILEGES ON jpatest.* TO 'jpauser'@'localhost';
GRANT ALL PRIVILEGES ON jpatest.* TO 'jpauser'@'%';

-- 샘플데이터 생성 (java jpa04 프로젝트와 연동하는 테이블의 생성)
DROP TABLE jpatest.hotel_1;

CREATE TABLE jpatest.hotel_1
(
	hotel_id varchar(50) PRIMARY KEY
	,name varchar(50)
	,created_date datetime -- 호텔오픈일 
	,grade varchar(2)
);

SELECT * FROM jpatest.hotel_1;