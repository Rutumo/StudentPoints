package modele;

public class FaireInterrogartion {
	
	private Points point;
	private Cours cours;
	private boolean fait;
	
	public FaireInterrogartion(Points point, Cours cours) {
		super();
		this.point = point;
		this.cours = cours;
	}

	public Points getPoint() {
		return point;
	}

	public Cours getCours() {
		return cours;
	}
	
	public boolean estFait() {
		return fait;
	}
	
	public boolean nonFait() {
		fait = !fait;
		return fait;
	}

}
