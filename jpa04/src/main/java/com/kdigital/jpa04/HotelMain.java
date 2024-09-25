package com.kdigital.jpa04;

import java.time.LocalDate;

import com.kdigital.jpa04.entity.Grade;
import com.kdigital.jpa04.entity.Hotel;
import com.kdigital.jpa04.util.MyEntityManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class HotelMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hotel hotel = new Hotel("h02","인터콘티넨탈호텔",LocalDate.of(1991, 12, 20), Grade.S2);
		insert(hotel);

	}
	private static void insert(Hotel hotel) {
		EntityManager manager = MyEntityManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			manager.persist(hotel);
			System.out.println("저장완료");
			
			
			
			tx.commit();
		}catch(Exception e) {
			System.out.println("저장실패");
			tx.rollback();
			e.printStackTrace();
			
		}finally {
			manager.close();
		}
		
	}

}