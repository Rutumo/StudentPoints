package modele;

public enum Cours {
	MATHEMATIQUES(1),
	KIRUNDI(2),
	INFORMATIQUES(3),
	ANGLAIS(4);
	
	int cours;
	
	private Cours(int value) {
		cours = value;
	}
	
	public int value() {
		return cours;
	}
}
