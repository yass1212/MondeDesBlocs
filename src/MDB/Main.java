package MDB;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello");



        Monde monde = new Monde();


        TailleBloc taillePETIT = TailleBloc.PETIT;
        TailleBloc tailleMOYEN = TailleBloc.MOYEN;
        TailleBloc tailleGRAND = TailleBloc.GRAND;



        Bloc blocA = new Bloc(TailleBloc.PETIT, Couleur.rouge);
        Bloc blocB = new Bloc(taillePETIT, Couleur.vert);
        Bloc blocC = new Bloc(taillePETIT, Couleur.jaune);



        blocA.Correspond_description(taillePETIT, Couleur.rouge);
        
        Table table1 = new Table();
        
        table1.Ajout_bloc_table(blocA);
        table1.Ajout_bloc_table(blocB);
        System.out.println((table1.verifieDispoSommet(taillePETIT, Couleur.vert)));
        System.out.println(table1.verifieDispoSommet(taillePETIT, Couleur.violet));
        System.out.println(table1.verifieDispoSommet(tailleGRAND, Couleur.vert));
        
        table1.Ajout_bloc_sommet(taillePETIT, Couleur.vert, blocC);
        
        //System.out.println(table1.sommets.get(1).getCouleur());
        
        
        
        //Bloc blocA = new Bloc(TailleBloc.PETIT, Couleur.rouge);




        blocA.Correspond_description(taillePETIT, Couleur.rouge);




    }

}
