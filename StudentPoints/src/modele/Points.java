package modele;

public enum Points {
	NEANT (0),
	MAUVAIS (4),
	SATISFACTION (5),
	FRUIT (6),
	GRAND_FRUIT (7),
	PLUS_GRAND_FRUIT (8),
	EXCELLENT (10);
	
	int point;
	
	private Points(int value) {
		point = value;
	}
	
	public int value() {
		return point;
	}
}
