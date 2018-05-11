package paquet_principal;
import collection_mobs.Marchand;

import java.util.Scanner;
import java.util.*;


public class Joueur extends Perso{
	private static final long serialVersionUID = 1L;
	private int xp;
	private int xpMax;
	private int armure;

		// constructeur par defaut
		public Joueur() {
			this.argent = 0;
			this.vie = this.t.getVie();;
			this.vieMax = this.t.getVieMax();
			this.objetsMax = 5;
			this.lvl = 1;
			this.xp = 0;
			this.xpMax = 10;
			this.degats = this.t.getDegats();
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
		public int getArmure(){
			return armure;
		}
		
		public int getXp(){
			return xp;
		}
		
		public int getXpMax(){
			return xpMax;
		}	
		public int getNbPotion(){
			return nbPotion;
		}	
		
		// setter
		public void setArmure(int arm) {
			this.armure = arm;
		}
		
		public void setxp(int xp) {
			this.xp = xp;
		}
		
		public void setxpMax(int xpmax) {
			this.xpMax = xpmax;
		}
		public void setNbPotions(int nbPotions) {
			this.nbPotion = nbPotions;
		}
		
		//redéfinition des méthodes d'interface
		// potion
		public void utiliserPotion() {
			setVie(vie+10);
			if (vie>vieMax) {
				setVie(vieMax);
			}
			System.out.println("Vie restaurée !");
			nbPotion--;
		}
		
		// level up
		public void lvlUp() {
			if (this.getXp() == this.getXpMax()){ 
				setVieMax(this.vieMax+10); //augmentation des Pv de base
				setVie(this.vieMax);
				setDegats(this.degats+10); // augmentation des degats de base
				setxp(0); 
				setxpMax(this.xpMax+10); //augmentation de la barre d'xp
				setlvl(this.lvl+1);
				System.out.println("Vous avez gagne un niveau !");
			}
		}
		
		//looter 		
		public void looter(Grille g) throws InterruptedException {
			this.argent = this.argent + 10;
			this.nbPotion = this.nbPotion + 1; 
			System.out.println("vous avez gagné " + 10 + "Pieces et " + 1 + " Potions");
			
			Thread.sleep(1000);
		}
		
		// déplacer
		public boolean deplacerJoueur(Grille g, String d)  throws MurException, InterruptedException{	
			int i = 0, j = 0;
			
			if(d.equals("z")) 		j++;
			else if(d.equals("s")) 	j--;
			else if(d.equals("q"))	i--;
			else if(d.equals("d")) 	i++;
			
			if(!deplacementAutorise(g,i,j)) {
				System.out.println("Deplacement non autorise");
				return false;
			}
			else{
				g.setCase(this.p.getI(),this.p.getJ(),Element.VIDE);
				this.p.setI(p.getI()+i);
				this.p.setJ(p.getJ()+j);
				
				// mur
				if(g.getCase(this.p.getI(),this.p.getJ()) == Element.MUR){
					try {
						throw new MurException(g,this,i,j);	
					} catch(InterruptedException e) {}
				}
				
				// loot
				else if(g.getCase(this.p.getI(),this.p.getJ()) == Element.LOOT) {
					this.looter(g);
				}
				
				// mettre à jour la grille perso
				g.setCase(this.p.getI(),this.p.getJ(),Element.PERSONNAGE);
			}
			
			return true;
		}
		
		// combattre
		public void combattre(ArrayList<Mob> l, Affichage aff) throws InterruptedException {
			for(int i = 0; i<l.size(); i++) {
				Mob m = l.get(i);
				
				if(this.canAttack(m)) {
					this.attaquer(m);
					System.out.println("Vous l'avez blesse !");
					aff.etatHUDm(m);
					if(m.getVie() <= 0){
						l.remove(i);
						aff.supprimerMob(m.p.getI(),m.p.getJ());
						aff.afficherGrille();
						aff.etatHUDj(this);
						System.out.println("Vous l'avez tue !");
						this.xp = xp+2;
						this.lvlUp();
					}
					Thread.sleep(1000);
				}
			}
		}
		
		// joueur en vie
		public boolean enVie()
		{
			if(this.vie>0)
				return true;
			return false;
		}
		
		// mob ou marchand in range
		public void inRange(ArrayList<Mob> l, Marchand marchand) throws NullPointerException{
			// mob en vue
			try {
				for(Mob m : l) {
					if(this.canAttack(m))
						System.out.println("Ennemi à portée ! Tapez 'attaquer' pour l'attaquer !");
				}
			} catch(NullPointerException e) {}
			
			// marchand en vue
			try {
				if(Math.abs( marchand.getPosition().getI() - this.p.getI()) <= 1 
						&& Math.abs(marchand.getPosition().getJ() - this.p.getJ()) <= 1 )
							System.out.println("Marchand à portée ! Tapez 'parler' pour lui parler");
			} catch(NullPointerException e){}
		}
		
		// surcharge inRange boolean Marchand
		public boolean inRange(Marchand marchand) throws NullPointerException{
			try {
				if(Math.abs( marchand.getPosition().getI() - this.p.getI()) <= 1 
						&& Math.abs(marchand.getPosition().getJ() - this.p.getJ()) <= 1 ) {
							return true;
				}
			} catch(NullPointerException e) {}
			
			return false;
		}

		// surcharge inRange boolean mob
		public boolean inRange(ArrayList<Mob> l) throws NullPointerException{
			try {
				for(Mob m : l) {
					if(this.canAttack(m)) {
						return true;
					}
				}
			} catch(NullPointerException e) {}
			
			return false;
		}
		
		// afficher inventaire personnage
		public void afficherInventaire() {
			System.out.println("Inventaire : \n");
            System.out.println("Potion : " +nbPotion+ "    Argent : " + argent);
		}
		
		// acheter marchand
		public void acheter(Marchand m) {
			afficherInventaire();
			m.printMarchandise();
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String nom = sc.nextLine();
			
			while(!nom.equals("quitter")) {
				for(Item i : m.getInventaire()) {
					if(nom.equals(i.getNom())) {
						if(argent >= i.getPrix()) {
							nbPotion++;
							i.diminuerQuantite(i.getQuantite()-1);
							System.out.println("Merci pour votre achat !");
							nom = "quitter";
						}
						else {
							System.out.println("Vous n'avez pas assez d'argent !");
						}
					}
					else {
						System.out.println("objet non trouvé ! ");
					}
				}
				System.out.println("tapez 'quitter' pour sortir");
				nom = sc.nextLine();
			}
		}
}

