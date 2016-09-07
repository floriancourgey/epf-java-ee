package com.floriancourgey.java.cours1;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import com.floriancourgey.java.cours1.dao.ComputerDao;
import com.floriancourgey.java.cours1.models.Computer;

public class Cours1 {
	
	private ArrayList<Computer> computers = new ArrayList<Computer>();
	private boolean continuer = true;
	private Scanner sc;
	private ComputerDao computerDao = new ComputerDao();
	
	public Cours1(){
		System.out.println("Bienvenue sur la forma du cours 1");
		sc = new Scanner(System.in);
		
		computers = computerDao.getComputers();
		
		while(continuer){
			System.out.println("Menu\n");
			System.out.println("1. Afficher les "+computers.size()+" ordinateurs");
			System.out.println("2. Ajouter un ordinateur");
//			System.out.println("3. Quitter");
			System.out.println("Votre choix ? ");
			String selection = sc.nextLine().substring(0, 1).toLowerCase();
			int iSelection = Integer.parseInt(selection);
			switch(iSelection){
			case 1 :
				index();
				break;
			case 2 :
				ajouter();
				break;
			case 3 :
				break;
			default:
				break;
			}
			
			System.out.println("Voulez-vous continuer ? (o)/n");
			continuer = sc.nextLine().toLowerCase().charAt(0) == 'o';
		}
	}
	
	/**
	 * Affiche la liste des computers
	 */
	private void index(){
		System.out.println("Liste des ordinateurs");
		for(Computer computer : computers){
			System.out.println(computer.getCompany());
		}
	}
	
	/**
	 * Permet d'ajouter un computer
	 */
	private void ajouter(){
		System.out.println("Ajouter un ordinateur");
	}
}
