package MDB;

public enum TailleBloc {
    PETIT, MOYEN, GRAND;


    public static TailleBloc getTaille(String taille) {
        for (TailleBloc t: TailleBloc.values())
            if (t.name().equalsIgnoreCase(taille))
                return t;
        return TailleBloc.GRAND;
    }

    }
