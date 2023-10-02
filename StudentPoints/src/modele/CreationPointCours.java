package modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.w3c.dom.stylesheets.LinkStyle;

public class CreationPointCours {
	
	List<FaireInterrogartion> interro;
	
	public CreationPointCours() {
		interro = new ArrayList<FaireInterrogartion>();
		
		for (Points point : Points.values()) {
			
			for (Cours cours : Cours.values()) {
				System.out.println("Creation des notes - cours [" + point + "][" + cours + "]");
				interro.add(new FaireInterrogartion(point, cours));
			}
		}
		
		tirageDesInterro();
	}

	public void tirageDesInterro() {
		Random random = new Random();
		for (int i = 0; i < interro.size(); ++i) {
			Collections.swap(interro, i, random.nextInt(interro.size()));
		}
	}
	
	public FaireInterrogartion removeFinishInterro() {
		return interro.remove(0);
	}
	
	
	public void returnInterroToCours(FaireInterrogartion fi) {
		interro.add(fi);
	}
	
	public List<FaireInterrogartion> getCours(){
		return interro;
	}

}
