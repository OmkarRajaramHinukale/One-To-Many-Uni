package com.jsp.person.account;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestPersonBank {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Omkar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person=new Person();
		person.setName("Omkar");
		person.setEmail("omkar@gmail.com");
		person.setPh_no(1234567890l);
		
		BankAccount bankAccount1=new BankAccount();
		bankAccount1.setBank_name("HDFC");
		bankAccount1.setAcc_no(5544655646l);
		bankAccount1.setIfsc("HDFC0123");
		
		BankAccount bankAccount2=new BankAccount();
		bankAccount2.setBank_name("HDFC");
		bankAccount2.setAcc_no(5544655646l);
		bankAccount2.setIfsc("HDFC0123");
		
		BankAccount bankAccount3=new BankAccount();
		bankAccount3.setBank_name("HDFC");
		bankAccount3.setAcc_no(5544655646l);
		bankAccount3.setIfsc("HDFC0123");
		
		List<BankAccount> bankAccount=new ArrayList();
		bankAccount.add(bankAccount1);
		bankAccount.add(bankAccount2);
		bankAccount.add(bankAccount3);
		
		person.setBankAccount(bankAccount);
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(bankAccount1);
		entityManager.persist(bankAccount2);
		entityManager.persist(bankAccount3);
		entityTransaction.commit();
		
		System.out.println("All Good");
		
	}

}
