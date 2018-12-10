package LearnJava.Generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void afficherExtends(List<? extends Voiture> list) {
        for (Voiture v : list) {
            System.out.println(v);
        }
    }

    static void afficherSuper(List<? super Voiture> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        List<Voiture> listVoiture = new ArrayList<>();
        listVoiture.add(new Voiture());
        listVoiture.add(new Voiture());
        afficherExtends(listVoiture);

        List<VoitureSansPermis> listVoitureSP = new ArrayList<>();
        listVoitureSP.add(new VoitureSansPermis());
        listVoitureSP.add(new VoitureSansPermis());
        afficherExtends(listVoitureSP);

        afficherSuper(listVoiture);

        System.out.println("---------------------");

        Garage garage = new Garage();
        garage.add(listVoiture);
        System.out.println("---------------------");
        garage.add(listVoitureSP);
    }
}
