-- 사용자 계정 생성 (jpauser)
DROP USER 'jpauser'@'localhost';
CREATE USER 'jpauser'@'localhost' identified BY 'jpauser';

DROP USER 'jpauser'@'%';
CREATE USER 'jpauser'@'%' identified BY 'jpauser';

-- 권한 부여
GRANT ALL PRIVILEGES ON jpatest.* TO 'jpauser'@'localhost';
GRANT ALL PRIVILEGES ON jpatest.* TO 'jpauser'@'%';


CREATE TABLE jpatest.survey
(
	id varchar(10) PRIMARY KEY 
	, name varchar (50)
);

CREATE TABLE jpatest.question
(
	id varchar(10) PRIMARY KEY
	, survey_id varchar(10) REFERENCES jpatest.survey(id) -- fk
	, title varchar(50)

);
