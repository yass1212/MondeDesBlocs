package src.MDB;

public class Bloc {
    private TailleBloc Taille;
    
  /// CONSTRUCTEUR ///////////////////////////////////////////////////////////////////////////////////////////////////
    public Bloc(final TailleBloc taille, final String couleur) {
        this.setTaille(taille);
        this.setCouleur(couleur);
    }

    // bloc par défaut
    public Bloc() {
        this.setTaille(TailleBloc.PETIT);
        this.setCouleur("noir");
    }

    public String getTaille() {
        // Automatically generated method. Please do not modify this code.
        return this.Taille;
    }

    private void setTaille(final TailleBloc value) {
        // Automatically generated method. Please do not modify this code.
        this.Taille = value;
    }


    /// COULEUR ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String couleur;

    public String getCouleur() {
        // Automatically generated method. Please do not modify this code.
        return this.couleur;
    }

    private void setCouleur(final String value) {
        // Automatically generated method. Please do not modify this code.
        this.couleur = value;
    }



    /// BLOC DESSOUS ///////////////////////////////////////////////////////////////////////////////////////////////////
    private Bloc dessous;

    private Bloc getDessous() {
        // Automatically generated method. Please do not modify this code.
        return this.dessous;
    }

    private void setDessous(final Bloc value) {
        // Automatically generated method. Please do not modify this code.
        this.dessous = value;
    }

    // vérifie si le cube est de la même taille ou plus grand que la taille demandée
    public boolean TailleSuffisante(final TailleBloc taille) {



    /// CONSTRUCTEUR ///////////////////////////////////////////////////////////////////////////////////////////////////
    public Bloc(final TailleBloc taille, final String couleur) {
        this.setTaille(taille);
        this.setCouleur(couleur);
    }






    /// METHODES ///////////////////////////////////////////////////////////////////////////////////////////////////////

    // vérifie si le cube est de la même taille ou plus grand que la taille demandée
    public boolean TailleSuffisante(final TailleBloc taille) {

        int tailleCorrespond = this.getTaille().compareTo(taille);

        System.out.println("taille :");
        System.out.println(tailleCorrespond);


        if (tailleCorrespond >= 0) {
            System.out.println("La taille correspond");
        }
        System.out.println("La taille correspond PAS");
        return false;

    }

    // compare la taille et couleur entrée à celle du cube pour savoir si le cube correspond à la description
    public boolean Correspond_description(final TailleBloc taille, final String couleur) {

        int tailleCorrespond = this.getTaille().compareTo(taille);

        //System.out.println("taille :");
        //System.out.println(tailleCorrespond);
        if (tailleCorrespond == 0) {
            //System.out.println("correspond à la taille");
            //System.out.println(this.getCouleur().equalsIgnoreCase(couleur));
            return this.getCouleur().equalsIgnoreCase(couleur);
        }
        //System.out.println("La taille correspond PAS");
        return false;

    }



    public Bloc demandeBlocDessous() {
        return getDessous();
    }

}
