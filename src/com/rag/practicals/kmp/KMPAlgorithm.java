package com.rag.practicals.kmp;

public class KMPAlgorithm {

	public static int[] computeLPS(String pattern) {
		
		int n = pattern.length();
		int[] lps = new int[n];
		int len = 0;
		int i = 1;
		lps[0] = 0;
		
		while(i<n) {
			if(pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}else {
				if(len!=0) {
					len = lps[len-1];
				}else {
					lps[i] = 0;
					i++;
				}
			}
		}
		
		
		return lps;
		
	}
	
	public static void KMPSearch(String text, String pattern) {
		System.out.println("hey");
		int m = pattern.length();
		int n = text.length();
		
//		genereate the LPS array
		int[] lps = computeLPS(pattern);

		int i = 0; //index for text
		int j = 0; //index for pattern

		while(i<n) {
			if(text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}
			System.out.println("i "+i + " j "+j);
			if(j==m) {
				System.out.println("came here");
				System.out.println("Pattern found at index "+(i -j));
				j = lps[j-1];
			}else if(i<n && pattern.charAt(j)  != text.charAt(i)) {
			System.out.println("mis match scenarios");
				if(j!=0) {
					j = lps[j-1];
				}else {
					i++;
				}
				
			}
		}
		


	}

    public static void main(String[] args) {
    	
        String text = "abababcbababaca";   	

        String pattern = "ababaca";
        
        KMPSearch(text, pattern);

    }

	
}
