package com.kdigital.jpa02;

import com.kdigital.jpa02.entity.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MemberSelect {

	public static void main(String[] args) {
		//1 
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpastudy");
		
		//2 
		EntityManager manager = factory.createEntityManager();
		
		//3
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			Member member = manager.find(Member.class, "02@naver.com");
			System.out.println(member);
			
			if (member == null) {
				System.out.println("정보를 찾지 못했습니다.");
			} else {
				System.out.println(member);
			}
			tx.commit();
			
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}finally {
			manager.close();
		}
		factory.close();
	}

}
