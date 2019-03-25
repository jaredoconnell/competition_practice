import java.util.Scanner;

public class Places {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			// Strings aren't the most efficient way, but it is the easiest way
			String num1 = scan.next();
			String num2 = scan.next();
			
			if(num1.equals("-1") || num2.equals("-1"))
				return;
			
			// Iterate through the characters in num2 starting at
			// different index to see if they are in the same
			boolean positional = false;
			
			if(num1.length() == num2.length()) {
				int len = num1.length();
				
				for(int i = 0; i < len && !positional; i++) {
					boolean mismatch = false;
					for(int j = 0; j < len && !mismatch; j++) {
						int firstIndex = j;
						int secondIndex = (i + j) % len;
						if(num1.charAt(firstIndex) != num2.charAt(secondIndex)) {
							mismatch = true;
						}
					}

					if(!mismatch)
						positional = true;
				}
				
			}
			
			if(positional)
				System.out.println("They are positional");
			else
				System.out.println("They are not positional");
			
		}
	}
}