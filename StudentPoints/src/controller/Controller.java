package controller;

import java.util.ArrayList;
import java.util.List;

import modele.CreationPointCours;
import modele.Etudiant;
import modele.FaireInterrogartion;
import reponse.EvaluationEtudiant;
import view.EtudiantViewable;
import view.View;


public class Controller {
	enum QuizState {
		AjoutEtudiant, InterrogationEstFaite, AnnonceDesPoints;
	}
	
	CreationPointCours creationPointCours;
	List<Etudiant> etudiants;
	Etudiant etudiantReussi;
	EtudiantViewable view;
	//View view;
	
	QuizState etatInterrogation;
	EvaluationEtudiant evaluation;

	public Controller(CreationPointCours creationPointCours, View view, EvaluationEtudiant evaluationEtudiant) {
		super();
		this.creationPointCours = creationPointCours;
		this.view = view;
		this.etudiants = new ArrayList<Etudiant>();
		this.etatInterrogation = QuizState.AjoutEtudiant;
		view.setController(this);
		this.evaluation = evaluationEtudiant;
	}
	

	public void run() {
		while (etatInterrogation == QuizState.AjoutEtudiant) {
			view.entrerNomEtudiant();
		}
		
		switch (etatInterrogation) {
		case InterrogationEstFaite:
			view.PointsChaqueCoursParEtudiant();
			break;
			
		case AnnonceDesPoints:
			view.ContinuerInterrogations();
			break;

		default:
			break;
		}
	}
	
	
	public void AjouterEtudiant(String nomEtudiant) {
		if (etatInterrogation == QuizState.AjoutEtudiant) {
			etudiants.add(new Etudiant(nomEtudiant));
			view.AfficherNomEtudiant(etudiants.size(), nomEtudiant);
		}
	}
	
	public void commencerInterrogation() {
		if (etatInterrogation != QuizState.InterrogationEstFaite) {
			creationPointCours.tirageDesInterro();
			int indexEtudiant = 1;
			
			for (Etudiant etudiant : etudiants) {
				etudiant.addCoursToHoraire(creationPointCours.removeFinishInterro());
				view.afficherFaceCachePintsCours(indexEtudiant++, etudiant.getNom());
			}
			etatInterrogation = QuizState.InterrogationEstFaite;
		}
		this.run();
	}
	
	public void recupererCours() {
		int indexEtudiant = 1;
		for (Etudiant etudiant : etudiants) {
			FaireInterrogartion faireInterrogartion = etudiant.getCours(0);
			faireInterrogartion.nonFait();
			
			view.affichierCoursPourChaqueEtudiant(indexEtudiant++, etudiant.getNom(),
					faireInterrogartion.getPoint().toString(), faireInterrogartion.getCours().toString());
		}
		
		evaluerEtudiant();
		afficherEtudiantReussi();
		recommencerInterrogation();
		
		etatInterrogation = QuizState.AnnonceDesPoints;
		this.run();
	}

	void evaluerEtudiant() {
		
		etudiantReussi = evaluation.evaluerEtatEtudiant(etudiants);
		
		/*Etudiant meilleurEtudiant = null;
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
				
				if (point >= meilleurPoint) {
					if (point > meilleurPoint) {
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
		etudiantReussi = meilleurEtudiant;*/
	}


	void afficherEtudiantReussi() {
		view.afficherMeilleurEtudiant(etudiantReussi.getNom());
	}

	void recommencerInterrogation() {
		for (Etudiant etudiant : etudiants){
			creationPointCours.returnInterroToCours(etudiant.removeCours());
		}
	}
}
