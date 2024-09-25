package com.kdigital.exam.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.kdigital.exam.entity.Cashbook;
import com.kdigital.exam.entity.TotalAmount;
import com.kdigital.exam.util.MyEntityManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class CashbookServiceImpl implements CashbookService{

	@Override
	public boolean insert(Cashbook cashbook) {
		EntityManager manager = MyEntityManager.getManager();
		EntityTransaction tx  = manager.getTransaction();

		try {
			tx.begin();

			manager.persist(cashbook);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			manager.close();
		}
		return true;		
	}


	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cashbook> selectData(String date) {
		List<Cashbook> list = new ArrayList<>();
		
		EntityManager manager = MyEntityManager.getManager();
		EntityTransaction tx  = manager.getTransaction();

		
		String query = "select c from Cashbook c where date_format(today, '%Y-%m') = :date"; 
		try {
			tx.begin();

			TypedQuery<Cashbook> tq = manager.createQuery(query, Cashbook.class); 
			
			tq.setParameter("date", date);
			
			list = tq.getResultList();
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();

		} finally {
			manager.close();
		}
		return list;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TotalAmount> statistics(String date) {
		List<TotalAmount> list = new ArrayList<>();
		EntityManager manager = MyEntityManager.getManager();
		EntityTransaction tx  = manager.getTransaction();
		
		String query = "select item_type, sum(amount) "
				+ "from jpatest.cashbook "
				+ "where date_format(today,'%Y-%m') = :date "
				+ "group by item_type ";
		try {
			tx.begin();
			
			Query tq = manager.createNativeQuery(query);
			tq.setParameter("date", date);

			List<Object[]> l = tq.getResultList();

			for (Object[] obj : l) {
				list.add(new TotalAmount((String)obj[0], ((BigDecimal)obj[1]).intValue()) );
			}
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			manager.close();
		}
		return list;		
	}

}


