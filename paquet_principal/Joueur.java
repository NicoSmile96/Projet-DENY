package paquet_principal;
import java.util.Scanner;
import java.util.*;


public class Joueur extends Perso{
	
	private int xp;
	private int xpMax;
	private int armure;

		// constructeur par defaut
		public Joueur() 
		{
			this.argent = 0;
			this.vie = 10;
			this.vieMax = 10;
			this.objetsMax = 5;
			this.lvl = 1;
			this.xp = 0;
			this.xpMax = 10;
			this.degats = this.t.getRange();
			this.range = this.t.getRange();
			this.nbPotion = 0;
		}
		
		//constructeur avec argument
		public Joueur(int arg,int Vie, int viemax, int Degats, int ObjetsMax, int lvl, int xp, int xpmax,int nbPotion) 
		{
			this.argent = arg;
			this.vie = Vie;
			this.vieMax = viemax;
			this.degats = Degats;
			this.objetsMax = ObjetsMax;
			this.lvl = lvl;
			this.xp = xp;
			this.xpMax = xpmax;
			this.nbPotion = nbPotion;
		}
		
		
		// getter
		public int getArmure() 
		{
			return armure;
		}
		
		public int getXp()
		{
			return xp;
		}
		
		public int getXpMax()
		{
			return xpMax;
		}	
		
		// setter
		public void setArmure(int arm) 
		{
			this.armure = arm;
		}
		
		public void setxp(int xp) 
		{
			this.xp = xp;
		
		}
		
		public void setxpMax(int xpmax) 
		{
			this.xpMax = xpmax;
		
		}
		
		//redéfinition des méthodes d'interface

		// potion
		public void utiliserPotion() 
		{
				setVie(vie+10);
				if (vie>vieMax) 
				{
					setVie(vieMax);
				}
		}
		
		// level up
		public void lvlUp() 
		{
			if (this.getXp() == this.getXpMax())
			{ 
				setVieMax(this.vieMax+10); //augmentation des Pv de base
				setDegats(this.degats+10); // augmentation des degats de base
				setxp(0); 
				setxpMax(this.xpMax+10); //augmentation de la barre d'xp
				setlvl(this.lvl+1);
			}
		}
		
		//looter 
		public void looter(Grille g) {
			if(g.getCase(this.p.getI(),this.p.getJ()) == Element.LOOT) 
			{
				
				this.argent = this.argent + 10;
				this.nbPotion = this.nbPotion + 1; 
				System.out.println("vous avez gagné " + 10 + "Pieces et " + 1 + " Potions");
			}
		}
		
		// déplacer
		public void deplacerJoueur(Grille g)  throws MurException
		{	
			int i = 0, j = 0;
			Scanner sc = new Scanner(System.in);
			char d = sc.next().charAt(0);
			
			if(d == 'z') 		j++;
			else if(d == 's') 	j--;
			else if(d == 'q')	i--;
			else if(d == 'd') 	i++;
			else if(d == 'x') 	{};
			
			if(!deplacementAutorise(g,i,j)) {
				System.out.println("Deplacement non autorise");
				deplacerJoueur(g);
			}
			else{
//				sc.close();
				g.setCase(this.p.getI(),this.p.getJ(),Element.VIDE);
				this.p.setI(p.getI()+i);
				this.p.setJ(p.getJ()+j);
				
				if(g.getCase(this.p.getI(),this.p.getJ()) == Element.MUR)
				{
					try {
							throw new MurException(g,this,i,j);
							
						} catch(InterruptedException e) {}
				}
				
				g.setCase(this.p.getI(),this.p.getJ(),Element.PERSONNAGE);
			}
		}
		
		// combattre
		void combattre(ArrayList<Mob> l, Affichage aff) {
			for(int i = 0; i<l.size(); i++) {
				Mob m = l.get(i);
				
				if(this.canAttack(m)) {
					Scanner sc = new Scanner(System.in);
					System.out.println("Attaquer mob : at");
					String attaque = sc.nextLine();
					if(attaque.equals("at")){
						this.attaquer(m);
						System.out.println("Vous l'avez blesse !");
						aff.etatHUDm(m);
						if(m.getVie() <= 0)
						{
							l.remove(i);
							aff.supprimerMob(m.p.getI(),m.p.getJ());
							aff.afficherGrille();
							aff.etatHUDj(this);
							System.out.println("Vous l'avez tue !");
							
						}
					}
					
//					sc.close();
				}
			}
			
		}
}

