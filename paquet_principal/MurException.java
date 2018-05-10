package paquet_principal;
public class MurException extends Exception {

	private static final long serialVersionUID = 1L;

	public MurException(Grille g,Joueur j,int a, int b) throws InterruptedException
	{
		System.out.println("Aie le mur !");
		Thread.sleep(1000);
		j.p.setI(j.p.getI()-a);
		j.p.setJ(j.p.getJ()-b);
		g.setCase(j.p.getI(),j.p.getJ(),Element.PERSONNAGE);
	}
}
