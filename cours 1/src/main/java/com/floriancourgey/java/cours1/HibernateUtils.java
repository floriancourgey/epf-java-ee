package com.floriancourgey.java.cours1;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.floriancourgey.java.cours1.models.Company;
import com.floriancourgey.java.cours1.models.Computer;

public class HibernateUtils {
	private static final SessionFactory sessionFactory;

	static {
	   try {
		   // Crée la SessionFactory
		   Configuration configuration = new Configuration()
				   .addPackage("com.floriancourgey.java.cours1.models")
				   .addAnnotatedClass(Computer.class)
				   .addAnnotatedClass(Company.class)
				   ;
		   configuration.configure();
		   sessionFactory = configuration.buildSessionFactory();
	   	} catch (HibernateException ex) {
		   throw new RuntimeException("Problème de configuration : "+ ex.getMessage(), ex);
	   	}
	 }

	 public static final ThreadLocal session = new ThreadLocal();

	 public static Session currentSession()
	                throws HibernateException {
	   Session s = (Session) session.get();
	   // Ouvre une nouvelle Session, si ce Thread n'en a aucune
	   if (s == null) {
	   s = sessionFactory.openSession();
	   session.set(s);
	   }
	   return s;
	   }

	 public static void closeSession()
	                throws HibernateException {
	   Session s = (Session) session.get();
	   session.set(null);
	   if (s != null)
	   s.close();
	   }
}
