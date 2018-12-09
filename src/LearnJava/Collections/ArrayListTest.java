package LearnJava.Collections;

import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(null);
        al.add(12);
        al.add("Une chaine de caractere");
        al.add(12);
        al.add('d');

        for (int i = 0; i < al.size(); i++) {
            System.out.println("donnée à l'indice " + i + " = " + al.get(i));
        }
        System.out.println("\n \tParcours avec un itérateur ");
        System.out.println("-----------------------------------");
        ListIterator li = al.listIterator();
        while (li.hasNext()) {
            System.out.println(li.next());
        }
    }
}
