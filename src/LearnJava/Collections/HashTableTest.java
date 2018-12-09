package LearnJava.Collections;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableTest {
    public static void main(String[] args) {
        Hashtable ht = new Hashtable();
        ht.put(1, "printemps");
        ht.put(10, "ete");
        ht.put(15, "automne");
        ht.put(45, "hiver");

        Enumeration e1 = ht.keys();

        System.out.println("\n \tParcours des cles ");
        System.out.println("-----------------------------------");
        while (e1.hasMoreElements()) {
            System.out.println(e1.nextElement());
        }

        Enumeration e2 = ht.elements();

        System.out.println("\n \tParcours des values ");
        System.out.println("-----------------------------------");
        while (e2.hasMoreElements()) {
            System.out.println(e2.nextElement());
        }
    }
}
