package paquet_principal;
import java.io.*;

public class Load {
	ObjectInputStream ois;
	
	// constructeur vide
	public Load() {}
	
	// ouverture stream
	private void openInput(){
		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(
						new FileInputStream(
			                new File("sauvegarde.txt"))));
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	// fermeture stream
	private void closeInput() {
		try{
			ois.close();
		} catch(IOException e) {
		    e.printStackTrace();
		}
	}
  
	// lecture stream
	public Data load() {
		openInput();
		Data d = new Data();
		
	    try {
	    	d = (Data) ois.readObject();
	    } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    } catch(IOException e){
			e.printStackTrace();
		}
	    
	    closeInput();
	    return d;
	}
}
