package MDB;


public enum Couleur {

	// les couleurs disponibles
 	rouge, vert, jaune, bleu, violet, cyan, gris, noir;

	// obtenir une couleur à partir d'une chaîne
	public static Couleur getCouleur(String coulSaisie) {
		for (Couleur c:Couleur.values())
			if (c.name().equalsIgnoreCase(coulSaisie))
				return c;
		// couleur par défaut
		System.out.println("Couleur non reconnue, couleur par défaut : rouge");
		return Couleur.rouge;
	}

	// tester les couleurs
	public static void testCouleur() {
		for (Couleur c:Couleur.values())
			Monde.ecrire(c,"test couleur");
	}

}