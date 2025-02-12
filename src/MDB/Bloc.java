package MDB;

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

    private String getTaille() {
        // Automatically generated method. Please do not modify this code.
        return this.Taille.toString();
    }

    private void setTaille(final TailleBloc value) {
        // Automatically generated method. Please do not modify this code.
        this.Taille = value;
    }

    private String couleur;

    private String getCouleur() {
        // Automatically generated method. Please do not modify this code.
        return this.couleur;
    }

    private void setCouleur(final String value) {
        // Automatically generated method. Please do not modify this code.
        this.couleur = value;
    }

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

        return (this.getTaille().equals(taille));

    }

    // compare la taille et couleur entrée à celle du cube pour savoir si le cube correspond à la description
    public boolean Correspond_description(final TailleBloc taille, final String couleur) {

        return (this.getTaille() == taille.toString()

                && this.getCouleur().equals(couleur));

    }

    public Bloc demandeBlocDessous() {
        return getDessous();
    }

}
