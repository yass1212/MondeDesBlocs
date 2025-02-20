package MDB;

import in.keyboard.Keyboard;


public class Monde {

    /// ROBOT //////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Robot robot;

    private Robot getRobot() {
        // Automatically generated method. Please do not modify this code.
        return this.robot;
    }

    private void setRobot(final Robot value) {
        // Automatically generated method. Please do not modify this code.
        this.robot = value;
    }



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



    /// METHODES ///////////////////////////////////////////////////////////////////////////////////////////////////////

    // affiche le monde (robot et rable
    private static void afficherMonde(Robot R, Table T) {
        ecrireEspace(Couleur.noir, "État du monde :");
        System.out.println();
        R.afficheRobot();
        T.afficherTable();
        Keyboard.pause();
    }



    // ecrire avec un espace sans retour à la ligne
    public static void ecrireEspace(Couleur coul, String s) {
        System.out.printf("\033[%d;1m%s\033[0m", coul.ordinal()+31, s);
        System.out.printf(" ");
    }



    // ecrire avec un retour à la ligne
    public static void ecrire(Couleur coul, String s) {
        System.out.printf("\033[%d;1m%s\033[0m\n", coul.ordinal()+31, s);
    }



    /// MAIN ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {

        // création des objets table et robot et association de la table au robot
        Table tab = new Table();
        Robot D2R2 = new Robot(tab);

        // affichage d'un message de bienvenue
        System.out.println();
        ecrire(Couleur.cyan, "\t\t\t\t/////////////////////////////////////////");
        ecrire(Couleur.cyan, "\t\t\t\t/// Bienvenue dans le Monde des Blocs ///");
        ecrire(Couleur.cyan, "\t\t\t\t/////////////////////////////////////////");


        // menu
        char c = ' ';
        Couleur coul;
        TailleBloc tc;
        do {

            // affichage du menu
            System.out.println();
            System.out.println();
            System.out.println();
            ecrire(Couleur.rouge, "//////////");
            ecrire(Couleur.rouge, "// Menu //");
            ecrire(Couleur.rouge, "//////////");


            // options
            ecrire(Couleur.gris, "\t0 - afficher les règles");
            ecrire(Couleur.gris, "\t1 - creer un cube");
            ecrire(Couleur.gris, "\t2 - détruire un cube");
            System.out.println();
            ecrire(Couleur.gris, "\t3 - prendre un cube");
            System.out.println();
            ecrire(Couleur.gris, "\t4 - poser bloc sur la table");
            ecrire(Couleur.gris, "\t5 - poser bloc sur bloc");
            System.out.println();
            ecrire(Couleur.gris, "\t8 - afficher table");
            System.out.println();
            ecrire(Couleur.gris, "\tf - fin du monde");
            System.out.println();

            // choix
            System.out.print("Votre choix : ");
            c = Keyboard.getChar();


            // gestion des cas
            switch (c) {

                case '0':
                    System.out.println("Vous ne pouvez poser un cube que sur un cube de taille équivalente ou plus grande.\nPar exemple : un cube petit peut être posé sur tous les cubes mais un cube grand ne peut être posé que sur un cube grand\n");
                    break;



                case '1':
                    System.out.println("Vous allez créer un cube");
                    System.out.print("Couleur du cube : ");
                    coul = Couleur.getCouleur(Keyboard.getString());

                    System.out.print("Taille (grand/moyen/petit) : ");
                    tc = TailleBloc.getTaille(Keyboard.getString());
                    System.out.print("Un cube de couleur ");
                    ecrireEspace(coul, coul.name());
                    System.out.println("et de taille " + tc + " va être créé");
                    Keyboard.pause();

                    D2R2.Cree_bloc(tc, coul);
                    break;



                case '2':
                    System.out.println("Le cube tenu par le robot va être détruit");
			        Keyboard.pause();

                    D2R2.detruitBloc();
                    break;



                case '3':
                    System.out.println("Vous allez prendre un cube dans la table");
                    System.out.println("Veuillez entrez la taille et la couleur du cube que vous voulez saisir : ");
                    System.out.print("Couleur : ");
                    coul = Couleur.getCouleur(Keyboard.getString());
                    System.out.print("Taille (grand/moyen/petit) : ");
                    tc = TailleBloc.getTaille(Keyboard.getString());

                    System.out.print("Vous allez prendre un cube de couleur ");
                    ecrireEspace(coul, coul.name());
                    System.out.println("et de taille " + tc + " s'il y en a un dans les sommets de la table");

                    Keyboard.pause();

                    D2R2.prendreBloc(tc, coul);
                    break;



                case '4':
                    System.out.println("Le cube tenu par le robot va être posé sur la table");
                    Keyboard.pause();

                    D2R2.poserBlocSurTable();
                    break;



                case '5':
                    System.out.println("Le cube tenu par le robot va être posé sur un cube dont vous choisirez la couleur et la taille");
                    System.out.println("Sur quelle couleur voulez-vous poser le cube ?  ");
                    coul = Couleur.getCouleur(Keyboard.getString());
                    System.out.println("Sur quelle taille voulez-vous poser que le cube ? (grand/moyen/petit) :");
                    tc = TailleBloc.getTaille(Keyboard.getString());
                    System.out.println("Le cube tenu par le robot va être posé sur un cube correspondant à la description entrée s'il y en a un dans les sommets de la table");
                    Keyboard.pause();

                    D2R2.poserBlocSurBloc(tc, coul);
                    break;


                // afficher la table (effectué à chaque fin de boucle donc rien à faire) - permet à l'utilisateur d'afficher la table sans effectuer d'action
                case '8':
                    break;



                case '\n':
                case '\r':
                    System.out.println("Entrez un caractère valide");
                    break;
            }

            // affichage du monde à la fin de chaque boucle
            afficherMonde(D2R2, tab);


        // quitter lorsque l'utilisateur entre 'f'
        } while (c != 'f');
    }

}
