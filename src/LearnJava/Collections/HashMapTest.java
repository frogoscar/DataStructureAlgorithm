package LearnJava.Collections;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap hm = new HashMap();
        hm.put(1, "printemps");
        hm.put(10, "ete");
        hm.put(15, "automne");
        hm.put(45, "hiver");
        hm.put(100, null);

        Iterator keyIt = hm.keySet().iterator();

        System.out.println("\n \tParcours des cles ");
        System.out.println("-----------------------------------");
        while (keyIt.hasNext()) {
            System.out.println(keyIt.next());
        }

        Iterator valueIt = hm.values().iterator();

        System.out.println("\n \tParcours des values ");
        System.out.println("-----------------------------------");
        while (valueIt.hasNext()) {
            System.out.println(valueIt.next());
        }
    }
}
