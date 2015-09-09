package com.formation.dao.manager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoManager {
	private static DaoManager INSTANCE = null;
	private EntityManagerFactory emf = null;
	
	private DaoManager() {
		this.emf = Persistence.createEntityManagerFactory("jee-training-PU");
	}
	
	public EntityManagerFactory getEntityManagerFactory(){
		return emf;
	}
	
	public static DaoManager getInstance(){
		if(INSTANCE == null){
			INSTANCE = new DaoManager();
		}
		return INSTANCE;
	}
}
