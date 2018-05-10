package paquet_principal;
import java.util.*;
import classe_Perso.*;

public class Jeu {
	
	public Jeu() throws InterruptedException 
	{
		Affichage aff = new Affichage();
		Scanner scan = new Scanner(System.in);
		int i;
		
		//Initialisation du joueur
		Joueur j = new Guerrier();
		aff.afficherJoueur(2,2,j);
		
		//Collection des mobs de la carte
		ArrayList<Mob> ar = new ArrayList<Mob>();
		ArrayList<Mob> ma = new ArrayList<Mob>();
		ArrayList<Mob> ge = new ArrayList<Mob>();
		
		//Initialisation des mobs de maniere aleatoire
		for (i=0;i<randomMinMax(1,4);i++)
		{
			
			Mob m = new MobArcher();
			ar.add(m);
			aff.afficherArcher(randomMinMax(3,18),randomMinMax(3,18),ar.get(i));
			
		}
		
		for (i=0;i<randomMinMax(1,4);i++)
		{	
			Mob m = new MobMage();
			ma.add(m);
			aff.afficherMage(randomMinMax(3,18),randomMinMax(3,18),ma.get(i));
		}
		
		for (i=0;i<randomMinMax(1,4);i++)
		{
			
			Mob m = new MobGuerrier();
			ge.add(m);
			aff.afficherGuerrier(randomMinMax(3,18),randomMinMax(3,18),ge.get(i));
		}
	
		//Boucle du jeu
		for (i=0;i<20;i++)
		{
			aff.afficherGrille();
			aff.etatHUDj(j);
			
			//Combat
			for (i=0;i<ar.size();i++)
			{	
				if(ar.get(i).canAttack(j))
				{
					System.out.println("L'archer vous attaque !");
					ar.get(i).attaquer(j);
					System.out.println("Vous avez perdu "+ar.get(i).degats+" points de vie");
				}
				
				if(j.canAttack(ar.get(i)))
				{
					System.out.println("Attaquer archer : at");
					String attaque = scan.nextLine();
					if(attaque.equals("at"))
					{
						j.attaquer(ar.get(i));
						System.out.println("Vous l'avez blesse !");
						aff.etatHUDm(ar.get(i));
						Thread.sleep(500);
					}
				}
			}
			for (i=0;i<ma.size();i++)
			{
				if(ma.get(i).canAttack(j))
				{
					System.out.println("Le mage vous attaque !");
					ma.get(i).attaquer(j);
					System.out.println("Vous avez perdu "+ma.get(i).degats+" points de vie");
				}
				
				if(j.canAttack(ma.get(i)))
				{
					System.out.println("Attaquer mage : at");
					String attaque = scan.nextLine();
					if(attaque.equals("at"))
					{
						j.attaquer(ma.get(i));
						System.out.println("Vous l'avez blesse !");
						aff.etatHUDm(ma.get(i));
						Thread.sleep(500);
					}
				}
			}
			for (i=0;i<ge.size();i++)
			{
				if(ge.get(i).canAttack(j))
				{
					System.out.println("Le guerrier vous attaque !");
					ge.get(i).attaquer(j);
					System.out.println("Vous avez perdu "+ge.get(i).degats+" points de vie");
				}
				
				if(j.canAttack(ge.get(i)))
				{
					System.out.println("Attaquer guerrier : at");
					String attaque = scan.nextLine();
					
					if(attaque.equals("at"))
					{
						j.attaquer(ge.get(i));
						System.out.println("Vous l'avez blesse !");
						aff.etatHUDm(ge.get(i));
						Thread.sleep(500);
					}
				}
			}
			
			
			System.out.println("Deplacement : Z Haut Q Gauche S Bas D Droite ");
			char d = scan.next().charAt(0);
			scan.nextLine();
			aff.deplacement(j,d);
			System.out.println("\n\n\n\n\n\n");
			
		}
	}
	
	public int randomMinMax(int min, int max)
	{
		int range = (max-min) +1;
		return (int)(Math.random()*range) + min;
	}
	
}
