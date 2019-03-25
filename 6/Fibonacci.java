import java.util.*;

public class Fibonacci {
	public static void main(String[] args) {
		// Get ready for the brute-force method!
		// create a list of all fibonacci numbers
		List<Integer> possibleNums = new ArrayList<Integer>();
		int i = 0, j = 1;
		while(i < 123456789) {
			int temp = j;
			j = i + j;
			i = temp;
			possibleNums.add(i);
		}
		
		boolean working = true;
		Scanner scan = new Scanner(System.in);
		
		while(working) {
			int input = scan.nextInt();
			if(input != 0) {
				int numNumsSmaller = 0;
				while(possibleNums.get(numNumsSmaller) < input)
					numNumsSmaller++;
				System.out.println("sequence: " + possibleCombo(0, numNumsSmaller, input, possibleNums));
			} else {
				working = false;
			}
		}
	}
	
	private static String possibleCombo(int currentSum, int maxNumIndex, int targetSum, List<Integer> possibleNums) {
		for(int i = maxNumIndex; i >= 0; i--) {
			// count down due to the largest numbers creating the shortest sequences
			int newSum = currentSum + possibleNums.get(i).intValue();
			if(newSum == targetSum)
				return possibleNums.get(i).toString();
			else if (newSum < targetSum) {
				if(maxNumIndex > 0) { // can't use a negative index
					String output = possibleCombo(newSum, maxNumIndex - 1, targetSum, possibleNums);
					// only return if it succeeds
					if(output != null)
						return output + " " + possibleNums.get(i).toString();
				}
			} // else larger than sum, which is invalid
		}
		return null; // failed
	}
	
}