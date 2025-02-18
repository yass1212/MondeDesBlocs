package MDB;


public class Robot {

    /// TABLE //////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Table table;

    public Table getTable() {
        // Automatically generated method. Please do not modify this code.
        return this.table;
    }

    public void setTable(final Table value) {
        // Automatically generated method. Please do not modify this code.
        this.table = value;
    }



    /// BLOC TENU //////////////////////////////////////////////////////////////////////////////////////////////////////
    private Bloc bloc_tenu;

    public Bloc getBloc_tenu() {
        // Automatically generated method. Please do not modify this code.
        return this.bloc_tenu;
    }

    public void setBloc_tenu(final Bloc value) {
        // Automatically generated method. Please do not modify this code.
        this.bloc_tenu = value;
    }



    /// CONSTRUCTEUR ///////////////////////////////////////////////////////////////////////////////////////////////////

    // constructeur du robot
    public Robot(final Table table) {
        this.setTable(table);
    }



    /// METHODES ///////////////////////////////////////////////////////////////////////////////////////////////////////

    // crée un bloc
    public void Cree_bloc(final TailleBloc taille, final Couleur couleur) {

        // si le robot ne tient pas de bloc, il peut créer un bloc
        if (!this.Verif_cube_tenu()) {
            // on crée un bloc avec les attributs donnés et on le donne au robot
            setBloc_tenu(new Bloc(taille, couleur));
        // sinon, on affiche un message d'erreur
        } else {
            System.out.println("Le robot tient déjà un bloc");
        }

    }



    // vérifie si le robot tient un bloc
    public boolean Verif_cube_tenu() {
        return this.bloc_tenu != null;
    }



    // pose un bloc sur la table
    public void poserBlocSurTable() {

        // si le robot ne tient pas de bloc, il ne peut pas poser de bloc
        if (!this.Verif_cube_tenu()) {
            System.out.println("Le robot ne tient pas de bloc");
        // si le robot tient un bloc, on le pose sur la table (comme la table à une taille infinie, ça fonctionne à tous les coups)
        } else {
            table.Ajout_bloc_table(bloc_tenu);
            // le robot ne tient plus de bloc
            majPreemption(null);
        }

    }



    // pose un bloc sur un autre bloc
    public void poserBlocSurBloc(final TailleBloc taille, final Couleur couleur) {

        // si le robot ne tient pas de bloc, il ne peut pas poser de bloc
        if (!this.Verif_cube_tenu()) {
            System.out.println("Le robot ne tient pas de bloc");
        // si le robot tient un bloc, on vérifie si on peut poser le bloc sur un autre bloc
        } else {

            // on vérifie si on peut poser le bloc sur un autre bloc
            if (table.Ajout_bloc_sommet(taille, couleur, this.bloc_tenu)) {
                // si c'est le cas, alors le robot ne tient plus de bloc
                majPreemption(null);
            }

            // sinon, on affiche un message d'erreur
            System.out.println("Le bloc n'a pas été posé");
        }

    }



    // prend un bloc sur la table
    public void prendreBloc(final TailleBloc taille, final Couleur couleur) {

        // si le robot ne tient pas de bloc, il peut prendre un bloc sur la table
        if (!this.Verif_cube_tenu()) {
            Bloc nouveauBloc = table.renvoieBloc(taille, couleur);
            majPreemption(nouveauBloc);
        } else {
            System.out.println("Le robot tient déjà un bloc");
        }

    }



    // met à jour la préemption du robot (soit il tiens un bloc, soit il ne tient rien)
    public void majPreemption(final Bloc bloc) {
        this.setBloc_tenu(bloc);
    }



    // détruit le bloc tenu par le robot
    public void detruitBloc() {
        this.setBloc_tenu(null);
    }



    // afficher le robot
    public void afficheRobot() {

        // haut du robot et pince
        Monde.ecrire(Couleur.bleu, "  ===========");
        Monde.ecrire(Couleur.bleu, "  |       |");

        // afficher le bloc tenu par le robot s'il y en a un
        if(getBloc_tenu() != null) {
            Monde.ecrireEspace(Couleur.bleu, "  |      ");
            getBloc_tenu().afficherBloc();
            System.out.println();
        } else {
            Monde.ecrire(Couleur.bleu, "  |");
        }
        // afficher 2 barres supplémentaires
        Monde.ecrire(Couleur.bleu, "  |");
        Monde.ecrire(Couleur.bleu, "  |");
    }

}
