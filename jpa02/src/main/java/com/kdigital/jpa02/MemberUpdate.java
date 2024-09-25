package com.kdigital.jpa02;

import com.kdigital.jpa02.entity.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MemberUpdate {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpastudy");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			// 수정하고자 하는 데이터를 find한다.
			Member member = manager.find(Member.class,"04@naver.com");
			if(member == null) {
				System.out.println("수정하려는 데이터가 없습니다");
			}else {
				member.setName("정우성");
				member.setAge(21);
				System.out.println("수정 완료");
			}
			tx.commit();
		}catch (Exception e){
			tx.rollback();
			e.printStackTrace();
			
		}finally {
			manager.close();
		}
		factory.close();
	}

}