package fr.deny.jvpr_;

import java.util.*;

public class Grille {

	private int lignes;
	private int colones;
	private char [][] grille;
	
	


	public Grille (int l, int c) {

		lignes =l;
		colones =c;
		grille = new char [lignes][colones];
		
		for (int i =0; i<lignes; i++) {
			for(int j =0; j<colones; j++) {
				
				grille[i][j] = '.'; //sol
				
			}
		}
	}
	
	public char getCase(int l, int c) {
		return grille[l-1][c-1];
		
	}
	
	public void afficher() {
		System.out.println();
		for (int i =0; i<lignes; i++) {
			//System.out.print("x");
			for(int j =0; j<colones; j++) {
				
				System.out.print(" " + grille[i][j]);
				
			}
			System.out.println(" ");
		}
		
		System.out.println();

	}
	
	public void placer(int l, int c, char t) {
		l = l-1;
		c = c-1;
		//test si dans la grille
		if (l<0 || c<0 || l>lignes ||c>colones) {
			System.out.print("erreur : hors grille");
			return;
		}
		if (grille[l][c] == '.') {
			grille[l][c] = t;
		}
		else {
			System.out.print("erreur non vide");
		}
	}	
	public void monter() {
		
		char tmp;
		for (int i =0; i<lignes; i++) {
			for(int j =0; j<colones; j++) {
				if (grille[i][j] == '@') { //trouve la case du joueur @
					if (i-1 >=0 && grille[i-1][j] == '.') { //si on peu avancer 
						tmp = grille[i][j]; //copie @
						grille[i][j] = '.'; //vide la case de @
						grille[i-1][j] =tmp; // @ bouge
					}
				}
			}
		}	
	}
	
	public void decendre() {
		
		char tmp;
		for (int i =0; i<lignes; i++) {
			for(int j =0; j<colones; j++) {
				if (grille[i][j] == '@') { //trouve la case du joueur @
					if (i+1 <=lignes && grille[i+1][j] == '.') { //si on peu avancer 
						tmp = grille[i][j]; //copie @
						grille[i][j] = '.'; //vide la case de @
						grille[i+1][j] =tmp; // @ bouge
					}
				}
			}
		}	
	}

	public void avancerDroite() {
	
		char tmp;
		for (int i =0; i<lignes; i++) {
			for(int j =0; j<colones; j++) {
				if (grille[i][j] == '@') { //trouve la case du joueur @
					if (j+1 <=colones && grille[i][j+1] == '.') { //si on peu avancer 
						tmp = grille[i][j]; //copie @
						grille[i][j] = '.'; //vide la case de @
						grille[i][j+1] =tmp; // @ bouge
					}
				}
			}
		}	
	}

	public void avancerGauche() {
	
		char tmp;
		for (int i =0; i<lignes; i++) {
			for(int j =0; j<colones; j++) {
				if (grille[i][j] == '@') { //trouve la case du joueur @
					if (j-1 >=0 && grille[i][j-1] == '.') { //si on peu avancer 
						tmp = grille[i][j]; //copie @
						grille[i][j] = '.'; //vide la case de @
						grille[i][j-1] =tmp; // @ bouge
					}
				}
			}
		}	
	}
}