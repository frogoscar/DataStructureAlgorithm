package CTCI.Ch01_Array_String.Q1_06_String_Compression;

public class QuestionB {
	/**
	 * Question :
	 * Implement a method to perform basic string compression using the counts
	 * of repeated characters. For example, the string aabcccccaaa would become
	 * a2blc5a3. If the "compressed" string would not become smaller than the
	 * original string, your method should return the original string.
	 * You can assume the string has only uppercase and lowercase letters (a - z).
	 *
	 * Answer :
	 * You should first ask your interviewer if the string is an ASCII string
	 * or Unicode string. We will assume for simplicity the character set is ASCII.
	 */

	public static String compress(String str) {
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			
			/* If next character is different than current, append this char to result.*/
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;
	}
	
	public static void main(String[] args) {
		String str = "aa";
		System.out.println(str);
		System.out.println(compress(str));
	}
}
