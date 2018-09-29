package se.kattis;

import java.util.Scanner;

public class SevenWonders {

	public static void main(String[] args) {
		//https://open.kattis.com/problems/sevenwonders
		//https://open.kattis.com/problems/parking2
		//https://open.kattis.com/problems/shopaholic
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		
		long T = input.chars().filter(p -> p == 'T').count();
		long G = input.chars().filter(p -> p == 'G').count();
		long C = input.chars().filter(p -> p == 'C').count();
		
		long sum = T*T+G*G+C*C;
		
		long min = Math.min(C, Math.min(T, G));
		System.out.print(sum + 7*min);
		
	}

}
