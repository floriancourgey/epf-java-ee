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
	public ArrayList<Company> getAll(){
		Session session = HibernateUtils.currentSession();
		List<Company> list = (List<Company>)session.createQuery("from Company").getResultList();
		session.close();
		return (ArrayList<Company>)list;
	}
	
	public Company get(long id){
		Session session = HibernateUtils.currentSession();
        Company company =  (Company) session.get(Company.class, id);
        session.close();
        return company;
	}
}
