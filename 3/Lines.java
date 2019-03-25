import java.util.*;

public class Lines {
	public static void main(String[] args) {
		boolean running = true;
		while(running) {
			double sum = 0;
			Scanner scan = new Scanner(System.in);
			List<Integer> values = new ArrayList<Integer>();
			while(true) {
				int input = scan.nextInt();
				if(input == -1) {
					running = false;
					break;
				} else if (input == 0) {
					break;
				} else {
					sum += input;
					values.add(input);
				}
			}
			if(running && values.size() != 0) {
				double mean = sum / values.size();
				List<String> larger = new ArrayList<String>();
				List<String> smallerOrEqual = new ArrayList<String>();
				for(Integer val : values) {
					if(val <= mean)
						smallerOrEqual.add(val.toString());
					else
						larger.add(val.toString());
				}
				printLine();
				int maxSize = Math.max(larger.size(), smallerOrEqual.size());
				for(int i = 0; i < maxSize; i++) {
					String left, right;
					if(i < smallerOrEqual.size()) {
						left = smallerOrEqual.get(i);
					} else {
						left = "*";
					}
					if(i < larger.size()) {
						right = larger.get(i);
					} else {
						right = "*";
					}
					int leftSpaces = 4 - left.length();
					int rightSpaces = 5 - right.length();
					drawSpaces(leftSpaces);
					System.out.print(left);
					drawSpaces(rightSpaces);
					System.out.println(right);
				}
				printLine();
			}
		}
	}
	
	private static void printLine() {
		System.out.println("----------");
	}
	private static void drawSpaces(int count) {
		for(int i = 0; i < count; i++)
			System.out.print(" ");
	}
}