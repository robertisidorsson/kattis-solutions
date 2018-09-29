package se.kattis;

import java.util.Scanner;

public class Rot {

	public static void main(String[] args) {
		StringBuffer alfas = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVXYZ_.");
		int len = alfas.length();

		Scanner scan = new Scanner(System.in);
		String s1 = scan.nextLine();
		int rot = 3;

		StringBuilder sb = new StringBuilder(s1);
		sb = sb.reverse();
		System.out.println("Reversed:" + sb.toString());
		for(int i=0; i<s1.length(); i++) {		
			char c = sb.charAt(i);

			int index = alfas.indexOf(c+"");
			int r = (index + rot) % len;

			char replacement = alfas.charAt(r);
			sb.setCharAt(i, replacement);
		}
		scan.close();
		System.out.println(sb.toString());
	}

}
