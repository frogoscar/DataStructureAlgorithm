package LearnJava.Generics;

public class Duo<T, S> {
    private T valeur1;
    private S valeur2;

    public Duo() {
        valeur1 = null;
        valeur2 = null;
    }

    public Duo(T valeur1, S valeur2) {
        this.valeur1 = valeur1;
        this.valeur2 = valeur2;
    }

    public void setValeur(T valeur1, S valeur2) {
        this.valeur1 = valeur1;
        this.valeur2 = valeur2;
    }

    public void setValeur1(T valeur1) {
        this.valeur1 = valeur1;
    }

    public void setValeur2(S valeur2) {
        this.valeur2 = valeur2;
    }

    public T getValeur1() {
        return valeur1;
    }

    public S getValeur2() {
        return valeur2;
    }

    public static void main(String[] args) {
        Duo<String, Boolean> dual = new Duo<>("toto", true);
        System.out.println("Valeur de l'objet dual : val1 = " + dual.getValeur1() + ", val2 = " + dual.getValeur2());
        Duo<Character, Double> dual2 = new Duo<>('C', 12.3);
        System.out.println("Valeur de l'objet dual2 : val1 = " + dual2.getValeur1() + ", val2 = " + dual2.getValeur2());
    }
}
