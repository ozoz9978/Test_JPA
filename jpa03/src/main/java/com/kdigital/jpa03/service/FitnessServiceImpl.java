package com.kdigital.jpa03.service;

import java.util.ArrayList;
import java.util.List;

import com.kdigital.jpa03.entity.Fitness;
import com.kdigital.jpa03.util.MyEntityManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class FitnessServiceImpl implements FitnessService{

   @Override
   public boolean insert(Fitness fitness) {
      EntityManager manager = MyEntityManager.getManager();
      EntityTransaction tx = manager.getTransaction();
      
      try {
         tx.begin();
         
         manager.persist(fitness);
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
   public Fitness selectOne(int id) {
      EntityManager manager = MyEntityManager.getManager();
      EntityTransaction tx = manager.getTransaction();
      
      Fitness fitness = null;
      
      try {
         tx.begin();
         
         fitness = manager.find(Fitness.class, id);
         
         tx.commit();
      } catch (Exception e) {
         tx.rollback();
         e.printStackTrace();
      } 
      return fitness;
      
   }

   @Override
   public boolean update(Fitness fitness) {
	   EntityManager manager = MyEntityManager.getManager();
	   EntityTransaction tx = manager.getTransaction();
	   
	   try {
		   tx.begin();
		   Fitness f = manager.find(Fitness.class, fitness.getId());
		   if(f == null) return false;
		   
		   f.setWeight(fitness.getWeight());
		   f.setHeight(fitness.getHeight());
		   tx.commit();
		   
	   } catch(Exception e){
		   tx.rollback();
		   e.printStackTrace();
		   
	   }finally {
		   manager.close();
	   }
	   
	   return true;
   }

   @Override
   public boolean delete(int id) {
      EntityManager manager = MyEntityManager.getManager();
      EntityTransaction tx = manager.getTransaction();
      
      Fitness fitness = null;
      
      try {
         tx.begin();
         
         fitness = manager.find(Fitness.class, id);
         if (fitness == null)  {
        	 return false; 
         }
         manager.remove(fitness);
         tx.commit();
      
      } catch (Exception e) {
         tx.rollback();
         e.printStackTrace();
      } finally {
    	  manager.close();
      }
      return true;
   }
   //JPQL(JAVA PERSISTENCE QUERY LANGUAGE) 을 사용해야 다양한 쿼리문을 실행시킬 수 있다
   @Override
   public List<Fitness> selectAll() {
	   EntityManager manager = MyEntityManager.getManager();
	   EntityTransaction tx = manager.getTransaction();
	   
	   List<Fitness> list = new ArrayList<>();//1개 이상의 데이터가 조회됐을 때
	   
	   try {
		   tx.begin();
		   
		   // 문자열 안의 FITNESS 는 ENTITTY 객체를 의미하므로 대소문자 정확히 써야한다
		   String query = "select f from Fitness f";
		   
		   TypedQuery <Fitness> tq = manager.createQuery(query, Fitness.class);
		   list = tq.getResultList();
		   
		   tx.commit();
		   
	   }catch(Exception e) {
		   tx.rollback();
		   e.printStackTrace();
		   
	   }
	   return list;
 
   }

}
