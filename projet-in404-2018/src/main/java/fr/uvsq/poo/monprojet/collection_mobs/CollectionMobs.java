package collection_mobs;

import java.io.Serializable;
import java.util.ArrayList;

import classe_Perso.TypeClass;
import paquet_principal.*;

public class CollectionMobs implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<Mob> l;
	int i,j;
	
	// constructeur : génère mobs aléatoires
	public CollectionMobs(Affichage aff, int lvl){
		l = new ArrayList<Mob>();
		
		i = 1 +(2*lvl);
		j = 2 +(2*lvl);
		
		// différents types de mobs sont générés et stockés dans la liste l en fonction du niveau
		for (int i=0; i<randomMinMax(i,j); i++){
			Mob m = new Mob();
			m.setTypeClass(TypeClass.ARCHER);
			m.setlvl(lvl);
			l.add(m);
			aff.afficherArcher(randomMinMax(3,16),randomMinMax(3,16),m);
		}
		for (int i=0; i<randomMinMax(i,j); i++){
			Mob m = new Mob();
			m.setTypeClass(TypeClass.MAGE);
			m.setlvl(lvl);
			l.add(m);
			aff.afficherMage(randomMinMax(3,16),randomMinMax(3,16),m);
		}
		for (int i=0; i<randomMinMax(i,j); i++){
			Mob m = new Mob();
			m.setTypeClass(TypeClass.GUERRIER);
			m.setlvl(lvl);
			l.add(m);
			aff.afficherGuerrier(randomMinMax(3,16),randomMinMax(3,16),m);
		}
	}
	
	// accesseur
	public ArrayList<Mob> getList(){
		return l;
	}
	
	// méthode random
	public int randomMinMax(int min, int max){
		int range = (max-min) +1;
		return (int)(Math.random()*range) + min;
	}
	
	// méthode combat des mobs : tous les mobs de la liste attaquent le joueur s'ils le peuvent
	public void combattre(Perso joueur) throws InterruptedException{		
		for(Mob m : this.l) {
			if(m.canAttack(joueur)) {
				System.out.println("Un mob vous attaque !");
				m.attaquer(joueur);
				System.out.println("Vous avez perdu "+ m.getType().getDegats()+" points de vie");	
				Thread.sleep(1000);
			}
		}
	}
}
