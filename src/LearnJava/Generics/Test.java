package LearnJava.Generics;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println("Liste de String");
        System.out.println("------------------------------");
        List<String> listeString= new ArrayList<>();
        listeString.add("Une chaîne");
        listeString.add("Une autre");
        listeString.add("Encore une autre");
        listeString.add("Allez, une dernière");

        for (String str : listeString) {
            System.out.println(str);
        }

        System.out.println("\nListe de float");
        System.out.println("------------------------------");

        List<Float> listeFloat = new ArrayList<>();
        listeFloat.add(12.25f);
        listeFloat.add(15.25f);
        listeFloat.add(2.25f);
        listeFloat.add(128764.25f);

        for (float f : listeFloat) {
            System.out.println(f);
        }
    }
}
