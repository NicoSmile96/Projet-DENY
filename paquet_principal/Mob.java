package paquet_principal;

public class Mob extends Perso{
	
	
	// Constructeur par defaut
	public Mob()
	{
		this.argent = 0;
		this.vie = 5;
		this.vieMax = 5;
		this.objetsMax = 2;
		this.lvl = 1;
	}
	
	//Constructeur avec arguments
	public Mob(int arg,int Vie, int viemax, int Degats, int ObjetsMax, int lvl) 
	{
		this.argent = arg;
		this.vie = Vie;
		this.vieMax = viemax;
		this.degats = Degats;
		this.objetsMax = ObjetsMax;
		this.lvl = lvl;
	}
	
	
	
	//A definir 
	public void deplacer(Grille g)
	{
		
		
		
	}
	
	// A définir
	public void drop()
	{
			
	}
	
}
