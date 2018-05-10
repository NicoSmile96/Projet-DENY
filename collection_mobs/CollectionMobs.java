package collection_mobs;

import java.util.ArrayList;

import classe_Perso.TypeClass;
import paquet_principal.*;

public class CollectionMobs {
	private ArrayList<Mob> l;
	
	// constructeur : génère mobs aléatoires
	public CollectionMobs(Affichage aff){
		l = new ArrayList<Mob>();
		
		// différents types de mobs sont générés et stockés dans la liste l
		for (int i=0; i<randomMinMax(1,4); i++){
			Mob m = new Mob();
			m.setTypeClass(TypeClass.ARCHER);
			l.add(m);
			aff.afficherArcher(randomMinMax(3,18),randomMinMax(3,18),m);
		}
		for (int i=0; i<randomMinMax(1,4); i++){
			Mob m = new Mob();
			m.setTypeClass(TypeClass.MAGE);
			l.add(m);
			aff.afficherMage(randomMinMax(3,18),randomMinMax(3,18),m);
		}
		for (int i=0; i<randomMinMax(1,4); i++){
			Mob m = new Mob();
			m.setTypeClass(TypeClass.GUERRIER);
			l.add(m);
			aff.afficherGuerrier(randomMinMax(3,18),randomMinMax(3,18),m);
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
	public void combattre(Perso joueur) {
		for(Mob m : this.l) {
			if(m.canAttack(joueur)) {
				System.out.println("Un mob vous attaque !");
				m.attaquer(joueur);
				System.out.println("Vous avez perdu "+ m.getDegats()+" points de vie");	
			}
		}
	}
}
