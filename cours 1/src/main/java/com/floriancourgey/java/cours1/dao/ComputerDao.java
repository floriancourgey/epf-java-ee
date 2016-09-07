package com.floriancourgey.java.cours1.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.floriancourgey.java.cours1.HibernateUtils;
import com.floriancourgey.java.cours1.models.Computer;

public class ComputerDao {
	
	/**
	 * Fetch la liste des computers depuis la bdd
	 * @return ArrayList<Computer>
	 */
	public ArrayList<Computer> getComputers(){
		Session session = HibernateUtils.currentSession();
		List<Computer> list = (List<Computer>)session.createQuery("from Computer").getResultList();
		session.close();
		return (ArrayList<Computer>)list;
	}
}
