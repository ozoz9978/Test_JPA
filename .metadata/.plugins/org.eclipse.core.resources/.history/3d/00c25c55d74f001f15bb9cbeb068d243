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

CREATE TABLE jpatest.hotel_05
(
	hotel_id varchar(50) PRIMARY KEY -- 호텔 id
	,name varchar(50) -- 호텔명
	,created_date datetime -- 호텔오픈일 
	,grade varchar(3) -- 호텔등급
	,addr1 varchar(100) -- 첫번째 주소
	,addr2 varchar(100) -- 두번째 주소
	,zipcode varchar(10) -- 우편번호

);
CREATE TABLE jpatest.address
(
	addr1 varchar(100) -- 첫번째 주소
	,addr2 varchar(100) -- 두번째 주소
	,zipcode varchar(10) -- 우편번호

);