package Medium;

public class LetterToNumber {

	public int LettersToNumber(String s) {
		int res = 0;

		char[] letter = s.toCharArray();
		int mult = 1;

		for (int i = letter.length - 1; i >= 0; i--) {

			res = (letter[i] - 'A' + 1) * mult + res;
			mult = mult * 26;
		}

		return res;
	}

	public static void main(String[] args) {
		int res = new LetterToNumber().LettersToNumber("B");
		System.out.println(res);
	}

}
