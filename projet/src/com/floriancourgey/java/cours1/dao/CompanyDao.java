package com.floriancourgey.java.cours1.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.floriancourgey.java.cours1.HibernateUtils;
import com.floriancourgey.java.cours1.models.Company;

public class CompanyDao {
	
	/**
	 * Fetch la liste des companies depuis la bdd
	 * @return ArrayList<Company>
	 */
	public ArrayList<Company> getCompanies(){
		Session session = HibernateUtils.currentSession();
		List<Company> list = (List<Company>)session.createQuery("from Company").getResultList();
		session.close();
		return (ArrayList<Company>)list;
	}
}
