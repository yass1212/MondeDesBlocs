package MDB;

public class Bloc {
    private TailleCube Taille;

    private String getTaille() {
        // Automatically generated method. Please do not modify this code.
        return this.Taille.toString();
    }

    private void setTaille(final TailleCube value) {
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
    public boolean TailleSuffisante(final TailleCube taille) {

        return (this.getTaille().equals(taille));

    }

    // compare la taille et couleur entrée à celle du cube pour savoir si le cube correspond à la description
    public boolean Correspond_description(final TailleCube taille, final String couleur) {

        return (this.getTaille() == taille.toString()

                && this.getCouleur().equals(couleur));

    }

    public Bloc demandeBlocDessous() {
        // TODO Auto-generated return
        return null;
    }

}
