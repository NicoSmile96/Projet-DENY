package paquet_principal;
import java.io.*;

public class Save {
	// objets stream
	ObjectOutputStream oos;
	 
	// constructeur vide
	public Save() {}
	
	// ouvrir flux sortie
	private void openOutput() {
	    // try
	    try {
	      oos = new ObjectOutputStream(
	              new BufferedOutputStream(
	                new FileOutputStream(
	                  new File("sauvegarde.txt"))));
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	// écriture fichier
	private void write(Object o) {
		try {
			oos.writeObject(o);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	// fermeture
	private void closeOutput() {
		try {
			oos.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// sauvegarder objet o dans fichier
	public void save(Object o){
		openOutput();
		write(o);
		closeOutput();
	}
}

