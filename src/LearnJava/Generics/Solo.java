package LearnJava.Generics;

import java.util.ArrayList;
import java.util.List;

public class Solo<T> {
    private T valeur;

    public Solo() {
        this.valeur = null;
    }

    public Solo(T val) {
        this.valeur = val;
    }

    public void setValeur(T val) {
        this.valeur = val;
    }

    public T getValeur() {
        return valeur;
    }

    public static void main(String[] args) {
        Solo<Integer> soloI = new Solo<>(12);
        Solo<String> soloS = new Solo<>("toto");
        Solo<Float> soloF = new Solo<>(13.4f);
        Solo<Double> soloD = new Solo<>(12.3);

        // Autoboxing
        int i = new Integer(12);
        double d = new Double(12.3);
        Double d1 = 12.2;
        Character c = 'c';
        List l = new ArrayList();
        l.add(12);
    }
}
