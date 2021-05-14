package Medium;

class ReverseString {
	public void ReverseString1(String s) {
		String input = "apple";

		// convert String to character array
		// by using toCharArray
		char[] try1 = input.toCharArray();

		for (int i = try1.length - 1; i >= 0; i--)
			System.out.print(try1[i]);
	}

	
	public String ReverseString2(String s) {
		String input = "Geeks for Geeks";

		StringBuilder input1 = new StringBuilder();

		// append a string into StringBuilder input1
		input1.append(input);

		// reverse StringBuilder input1
		return input1.reverse().toString();

	}
	
	public static void main(String[] args) {
		
	}

}
