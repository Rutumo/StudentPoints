package modele;

public class Etudiant {
	
	private String nom;
	private Horaire horaire;
	
	public Etudiant(String nom) {
		super();
		this.nom = nom;
		horaire = new Horaire();
	}
	
	public void addCoursToHoraire(FaireInterrogartion fi) {
		horaire.addCours(fi);
	}
	
	public FaireInterrogartion getCours(int index) {
		return horaire.getCours(index);
	}
	
	public FaireInterrogartion removeCours() {
		return horaire.removeCours();
	}
	
	public String getNom() {
		return nom;
	}
	
}
