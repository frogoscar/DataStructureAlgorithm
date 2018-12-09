package LearnJava.Interface;

import LearnJava.Interface.Comportements.Operation;

public class Main {
    public static void main(String[] args) {
//        Personnage[] tPers = {new Guerrier(), new Chirurgien(), new Civil(), new Sniper(), new Medecin()};
//        for (Personnage p : tPers) {
//            System.out.println("\nInstance de " + p.getClass().getName());
//            System.out.println("*****************************************");
//            p.combattre();
//            p.soigner();
//            p.seDeplacer();
//        }

        Personnage pers = new Guerrier();
        pers.soigner();
        pers.setSoin(new Operation());
        pers.soigner();
    }
}