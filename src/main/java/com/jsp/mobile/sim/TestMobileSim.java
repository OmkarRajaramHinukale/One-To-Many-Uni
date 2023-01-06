package com.jsp.mobile.sim;


import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestMobileSim {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Omkar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Mobile m1=new Mobile();
		m1.setName("Note 11 pro");
		m1.setBrand("Redmi");
		m1.setPrice(17000);
		
		Sim s1=new Sim();
		s1.setService("Airtel");
		s1.setService_type("5G");
		
		Sim s2=new Sim();
		s2.setService("Vi");
		s2.setService_type("5G");
		
		List<Sim> sim=new ArrayList();
		sim.add(s1);
		sim.add(s2);
		
		m1.setSim(sim);
		
		entityTransaction.begin();
		entityManager.persist(m1);
		entityManager.persist(s1);
		entityManager.persist(s2);
		entityTransaction.commit();
		
		System.out.println("all good");
		
		
		
	}

}
