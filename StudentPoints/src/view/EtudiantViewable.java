package view;

import controller.Controller;

public interface EtudiantViewable {
	
	public void setController(Controller controller);

	public void entrerNomEtudiant();

	public void PointsChaqueCoursParEtudiant();
	
	public void ContinuerInterrogations();
	
	public void afficherMeilleurEtudiant(String nomEtudiant);

	public void AfficherNomEtudiant(int indexEtudiant, String nomEtudiant);

	public void afficherFaceCachePintsCours(int i, String etudiant);
	
	public void affichierCoursPourChaqueEtudiant(int i, String etudiant, String point, String cours);


}
