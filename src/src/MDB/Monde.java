package src.MDB;

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

    public static void ecrire(Couleur coul, String s) {
        System.out.printf("\033[%d;1m%s\033[0m", coul.ordinal()+31, s);
        System.out.printf(" ");
    }

    public static void main(String[] args) {




		//Couleur.testCouleur();
        Table tab = new Table();
        Robot D2R2 = new Robot(tab);


        Bloc GRANDROUGE = new Bloc(TailleBloc.GRAND, Couleur.rouge);
        Bloc MOYENVERT = new Bloc(TailleBloc.MOYEN, Couleur.vert);
        Bloc GRANDJAUNE = new Bloc(TailleBloc.GRAND, Couleur.jaune);
        Bloc PETITBLEU = new Bloc(TailleBloc.PETIT, Couleur.bleu);

        Bloc PETITBLEU2 = new Bloc(TailleBloc.PETIT, Couleur.bleu);

        tab.sommets.add(GRANDROUGE);
        tab.sommets.add(MOYENVERT);
        tab.sommets.add(GRANDJAUNE);
        tab.sommets.add(PETITBLEU);
        tab.sommets.remove(PETITBLEU);

        GRANDROUGE.setDessous(PETITBLEU2);






        System.out.println("////////////////////////////////////////");
        System.out.println("BIENVENUE DANS LE MONDE DES BLOCS");
        System.out.println("////////////////////////////////////////");


        char c = ' ';
        Couleur coul;
        TailleBloc tc;
        do {
            System.out.println("////////");
            System.out.println("MENU");
            System.out.println("////////");

            tab.sommets.forEach(bloc -> System.out.println(bloc));

            System.out.println("1 - creer un cube");
            System.out.println("2 - détruire un cube");
            System.out.println("3 - prendre un cube");
            System.out.println("4 - poser bloc sur la table");
            System.out.println("5 - poser bloc sur bloc");
            System.out.println("////////////////////////////////////////");
            System.out.println("8 - afficher table");
            System.out.println("9 - afficher cube");
            System.out.println("f - fin du monde");
            System.out.print("Votre choix : ");
            c = Keyboard.getChar();


            switch (c) {



                case '1':
                    System.out.print("Couleur du cube : ");
                    coul = Couleur.getCouleur(Keyboard.getString());
//			ecrire (coul, "couleur saisie");
                    System.out.print("Taille (grand/moyen/petit) : ");
                    tc = TailleBloc.getTaille(Keyboard.getString());
                    D2R2.Cree_bloc(tc, coul);
                    break;





                case '2':
                    System.out.println("Le cube tenu par le robot va être détruit ");
//			Keyboard.pause();
                    D2R2.detruitBloc();
                    break;




                case '3':
                    System.out.println("Veuillez entrez la taille et la couleur du cube que vous voulez saisir : ");
                    System.out.println("Couleur : ");
                    coul = Couleur.getCouleur(Keyboard.getString());
                    System.out.print("Taille (grand/moyen/petit) : ");
                    tc = TailleBloc.getTaille(Keyboard.getString());
                    D2R2.prendreBloc(tc, coul);
                    break;





                case '4':
                    System.out.println("Le cube tenu par le robot va être posé sur la table ");
                    D2R2.poserBlocSurTable();
                    break;




                case '5':
                    System.out.println("Le cube tenu par le robot va être posé sur la table ");
                    System.out.println("Sur quelle couleur voulez-vous poser le cube ?  ");
                    coul = Couleur.getCouleur(Keyboard.getString());
                    System.out.println("Sur quelle taille voulez-vous poser que le cube ? (grand/moyen/petit) :");
                    tc = TailleBloc.getTaille(Keyboard.getString());

                    D2R2.poserBlocSurBloc(tc, coul);
                    break;

                case '8':
                    System.out.println("La table");
                    tab.afficherTable();
                    break;

                case '9':
                    System.out.println("Un grand cube rouge");
                    GRANDROUGE.afficherBloc();
                    break;

                default:
                    System.out.println("entrez un caractere");
                    break;
            }
            afficherMonde(D2R2, tab);
        } while (c != 'f');
    }

    private static void afficherMonde(Robot R, Table T) {
        ecrire(Couleur.noir, "Etat du monde : ");
        R.afficheRobot();
        T.afficherTable();
//		Keyboard.pause();

    }




}
