package CTCI.Ch01_Array_String.Q1_04_Palindrome_Permutation;

public class PalindromePermutation {
    /**
     * Question :
     * Given a string, write a function to check if it is a permutation of a palindrome.
     * A palindrome is a word or phrase that is the same forwards and backwards.
     * A permutation is a rearrangement of letters. The palindrome does not need to be
     * limited to just dictionary words.
     *
     * EXAMPLE ：
     * Input: Tact Coa
     * Output: True (permutations: "taco cat'; "atc o eta·; etc.)
     *
     * Answer :
     * A palindrome is a string that is the same forwards and backwards.
     * Therefore, to decide if a string is a permutation of a palindrome,
     * we need to know if it can be written such that it's the same forwards and backwards.
     * What does it take to be able to write a set of characters the same way
     * forwards and backwards? We need to have an even number of almost all characters,
     * so that half can be on one side and half can be on the other side.
     * At most one character (the middle character) can have an odd count.
     *
     * Conclusion : to be a permutation of a palindrome,
     * a string can have no more than one character that is odd.
     * This will cover both the odd and the even cases.
     */
    static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');

        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    /**
     * Solution 1 : O(n)
     * We use a hash table to count how many times each character appears.
     * Then, we iterate through the hash table and ensure that no more than
     * one character has an odd count.
     * @param phrase
     * @return
     */
    static boolean isPermutationOfPalindrome_1(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    /**
     * Solution 2 : O(n). Simplify Solution 1
     * @param phrase
     * @return
     */
    static boolean isPermutationOfPalindrome_2(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z')
                - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;

                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    public static void main(String[] args) {
        String pali = "Rats live on no evil star";
        System.out.println(isPermutationOfPalindrome_1(pali));
    }
}
