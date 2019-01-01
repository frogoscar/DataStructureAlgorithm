package Paradigm.Backtracking;

// This code can be improved, see Permutations.java
public class PermuteString {
    static void permuteHelper(String s, String chosen) {
        if (s.isEmpty()) {
            System.out.println(chosen);
        }
        for (int i = 0; i < s.length(); i++) {
            // Choose
            char c = s.charAt(i);
            chosen += c;
            StringBuilder sb1 = new StringBuilder(s);
            sb1.deleteCharAt(i);
            s = sb1.toString();

            // Explore
            permuteHelper(s, chosen);

            // Un-choose
            StringBuilder sb2 = new StringBuilder(s);
            sb2.insert(i, c);
            s = sb2.toString();

            StringBuilder sb3 = new StringBuilder(chosen);
            sb3.deleteCharAt(chosen.length() - 1);
            chosen = sb3.toString();
        }
    }

    static void permute(String s) {
        permuteHelper(s, "");
    }

    public static void main(String[] args) {
        permute("OSCAR");
    }
}
