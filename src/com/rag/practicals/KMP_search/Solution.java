package com.rag.practicals.KMP_search;

public class Solution {
    public static String test(String pat, String txt){
        int M = pat.length();
        int N = txt.length();

        int[] lps = new int[M];
        int j = 0;


        return "hey";
    }

    public void computeLPSArray(String pat, int M, int[] lps){
        int len = 0;
        int i =1;
        lps[0] = 0;

        while(i < M){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len !=0){
                    len = lps[len-1];
                }else{
                    lps[i] = len;
                    i++;
                }
            }

        }


    }
    public static void main(String[] args){
        
    }
}
