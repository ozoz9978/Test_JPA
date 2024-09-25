package com.kdigital.exam.service;

import java.util.List;

import com.kdigital.exam.entity.Cashbook;
import com.kdigital.exam.entity.TotalAmount;

public interface CashbookService {
	public boolean insert(Cashbook cashbook);
	public boolean delete(int id);
	public List<Cashbook> selectData(String date);  // 월별 내역 조회
	public List<TotalAmount> statistics(String date);
}
