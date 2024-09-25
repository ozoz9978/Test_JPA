package com.kdigital.exam.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name="cashbook")
public class Cashbook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seq;
	
	@CreationTimestamp
	private LocalDateTime today;
	
	@Column(name="item_type")
	@Enumerated(EnumType.STRING)
	private ItemType itemType;
	
	private String detail;
	
	private long amount;
	
	private String note;

	// 생성자 직접 정의 (insert)
	public Cashbook(ItemType itemType, String detail, Integer amount, String note) {
		this.itemType = itemType;
		this.detail = detail;
		this.amount = amount;
		this.note = note;
	}
}
