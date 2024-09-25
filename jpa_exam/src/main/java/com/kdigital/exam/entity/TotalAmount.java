package com.kdigital.exam.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TotalAmount {
	private String itemType;
	private int total;
	@Override
	public String toString() {
		return String.format("%10s\t%,10d원 ", itemType, total);
	}

	
}
