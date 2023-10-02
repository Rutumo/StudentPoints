package reponse;

import java.util.List;

import modele.Etudiant;
import modele.FaireInterrogartion;

public class EvaluerDernierEtudiant implements EvaluationEtudiant {

	@Override
	public Etudiant evaluerEtatEtudiant(List<Etudiant> etudiants) {
		
		Etudiant meilleurEtudiant = null;
		int meilleurPoint = -1;
		int meilleurCours = -1;
		
		for (Etudiant etudiant : etudiants) {
			boolean nouveauMeilleurEtudiant = false;
			
			if (meilleurEtudiant == null) {
				nouveauMeilleurEtudiant = true;
			}
			else {
				FaireInterrogartion faireInt = etudiant.getCours(0);
				int point = faireInt.getPoint().value();
				
				if (point <= meilleurPoint) {
					if (point < meilleurPoint) {
						nouveauMeilleurEtudiant = true;
					}
					else {
						if (faireInt.getPoint().value() > meilleurPoint) {
							nouveauMeilleurEtudiant = true;
						}
					}
				}
			}
			if (nouveauMeilleurEtudiant) {
				meilleurEtudiant = etudiant;
				FaireInterrogartion faireInt = etudiant.getCours(0);
				meilleurPoint = faireInt.getPoint().value();
				meilleurCours = faireInt.getCours().value();
			}
		}
		return meilleurEtudiant;
	}

}
