package LearnJava.Collections;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet hs = new HashSet();
        hs.add("toto");
        hs.add(12);
        hs.add(null);
        hs.add(12);
        hs.add('d');

        System.out.println("\nParcours avec un iterateur");
        System.out.println("-----------------------------------");
        Iterator it = hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nParcours avec un tableau d'objet");
        System.out.println("-----------------------------------");
        Object[] objects = hs.toArray();
        for (Object o : objects) {
            System.out.println(o);
        }
    }
}
