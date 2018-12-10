package LearnJava.Generics;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    List<Voiture> list = new ArrayList<>();

    public void add(List<? extends Voiture> listVoiture) {
        for (Voiture v : listVoiture) {
            list.add(v);
        }

        System.out.println("Contenu de notre garage");
        for (Voiture v : list) {
            System.out.println(v);
        }
    }
}
