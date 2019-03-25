import java.util.*;

public class BaseCalc {
	public static void main(String[] args) {
		boolean running = true;
		Scanner scan = new Scanner(System.in);
		while(running) {
			// Get input
			String firstString = scan.next();
			if(!firstString.equals("-1")) {
				String op = scan.next();
				String secondString = scan.next();
				
				String[] firstComponents = firstString.split("_");
				String[] secondComponents = secondString.split("_");
				
				int base = Integer.parseInt(firstComponents[1]);
				int first = Integer.parseInt(firstComponents[0], base);
				int second = Integer.parseInt(secondComponents[0], base);
				int result;
				
				if(op.equals("+"))
					result = first + second;
				else
					result = first - second;
				
				System.out.println("results = " + Integer.toString(result, base).toUpperCase() + "_" + base);
			} else {
				running = false;
			}
		}
		
	}
}