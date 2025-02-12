package src.MDB;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello");


        TailleBloc taillePETIT = TailleBloc.PETIT;
        TailleBloc tailleMOYEN = TailleBloc.MOYEN;
        TailleBloc tailleGRAND = TailleBloc.GRAND;



        Bloc blocA = new Bloc(TailleBloc.PETIT, "ROUGE");
        Bloc blocB = new Bloc(taillePETIT, "VERT");
        Bloc blocC = new Bloc(taillePETIT, "Jaune");



        blocA.Correspond_description(taillePETIT, "rouge");
        
        Table table1 = new Table();
        
        table1.Ajout_bloc_table(blocA);
        table1.Ajout_bloc_table(blocB);
        System.out.println((table1.verifieDispoSommet(taillePETIT, "VERT")));
        System.out.println(table1.verifieDispoSommet(taillePETIT, "ROSE"));
        System.out.println(table1.verifieDispoSommet(tailleGRAND, "VERT"));
        
        table1.Ajout_bloc_sommet(taillePETIT, "VERT", blocC);
        
        //System.out.println(table1.sommets.get(1).getCouleur());
        
        
        




    }

}
