package com.kdigital.jpa03.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MyEntityManager {
	private static EntityManagerFactory factory;
	//스태틱블록 : private 이면서 static 변수를 초기화
	static {
		factory = Persistence.createEntityManagerFactory("jpastudy");
	}
	public static EntityManager getManager() {
		return factory.createEntityManager();
	}
	public static void close() {
		factory.close();
	}
	
}
