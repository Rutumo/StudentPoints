package view;

import java.util.Scanner;

import controller.Controller;

public class View implements EtudiantViewable {
	
	Controller controller;
	Scanner taperClavier = new Scanner(System.in);
	
	public void setController(Controller controller) {
		this.controller = controller;
		
	}

	public void entrerNomEtudiant() {
		System.out.println("\nEntrer le nom de l'etudiant : ");
		String nom = taperClavier.nextLine();
		
		if (nom.isEmpty()) {
			controller.commencerInterrogation();
		}
		else {
			controller.AjouterEtudiant(nom);
		}
		
	}

	public void PointsChaqueCoursParEtudiant() {
		System.out.println("\nFais entrer pour recuperer les notes d'etudiant");
		taperClavier.nextLine();
		controller.recupererCours();
		
	}

	public void ContinuerInterrogations() {
		System.out.println("\nFais entrer pour commencer le le nouveau Quiz");
		taperClavier.nextLine();
		controller.commencerInterrogation();
		
	}
	
	public void afficherMeilleurEtudiant(String nomEtudiant) {
		System.out.println("\nLe nom du meilleur etudiant est : " + nomEtudiant.toUpperCase());
		
	}

	public void AfficherNomEtudiant(int indexEtudiant, String nomEtudiant) {
		System.out.println("[" + indexEtudiant + "][" + nomEtudiant + "]");
	}

	public void afficherFaceCachePintsCours(int i, String etudiant) {
		System.out.println( "Etudiant num " + i + " = > [" + etudiant + "][point][cours]");		
	}

	public void affichierCoursPourChaqueEtudiant(int i, String etudiant, String point, String cours) {
		System.out.println( "Etudiant num " + i + " => ["+ etudiant +"]["+ point +"]["+ cours +"]");
		
	}
}
