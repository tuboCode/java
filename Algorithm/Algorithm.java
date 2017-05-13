package com.cs.Algorithm;

public class Algorithm {

	public int Algorithm (String haystack,String neddle){
		if(haystack == null && neddle == null) return 0;
		if(haystack == null) return -1;
		if(neddle == null) return 0;
		for(int i=0; i<haystack.length()-neddle.length()+1;i++){
			int j=0;
			for(; j<neddle.length();j++){
				if(haystack.charAt(i+j)!=neddle.charAt(j)) break;
			}
			if(j==neddle.length()) return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		Algorithm alg = new Algorithm();
		System.out.println(alg.Algorithm("abcde", "cd"));
	}
}
