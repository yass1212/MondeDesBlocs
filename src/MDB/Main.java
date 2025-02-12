package src.MDB;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello");


        Bloc bloc = new Bloc();
        bloc.Cree_bloc("GRAND", "ROUGE");
        TailleBloc taille1 = TailleBloc.MOYEN;
        bloc.Correspond_description(taille1, "rouge");


    }

}
