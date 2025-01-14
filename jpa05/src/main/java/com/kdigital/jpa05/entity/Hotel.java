package com.kdigital.jpa05.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString



@Entity
@Table(name="hotel_05")
public class Hotel {
	@Id
	@Column(name="hotel_id")
	private String hotelId;
	private String name;
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	@Enumerated(EnumType.STRING)
	private Grade grade;
	
	@Embedded
	private Address address;
}
// address 클래스 포함
/*
CREATE TABLE jpatest.hotel_1
(
	hotel_id varchar(50) PRIMARY KEY
	,name varchar(50)
	,created_date datetime -- 호텔오픈일 
	,grade varchar(2)
);

SELECT * FROM jpatest.hotel_1;


*/
