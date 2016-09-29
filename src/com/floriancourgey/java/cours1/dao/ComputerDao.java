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

	/**
	 * le getByGoogle permet de rechercher dans tous les champs de l'entité en LIKE %% case insensitive
	 * 
	 * par exemple la recherche 'think' donne
	 * - les ordinateurs avec le nom qui contient 'think'
	 * - les ordinateurs avec l'entreprise qui a un nom qui contient 'think'
	 * 
	 * @param google
	 * @return
	 */
	public ArrayList<Computer> getByGoogle(String google) {
		google = google.toLowerCase();
		String hql = "from Computer c where c.name LIKE :google OR c.company.name LIKE :google";
		Session session = HibernateUtils.currentSession();
		ArrayList<Computer> computers = (ArrayList<Computer>)session
			.createQuery(hql)
			.setParameter("google", "%"+google+"%")
			.getResultList();
		return computers;
	}
}
