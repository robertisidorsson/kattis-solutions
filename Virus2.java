package se.kattis;

import java.util.*;

public class Virus2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String s1 = scan.nextLine();
		String s2 = scan.nextLine();

		int i = 0, j = 0;
		while ((i < s1.length() && i < s2.length())
				&& (s1.charAt(i) == s2.charAt(i))) {
			i++;
		}
		while ((j < s1.length() && j < s2.length()) && 
				(s1.charAt(s1.length()-1-j) == s2.charAt(s2.length()-1-j))) {
			j++;
		}
		
		j = s2.length() - j;

		int ans = Math.max(j-i, 0);
		System.out.println(Math.max(ans, s2.length()-s1.length()));
		scan.close();
	}
}