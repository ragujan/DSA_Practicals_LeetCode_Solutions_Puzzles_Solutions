package com.rag.practicals.shortest_palindrome;

public class Test1 {

	public static String shortestPalindrome(String s) {
		String lgPalin = getLongestPalindrome(s);
		System.out.println("original string " + s);
		System.out.println("lg palin " + lgPalin);
		String finalMerged = "";
		if (lgPalin != "") {

			System.out.println("index of " + lgPalin + " " + s.indexOf(lgPalin));
			int palinStartsAt = s.indexOf(lgPalin);
			String halfFromPalin = s.substring(palinStartsAt + (lgPalin.length() / 2));
//			if (lgPalin.length() == s.length() - 1) {
//				halfFromPalin = s.substring(palinStartsAt);
//			}
			System.out.println("half is " + halfFromPalin);
			String reversedHalf = "";

			for (int i = halfFromPalin.length() - 1; i >= 1; i--) {
				reversedHalf += halfFromPalin.charAt(i);
			}
			System.out.println("reversed half from palin " + reversedHalf);
			finalMerged = reversedHalf + halfFromPalin;
			System.out.println("merged half and reversed " + finalMerged);
		} else {

			String reversedHalf = "";
			for (int i = s.length() - 1; i >= 1; i--) {
				reversedHalf += s.charAt(i);
			}
			System.out.println("reversed half from palin " + reversedHalf);
			finalMerged = reversedHalf + s;
			System.out.println("merged half and reversed " + finalMerged);
		}

		return finalMerged;
	}

	public static void main(String[] args) {
//		shortestPalindrome("aacecaaa");
//		shortestPalindrome("abb");
		shortestPalindrome("raacecaaa");
	}

	public static String getLongestPalindrome(String s) {
		String longestPalindrome = "";
		for (int i = 0; i < s.length(); i++) {
			String oddPalindrome = expandAroundCenter(s, i, i);

			if (oddPalindrome.length() > longestPalindrome.length()) {

				longestPalindrome = oddPalindrome;
			}

			String evenPalindrome = expandAroundCenter(s, i, i + 1);
			if (evenPalindrome.length() > longestPalindrome.length()) {
				longestPalindrome = evenPalindrome;
			}
		}
		return longestPalindrome;
	}

	private static String expandAroundCenter(String s, int left, int right) {

		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;

		}
		return s.substring(left + 1, right);
	}
}
