package paquet_principal;

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
		}
		
		//constructeur avec argument
		public Joueur(int arg,int Vie, int viemax, int Degats, int ObjetsMax, int lvl, int xp, int xpmax) 
		{
			this.argent = arg;
			this.vie = Vie;
			this.vieMax = viemax;
			this.degats = Degats;
			this.objetsMax = ObjetsMax;
			this.lvl = lvl;
			this.xp = xp;
			this.xpMax = xpmax;
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
		
		
		//setter
		
		
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

		public void utiliserPotion() 
		{
				setVie(vie+10);
				if (vie>vieMax) 
				{
					setVie(vieMax);
				}
		}
		

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
		
		public void deplacerJoueur(Grille g, char deplacement)  throws MurException
		{	
			int i = 0, j = 0;
			
			if(deplacement == 'z') 			j++;
			else if(deplacement== 's') 		j--;
			else if(deplacement == 'q')		i--;
			else if(deplacement == 'd') 	i++;
			else if(deplacement == 'x')
			{
				i=0;
				j=0;
			}
		
		
			if(deplacementAutorise(i,j,g.getLignes(),g.getColonnes()))
			{
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
			
	
		
}