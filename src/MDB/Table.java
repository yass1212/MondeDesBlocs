package MDB;

import java.util.ArrayList;
import java.util.List;

public class Table {
    public List<Bloc> sommets;
    
    public Table() {
    	this.sommets = new ArrayList<Bloc>();
    }

    public void Ajout_bloc_table(final Bloc BlocAjouter) {
    	sommets.add(BlocAjouter);
    }
    

    public Bloc verifieDispoSommet(final TailleBloc taille, final Couleur couleur) {
        Bloc res = null;
        for(Bloc bloc : sommets) {
        	if (bloc.Correspond_description(taille, couleur)) {
				res = bloc;
			}
        }
        return res;
       
    }

    public boolean Ajout_bloc_sommet(TailleBloc tailleSocle, Couleur couleurSocle, Bloc blocAjouter) {
    	Bloc blocSocle = verifieDispoSommet(tailleSocle, couleurSocle);
    	if (blocSocle != null) {
    		majSommet(blocSocle, blocAjouter);
            return true;
			
		}

        System.out.println("Aucun Sommet correspondant");
        return false;
    }


    public Bloc renvoieBloc(final TailleBloc taille, final Couleur couleur) {
        Bloc res = verifieDispoSommet(taille, couleur);
        if (res == null) {
            System.out.println("Aucun bloc aux sommets des piles ne correspond à la description");
        } else {
            System.out.println("Bloc saisi !");
        }
        if (res != null) {
            majSommet(res, res.demandeBlocDessous());
        } else {
            majSommet(res, null);
        }

        if (res != null) {
            System.out.println("RES :");
            System.out.println(res);
            res.afficherBloc();
        } else {
            System.out.println("RES NULL");
        }
        return res;
    }




    public void majSommet(final Bloc BlocSocle, final Bloc BlocPose) {

        if (BlocPose == null) {
            sommets.remove(BlocSocle);
        } else {
            sommets.remove(BlocSocle);
            sommets.add(BlocPose);
        }

    }







        // Fonction pour faire la rotation de la matrice de 90 degrés
        public static void rotateMatrix(Bloc[][] matrix) {
            int n = matrix.length;

            // Transposer la matrice (échange les éléments [i][j] et [j][i])
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    Bloc temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            // Inverser chaque ligne de la matrice
            for (int i = 0; i < n; i++) {
                int left = 0;
                int right = n - 1;
                while (left < right) {
                    Bloc temp = matrix[i][left];
                    matrix[i][left] = matrix[i][right];
                    matrix[i][right] = temp;
                    left++;
                    right--;
                }
            }
        }

        // Fonction pour afficher la matrice
        public static void printMatrix(Bloc[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j].afficherBloc();
                }
                System.out.println();
            }
        }






    public void afficherTable() {
        // Créer les piles sous forme de tableau de tableau
        int colonnes = sommets.size();
        //System.out.println(colonnes);
        int lignes = 0;

        // Trouver la hauteur maximale parmi toutes les piles
        for (Bloc bloc : sommets) {
            int hauteur = 0;
            while (bloc != null) {
                hauteur++;
                bloc = bloc.getDessous();
            }
            lignes = Math.max(lignes, hauteur); // Hauteur maximale
        }

        // Créer le tableau bidimensionnel
        Bloc[][] tableau = new Bloc[lignes][colonnes];

        // print tableau
//        System.out.println("tableau de départ :");
//        for (int i = 0; i < lignes; i++) {
//            for (int j = 0; j < colonnes; j++) {
//                System.out.print(tableau[i][j] + " ");
//            }
//            System.out.println();
//        }

        // Remplir le tableau avec les blocs
        for (int j = 0; j < colonnes; j++) {
            Bloc bloc = sommets.get(j);
            int hauteur = 0;
            while (bloc != null) {
                tableau[hauteur][j] = bloc; // Remplir du bas vers le haut
                hauteur++;
                bloc = bloc.getDessous();

                // print tableau
//                System.out.println();
//                System.out.println();
//                System.out.println("tableau boucle");
//                for (int i1 = 0; i1 < lignes; i1++) {
//                    for (int j1 = 0; j1 < colonnes; j1++) {
//                        System.out.print(tableau[i1][j1] + " ");
//                    }
//                    System.out.println();
//                }
            }
        }






        for (int j = 0; j < colonnes; j++) {
            int writeIndex = lignes - 1; // Commencer tout en bas

            for (int i = lignes - 1; i >= 0; i--) {
                if (tableau[i][j] != null) {
                    tableau[writeIndex][j] = tableau[i][j]; // Déplacer le bloc vers le bas
                    if (writeIndex != i) {
                        tableau[i][j] = null; // Vider l'ancienne position
                    }
                    writeIndex--; // Monter l'index d'écriture
                }
            }
        }


//        int hauteur2 = lignes-1;
//
//        for (int j2 = 0; j2 < colonnes; j2++) {
//            for (int i2 = hauteur2; i2 >= 0; i2--) {
//                if (tableau[hauteur2][j2] == null) {
//                    tableau[hauteur2][j2] = tableau[hauteur2 - 1][j2];
//                    tableau[hauteur2 - 1][j2] = null;
//                }
//            }
//        }

        // print tableau
//        System.out.println();
//        System.out.println();
//        System.out.println("tableau sortie boucle");
//        for (int i1 = 0; i1 < lignes; i1++) {
//            for (int j1 = 0; j1 < colonnes; j1++) {
//                System.out.print(tableau[i1][j1] + " ");
//            }
//            System.out.println();
//        }







        // Afficher le tableau sous forme de tableau de blocs
        if (lignes != 0) {
            for (int i = 0; i < lignes; i++) {
                if (i != lignes - 1) {
                    Monde.ecrire2(Couleur.bleu, "  |       ");
                } else {
                    Monde.ecrire2(Couleur.bleu, "=====     ");
                }

                for (int j = 0; j < colonnes; j++) {
                    if (tableau[i][j] != null) {
                        tableau[i][j].afficherBloc(); // Affiche le nom du bloc
                    } else {
                        System.out.print("  "); // Espace si aucun bloc à cet emplacement
                    }
                }
                System.out.println();
            }
        } else {
            Monde.ecrire2(Couleur.bleu, "=====     ");
        }
    }



}
