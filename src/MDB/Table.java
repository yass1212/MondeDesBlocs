package MDB;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<Bloc> sommets = new ArrayList<Bloc> ();

    public void Ajout_bloc_table(final Bloc BlocAjouter) {
    }

    public Bloc verifieDispoSommet(final TailleCube taille, final String couleur) {
        Bloc res = null;
        for(Bloc bloc : sommets) {
        	if (bloc.Correspond_description(taille, couleur)) {
				res = bloc;
			}
        }
        return res;
       
    }

    public void Ajout_bloc_sommet(final Bloc cube) {
    }

    public Bloc renvoieBloc(final String taille, final String couleur) {
        // TODO Auto-generated return
        return null;
    }

    public boolean majSommet(final Bloc BlocSocle, final Bloc BlocPose) {
        // TODO Auto-generated return
        return false;
    }

}
