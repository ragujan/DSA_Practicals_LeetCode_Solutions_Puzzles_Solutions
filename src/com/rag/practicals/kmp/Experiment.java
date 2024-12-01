package com.rag.practicals.kmp;

public class Experiment {
    public static void main(String[] args) {
        String original = "ababaca";
        combineLastToFront(original);
    }
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
    public static void combineLastToFront(String s) {

        if (s == null || s.length() == 0) {
            return ;
        }

        
        String s_rev = new StringBuilder(s).reverse().toString();

        
        String combined = s + "#" + s_rev;

        System.out.println("combined "+combined);
        
        int[] lps = computeLPS(combined);
        for (int i = 0; i < lps.length; i++) {
            System.out.println("i "+i+" "+lps[i] + " ");
        }

        int longest_palindromic_prefix_length = lps[lps.length - 1];

        System.out.println("suffix prepend index "+longest_palindromic_prefix_length);
        String suffixToPrepend = s.substring(longest_palindromic_prefix_length);
        System.out.println("suffix to Prepend "+suffixToPrepend);
        String result = new StringBuilder(suffixToPrepend).reverse().toString() + s;
        System.out.println("result "+result);


    }
}
