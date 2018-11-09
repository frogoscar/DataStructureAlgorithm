package Problems;

import java.util.Arrays;

public class MissingInteger {
    static int solution(final int[] A) {
        Arrays.sort(A);
        int min = 1;

        // Starting from 1 (min), compare all elements, if it does not match
        // that would be the missing number.
        for (int i : A) {
            if (i == min) {
                min++;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] A1 = {1, 2, 1, 3, 4, 5, 6};
        int[] A2 = {-1, -2, -3, -4};

        System.out.println(solution(A1));
        System.out.println(solution(A2));
    }
}
