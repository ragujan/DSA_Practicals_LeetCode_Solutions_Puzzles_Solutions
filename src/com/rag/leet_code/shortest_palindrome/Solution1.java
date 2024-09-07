package com.rag.leet_code.shortest_palindrome;

public class Solution1 {

	public static String shortestPalindrome(String s) {
        int base = 131;
        int mul = 1;
        int mod = (int) 1e9 + 7;
        int prefix = 0;
        int suffix = 0;
        
        int idx = 0;
        int sLength = s.length();
        
        for(int i =0; i<sLength;i++) {
        	char xx = s.charAt(i);
        	int t = s.charAt(i) - 'a'+1;
        	
        	var someCal = (prefix * base +t);
        	var afterMod = someCal % mod;
        	var afterModInLong = (long) afterMod;
        	prefix = (int) afterModInLong;
        	
        	
        }
        
        
        
		
		return "hey";
	}
	public static void main(String[] args) {
		shortestPalindrome("abaaatrag");
	}
}
