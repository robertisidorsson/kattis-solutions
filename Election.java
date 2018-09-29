package se.kattis;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Election {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer cases = scan.nextInt();

		for(int i=0; i<cases; i++)  {

			Integer candidates = scan.nextInt();
			Integer[] votes = new Integer[candidates];

			for(int j=0; j<candidates; j++) {
				votes[j] = scan.nextInt();
			}

			List<Integer> listVotes = Arrays.asList(votes);
			Integer max = listVotes.stream().reduce(0,(a,b)->Math.max(a,b));
			Integer totalVotes = listVotes.stream().reduce(0, Integer::sum);

			boolean duplicates = 
					listVotes.stream()
					.collect(Collectors.groupingBy(
							Function.identity(), Collectors.counting()))
					.entrySet().stream().filter(e -> e.getKey().equals(max))
					.anyMatch(e -> e.getValue()>1);

			Integer half = totalVotes / 2;

			if (duplicates)  {
				System.out.println("no winner");
			}
			else {
				OptionalInt winner = IntStream.range(0, listVotes.size())
						.filter(p -> listVotes.get(p).equals(max))
						.findFirst();
				int winningNr = winner.getAsInt() + 1;
				
				if (max > half.intValue()) {
					System.out.println("majority winner " + winningNr);
				}
				else {
					System.out.println("minority winner " + winningNr);				
				}
			}          
			//System.out.println("winning nr votes:"+max+ " total votes:"+totalVotes + " half votes:"+ half + " single winner:" + !duplicates);
		}
		scan.close();
	}

}
