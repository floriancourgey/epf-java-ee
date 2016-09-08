package com.floriancourgey.java.cours1.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.floriancourgey.java.cours1.HibernateUtils;
import com.floriancourgey.java.cours1.models.Computer;

public class ComputerDao {
	
	/**
	 * Fetch la liste des computers depuis la bdd
	 * @return ArrayList<Computer>
	 */
	public ArrayList<Computer> getAll(){
		Session session = HibernateUtils.currentSession();
		List<Computer> list = (List<Computer>)session.createQuery("from Computer").getResultList();
		session.close();
		return (ArrayList<Computer>)list;
	}
	
	public long save(Computer computer){
		Session session = HibernateUtils.currentSession();
		Transaction tx = session.beginTransaction();
		
		session.save(computer);
		
		tx.commit();
		session.close();
		
		return computer.getId();
	}
}
