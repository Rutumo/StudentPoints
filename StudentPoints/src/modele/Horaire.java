package modele;

import java.util.ArrayList;
import java.util.List;

public class Horaire {

	private List<FaireInterrogartion> interro;
	
	public Horaire() {
		interro = new ArrayList<FaireInterrogartion>();
	}
	
	public void addCours(FaireInterrogartion fi) {
		interro.add(fi);
	}
	
	public FaireInterrogartion getCours(int index) {
		return interro.get(index);
	}
	
	public FaireInterrogartion removeCours() {
		return interro.remove(0);
	}
	
}
 