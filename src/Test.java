import java.util.*;

public class Test {

    static <T> void print(T[][] array) {
        for (T[] i : array) {
            for (T j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[][] names = {{"Sam", "Smith"}, {"Oscar", "Frog"}, {"Lily", "Happy", "Momo"}};
        print(names);
    }
}
