package paquet_principal;

public class Mob extends Perso{
	private static final long serialVersionUID = 1L;

	// Constructeur par defaut
	public Mob()
	{
		this.lvl = 1;
		this.argent = 3*lvl;
		this.vie = 3*lvl;
		this.vieMax = 3*lvl;
		this.objetsMax = 1;
		this.degats = this.t.getDegats()*lvl;
		this.range = this.t.getRange();
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
	
	//Constructeur en fonction du palier
	public Mob(int palier)
	{
		this.lvl = 1*palier;
		this.argent = 5*lvl;
		this.vie = this.getVie()*lvl;
		this.vieMax = this.getVieMax()*lvl;
		this.objetsMax = 5*lvl;
		this.degats = this.t.getDegats()*lvl;
		this.range = this.t.getRange();
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
