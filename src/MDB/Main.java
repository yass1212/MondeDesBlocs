package src.MDB;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello");


        TailleBloc taillePETIT = TailleBloc.PETIT;
        TailleBloc tailleMOYEN = TailleBloc.MOYEN;
        TailleBloc tailleGRAND = TailleBloc.GRAND;



        Bloc blocA = new Bloc(TailleBloc.PETIT, "ROUGE");




        blocA.Correspond_description(taillePETIT, "rouge");




    }

}
