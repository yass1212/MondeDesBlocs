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


//	public static final int rouge = 31;
//	public static final int vert = 32;
//	public static final int jaune = 33;
//	public static final int bleu = 34;
//	public static final int violet = 35;
//	public static final int cyan = 36;
//	public static final int gris = 37;
//	public static final int noir = 38;

    public static void ecrire2(Couleur coul, String s) {
        System.out.printf("\033[%d;1m%s\033[0m", coul.ordinal()+31, s);
        System.out.printf(" ");
    }

    public static void ecrire(Couleur coul, String s) {
        System.out.printf("\033[%d;1m%s\033[0m\n", coul.ordinal()+31, s);
    }

    public static void main(String[] args) {




		//Couleur.testCouleur();
        Table tab = new Table();
        Robot D2R2 = new Robot(tab);


//        Bloc GRANDROUGE = new Bloc(TailleBloc.GRAND, Couleur.rouge);
//        Bloc MOYENVERT = new Bloc(TailleBloc.MOYEN, Couleur.vert);
//        Bloc GRANDJAUNE = new Bloc(TailleBloc.GRAND, Couleur.jaune);
//        Bloc PETITBLEU = new Bloc(TailleBloc.PETIT, Couleur.bleu);
//
//        System.out.println("Bloc GRANDROUGE : " + GRANDROUGE);
//        System.out.println("Bloc MOYENVERT : " + MOYENVERT);
//        System.out.println("Bloc GRANDJAUNE : " + GRANDJAUNE);
//
//
//        Bloc PETITBLEU2 = new Bloc(TailleBloc.PETIT, Couleur.bleu);
//        System.out.println("Bloc PETITBLEU2 : " + PETITBLEU2);
//
//        tab.sommets.add(GRANDROUGE);
//        tab.sommets.add(MOYENVERT);
//        tab.sommets.add(GRANDJAUNE);
//        tab.sommets.add(PETITBLEU);
//        tab.sommets.remove(PETITBLEU);
//
//        GRANDROUGE.setDessous(PETITBLEU2);
//
//        Bloc PETITBLEU3 = new Bloc(TailleBloc.PETIT, Couleur.bleu);
//        System.out.println("Bloc PETITBLEU3 : " + PETITBLEU3);
//
//        PETITBLEU2.setDessous(PETITBLEU3);





        System.out.println();
        ecrire(Couleur.bleu, "\t\t\t\t/////////////////////////////////////////");
        ecrire(Couleur.bleu, "\t\t\t\t/// Bienvenue dans le Monde des Blocs ///");
        ecrire(Couleur.bleu, "\t\t\t\t/////////////////////////////////////////");


        char c = ' ';
        Couleur coul;
        TailleBloc tc;
        do {
            System.out.println();
            System.out.println();
            System.out.println();
            ecrire(Couleur.rouge, "//////////");
            ecrire(Couleur.rouge, "// Menu //");
            ecrire(Couleur.rouge, "//////////");

            //tab.sommets.forEach(bloc -> System.out.println(bloc));

            ecrire(Couleur.bleu, "\t0 - afficher les règles");
            ecrire(Couleur.bleu, "\t1 - creer un cube");
            ecrire(Couleur.bleu, "\t2 - détruire un cube");
            System.out.println();
            ecrire(Couleur.bleu, "\t3 - prendre un cube");
            System.out.println();
            ecrire(Couleur.bleu, "\t4 - poser bloc sur la table");
            ecrire(Couleur.bleu, "\t5 - poser bloc sur bloc");
            System.out.println();
            ecrire(Couleur.bleu, "\t8 - afficher table");
            //ecrire(Couleur.bleu, "\t9 - afficher cube");
            System.out.println();
            ecrire(Couleur.bleu, "\tf - fin du monde");
            System.out.println();
            System.out.print("Votre choix : ");
            c = Keyboard.getChar();


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
                    ecrire2(coul, coul.name());
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
                    ecrire2(coul, coul.name());
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

                case '8':
                    //System.out.println("La table");
                    //tab.afficherTable();
                    //afficherMonde(D2R2, tab);

                    //Keyboard.pause();
                    break;

//                case '9':
//                    System.out.println("Un grand cube rouge");
//                    GRANDROUGE.afficherBloc();
//
//                    Keyboard.pause();
//                    break;


                case '\n':
                case '\r':
                    System.out.println("Entrez un caractère valide");
                    break;
            }
            afficherMonde(D2R2, tab);
        } while (c != 'f');
    }

    private static void afficherMonde(Robot R, Table T) {
        ecrire2(Couleur.noir, "État du monde :");
        System.out.println();
        R.afficheRobot();
        T.afficherTable();
//		Keyboard.pause();

    }




}
