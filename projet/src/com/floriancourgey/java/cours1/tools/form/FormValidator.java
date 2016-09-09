package com.floriancourgey.java.cours1.tools.form;

/**
 * Représente UNE seule règle avec
 * - une méthode handle()
 *		qui crée ou non l'erreur
 * - une méthode getError()
 * 		qui retourne l'erreur
 * 
 * @author florian
 *
 */
public abstract class FormValidator {
	protected String error = null;
	public String getError(){
		return error;
	}
	public boolean isValid(){
		return error == null;
	}
	public abstract void handle(String value);
}
