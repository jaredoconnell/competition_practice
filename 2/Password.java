import java.util.*;

public class Password {
	public static void main(String[] args) {
		boolean running = true;
		Scanner scan = new Scanner(System.in);
		while(running) {
			String input = scan.next();
			boolean accepted = true;
			Set<Integer> values = new HashSet<Integer>();
			if(input.length() != 6)
				if(input.equals("0")) {
					running = false;
				} else {
					accepted = false;
				}
			else {
				int lastLastVal = -100;
				int lastVal = -100;
				for(int i = 0; i < input.length(); i++) {
					int value = Integer.parseInt("" + input.charAt(i));
					// limit identical digits
					if(value == lastVal && lastVal == lastLastVal) {
						accepted = false;
						break;
					}
					// Increasing consecutive values
					if(value == lastVal + 1 && lastVal == lastLastVal + 1) {
						accepted = false;
						break;
					}
					// Decreasing consecutive values
					if(value == lastVal - 1 && lastVal == lastLastVal - 1) {
						accepted = false;
						break;
					}
					values.add(new Integer(value));

					lastLastVal = lastVal;
					lastVal = value;
				}
				if(values.size() < 3) {
					accepted = false;
				}
				if(accepted)
					System.out.println("Accepted");
				else
					System.out.println("Rejected");
			}
			
		}
	}
}