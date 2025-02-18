package MDB;

import java.util.ArrayList;
import java.util.List;


public class Table {

    /// SOMMETS ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<Bloc> sommets;



    /// CONSTRUCTEUR ///////////////////////////////////////////////////////////////////////////////////////////////////

    // constructeur de la table
    public Table() {
    	this.sommets = new ArrayList<Bloc>();
    }



    /// METHODES ///////////////////////////////////////////////////////////////////////////////////////////////////////

    // ajoute un bloc à la table
    public void Ajout_bloc_table(final Bloc BlocAjouter) {
    	sommets.add(BlocAjouter);
    }



    // vérifie si un bloc correspond à la description donnée
    public Bloc verifieDispoSommet(final TailleBloc taille, final Couleur couleur, final TailleBloc tailleAjouter, final Couleur couleurAjouter) {
        Bloc res = null;
        for(Bloc bloc : sommets) {

            if (tailleAjouter != null && couleurAjouter != null) {
                if (bloc.Correspond_description(taille, couleur, tailleAjouter, couleurAjouter)) {
                    res = bloc;
                }
            } else {
                if (bloc.TailleSuffisante(tailleAjouter)) {
                    if (bloc.getCouleur().equals(couleurAjouter)) {
                        res = bloc;
                    }
                }
            }
        }
        return res;
       
    }



    // ajoute un bloc à un sommet
    public boolean Ajout_bloc_sommet(TailleBloc tailleSocle, Couleur couleurSocle, Bloc blocAjouter) {
    	Bloc blocSocle = verifieDispoSommet(tailleSocle, couleurSocle, blocAjouter.getTaille(), blocAjouter.getCouleur());
    	if (blocSocle != null) {
            blocAjouter.setDessous(blocSocle);
    		majSommet(blocSocle, blocAjouter);
            return true;
			
		}

        System.out.println("Aucun Sommet correspondant");
        return false;
    }



    // renvoie un bloc correspondant à la description donnée
    public Bloc renvoieBloc(final TailleBloc taille, final Couleur couleur, Bloc blocAjouter) {

        Bloc res = null;
        if (blocAjouter == null) {
            res = verifieDispoSommet(taille, couleur, null, null);
        } else {
            res = verifieDispoSommet(taille, couleur, blocAjouter.getTaille(), blocAjouter.getCouleur());
        }

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
            res.afficherBloc();
        } else {
            System.out.println("RES NULL");
        }
        return res;
    }



    // met à jour un sommet par un autre ou le supprime (en fonction de BlocPose)
    public void majSommet(final Bloc BlocSocle, final Bloc BlocPose) {

        if (BlocPose == null) {
            sommets.remove(BlocSocle);
        } else {
            sommets.remove(BlocSocle);
            sommets.add(BlocPose);
        }

    }



    // affiche la table
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

        // Remplir le tableau avec les blocs
        for (int j = 0; j < colonnes; j++) {
            Bloc bloc = sommets.get(j);
            int hauteur = 0;
            while (bloc != null) {
                tableau[hauteur][j] = bloc; // Remplir du bas vers le haut
                hauteur++;
                bloc = bloc.getDessous();
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


        // Afficher le tableau sous forme de tableau de blocs
        if (lignes != 0) {
            for (int i = 0; i < lignes; i++) {
                if (i != lignes - 1) {
                    Monde.ecrireEspace(Couleur.bleu, "  |       ");
                } else {
                    Monde.ecrireEspace(Couleur.bleu, "=====     ");
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
            Monde.ecrireEspace(Couleur.bleu, "=====     ");
        }
    }



}
