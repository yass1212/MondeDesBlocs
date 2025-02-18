package MDB;


public enum TailleBloc {

    // les tailles disponibles
    PETIT, MOYEN, GRAND;

    // obtenir une couleur à partir d'une chaîne
    public static TailleBloc getTaille(String taille) {
        for (TailleBloc t: TailleBloc.values())
            if (t.name().equalsIgnoreCase(taille))
                return t;
        // taille par défaut
        System.out.println("Taille non reconnue, taille par défaut: GRAND");
        return TailleBloc.GRAND;
    }

}
