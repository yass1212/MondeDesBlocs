package src.MDB;

import java.lang.reflect.Array;
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

    public void Ajout_bloc_sommet(TailleBloc tailleSocle, Couleur couleurSocle, Bloc blocAjouter) {
    	Bloc blocSocle = verifieDispoSommet(tailleSocle, couleurSocle);
    	if (blocSocle != null) {
    		majSommet(blocSocle, blocAjouter);
			
		} else {
			System.out.println("Aucun Sommet correspondant");
		}
    	
    }


    public Bloc renvoieBloc(final TailleBloc taille, final Couleur couleur) {
        Bloc res = verifieDispoSommet(taille, couleur);
        if (res == null) {
            System.out.println("Aucun bloc au sommet des piles ne corresponds à la description");
        } else {
            System.out.println("Bloc saisi !");
        }
        majSommet(res, res.demandeBlocDessous());
        System.out.println("RES :");
        System.out.println(res);
        res.afficherBloc();
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

        // Remplir le tableau avec les blocs
        for (int j = 0; j < colonnes; j++) {
            Bloc bloc = sommets.get(j);
            int hauteur = 0;
            while (bloc != null) {
                tableau[lignes - hauteur - 1][j] = bloc; // Remplir du bas vers le haut
                hauteur++;
                bloc = bloc.getDessous();
            }
        }




        // Afficher le tableau sous forme de tableau de blocs
        for (int i = lignes-1; i >= 0; i--) {
            for (int j = 0; j < colonnes; j++) {
                if (tableau[i][j] != null) {
                    tableau[i][j].afficherBloc(); // Affiche le nom du bloc
                } else {
                    System.out.print("  "); // Espace si aucun bloc à cet emplacement
                }
            }
            System.out.println();
        }
    }



}
