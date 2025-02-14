package src.MDB;


public class Robot {


    /// TABLE //////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Table table;

    private Table getTable() {
        // Automatically generated method. Please do not modify this code.
        return this.table;
    }

    private void setTable(final Table value) {
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
    public Robot(final Table table) {
        this.setTable(table);
    }




    /// METHODES ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public void Cree_bloc(final TailleBloc taille, final Couleur couleur) {

        if (!this.Verif_cube_tenu()) {
            setBloc_tenu(new Bloc(taille, couleur));
        } else {
            System.out.println("Le robot tient déjà un bloc");
        }

    }

    public boolean Verif_cube_tenu() {

        return this.bloc_tenu != null;
    }

    public void poserBlocSurTable() {
        if (!this.Verif_cube_tenu()) {
            System.out.println("Le robot ne tient pas de bloc");
        } else {
            table.Ajout_bloc_table(bloc_tenu);
            majPreemption(null);
        }

    }

    public void poserBlocSurBloc(final TailleBloc taille, final Couleur couleur) {

        if (!this.Verif_cube_tenu()) {
            System.out.println("Le robot ne tient pas de bloc");
        } else {
            table.Ajout_bloc_sommet(taille, couleur, this.bloc_tenu);
            majPreemption(null);
        }

    }

    public void prendreBloc(final TailleBloc taille, final Couleur couleur) {

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


    public void afficheRobot() {


        if (this.bloc_tenu != null) {
            System.out.println(this.bloc_tenu);
            this.bloc_tenu.afficherBloc();
        }


//        Monde.ecrire(Couleur.bleu, "  ===========");
//        Monde.ecrire(Couleur.bleu, "  |       |");
//        if(getBloc_tenu() != null)
//        {
//            getBloc_tenu().afficherBloc();
//        }
//        Monde.ecrire(Couleur.bleu, "  |");
//        Monde.ecrire(Couleur.bleu, "  |");
//        Monde.ecrire(Couleur.bleu, "  |");
//        Monde.ecrire(Couleur.bleu, "  |");
//        Monde.ecrire(Couleur.bleu, "  |");
//        Monde.ecrire(Couleur.bleu, "  |");
//        Monde.ecrire(Couleur.bleu, "=====");

    }

}
