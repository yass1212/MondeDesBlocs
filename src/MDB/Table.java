package src.MDB;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<Bloc> sommets = new ArrayList<Bloc> ();

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

    public void Ajout_bloc_sommet(final TailleBloc taille, final Couleur couleur) {
    }

    public Bloc renvoieBloc(final TailleBloc taille, final Couleur couleur) {
        // TODO Auto-generated return
        return null;
    }

    public boolean majSommet(final Bloc BlocSocle, final Bloc BlocPose) {
        // TODO Auto-generated return
        return false;
    }

}
