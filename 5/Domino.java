import java.util.*;

public class Domino {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numTrials = scan.nextInt();
		for(int i = 0; i < numTrials; i++) {
			int numRows = scan.nextInt();
			int dominosPerRow = numRows;
			int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			int x2 = scan.nextInt();
			int y2 = scan.nextInt();
			
			int result = Math.abs(x2 - x1) + Math.abs(y2 - y1);
			System.out.println("Output: " + result);
			
		}
	}
}