package LearnJava.Abstract;

public class Main {
    public static void main(String[] args) {
        //Les méthodes d'un chien
        Chien c = new Chien("Gris bleuté", 20);
        c.boire();
        c.manger();
        c.deplacement();
        c.crier();
        System.out.println(c.toString());

        System.out.println("--------------------------------------------");
        //Les méthodes de l'interface
        c.faireCalin();
        c.faireLechouille();
        c.faireLeBeau();

        System.out.println("--------------------------------------------");
        //Utilisons le polymorphisme de notre interface
        Rintintin r = new Chien();
        r.faireCalin();
        r.faireLechouille();
        r.faireLeBeau();
    }
}