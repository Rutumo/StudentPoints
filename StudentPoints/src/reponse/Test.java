package reponse;

import controller.Controller;
import modele.CreationPointCours;
import view.View;

public class Test {

	public static void main(String[] args) {
		Controller controller = new Controller(new CreationPointCours(), new View(), new EvaluerMeilleurEtudiant());
		controller.run();
	}

}
