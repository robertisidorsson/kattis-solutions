package se.kattis;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aurora {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String test = scan.nextLine();
		StringBuffer buf = new StringBuffer();
		buf.append(test.charAt(0));
		
		Pattern pattern = Pattern.compile("[-][A-ZÄÅÖ]+");
		Matcher matcher = pattern.matcher(test);
		while (matcher.find()) {
			buf.append(test.charAt(matcher.start()+1));
		}
		
		System.out.println(buf.toString());
		scan.close();
	}
}

