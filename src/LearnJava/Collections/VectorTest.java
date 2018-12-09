package LearnJava.Collections;

import java.util.ListIterator;
import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        // Vector is synchronized while ArrayList is asynchronized (Thread-Safe)
        // otherwise they are pretty equal
        Vector vector = new Vector();
        vector.add(null);
        vector.add(12);
        vector.add("Une chaine de caractere");
        vector.add(12);
        vector.add('d');

        for (int i = 0; i < vector.size(); i++) {
            System.out.println("donnée à l'indice " + i + " = " + vector.get(i));
        }
        System.out.println("\n \tParcours avec un itérateur ");
        System.out.println("-----------------------------------");
        ListIterator li = vector.listIterator();
        while (li.hasNext()) {
            System.out.println(li.next());
        }
    }
}
