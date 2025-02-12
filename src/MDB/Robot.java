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

    private Bloc getBloc_tenu() {
        // Automatically generated method. Please do not modify this code.
        return this.bloc_tenu;
    }

    private void setBloc_tenu(final Bloc value) {
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
        table.Ajout_bloc_table(bloc_tenu);
    }

    public void poserBlocSurBloc(final TailleBloc taille, final Couleur couleur) {
        table.Ajout_bloc_sommet(taille, couleur);
    }

    public void prendreBloc(final TailleBloc taille, final Couleur couleur) {

        if (!this.Verif_cube_tenu()) {
            table.renvoieBloc(taille, couleur);
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

}
