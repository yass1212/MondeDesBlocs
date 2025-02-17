package MDB;


public class Bloc {
    private TailleBloc Taille;

    
  /// CONSTRUCTEUR ///////////////////////////////////////////////////////////////////////////////////////////////////
    public Bloc(final TailleBloc taille, final Couleur couleur) {
        this.setTaille(taille);
        this.setCouleur(couleur);
    }

    // bloc par défaut
    public Bloc() {
        this.setTaille(TailleBloc.PETIT);
        this.setCouleur(Couleur.noir);
    }

    public TailleBloc getTaille() {
        // Automatically generated method. Please do not modify this code.
        return this.Taille;
    }

    private void setTaille(final TailleBloc value) {
        // Automatically generated method. Please do not modify this code.
        this.Taille = value;
    }


    /// COULEUR ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Couleur couleur;

    public Couleur getCouleur() {
        // Automatically generated method. Please do not modify this code.
        return this.couleur;
    }

    public void setCouleur(final Couleur value) {
        // Automatically generated method. Please do not modify this code.
        this.couleur = value;
    }



    /// BLOC DESSOUS ///////////////////////////////////////////////////////////////////////////////////////////////////
    private Bloc dessous;

    public Bloc getDessous() {
        // Automatically generated method. Please do not modify this code.
        return this.dessous;
    }

    public void setDessous(final Bloc value) {
        // Automatically generated method. Please do not modify this code.
        this.dessous = value;
    }









    /// METHODES ///////////////////////////////////////////////////////////////////////////////////////////////////////

    // vérifie si le cube est de la même taille ou plus grand que la taille demandée
    public boolean TailleSuffisante(final TailleBloc taille) {

        int tailleCorrespond = this.getTaille().compareTo(taille);


        System.out.println(this.getTaille().name());
        System.out.println(taille.name());



        System.out.println("taille :");
        System.out.println(tailleCorrespond);


        if (tailleCorrespond >= 0) {
            System.out.println("La taille correspond");
            return true;
        }
        System.out.println("La taille correspond PAS");
        return false;

    }

    // compare la taille et couleur entrée à celle du cube pour savoir si le cube correspond à la description
    public boolean Correspond_description(final TailleBloc taille, final Couleur couleur) {

        /*
        int tailleCorrespond = this.getTaille().compareTo(taille);

        //System.out.println("taille :");
        //System.out.println(tailleCorrespond);
        if (tailleCorrespond == 0) {
            //System.out.println("correspond à la taille");
            //System.out.println(this.getCouleur().equalsIgnoreCase(couleur));
            return this.getCouleur().equals(couleur);
        }
        //System.out.println("La taille correspond PAS");
        return false;
        */


        if (this.TailleSuffisante(taille)) {
            if (this.getCouleur().equals(couleur)) {
                System.out.println("La couleur correspond");
            }
            return this.getCouleur().equals(couleur);
        }
        System.out.println("La couleur correspond PAS");
        return false;
    }



    public Bloc demandeBlocDessous() {
        return getDessous();
    }



    public void afficherBloc() {

        if (this.getTaille() == TailleBloc.PETIT) {
            Monde.ecrire2(this.getCouleur(), "P");
        } else if (this.getTaille() == TailleBloc.MOYEN) {
            Monde.ecrire2(this.getCouleur(), "M");
        } else {
            Monde.ecrire2(this.getCouleur(), "G");
        }
    }
}
