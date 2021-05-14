package Medium;

public class NumToLetter {
	public String NumberToLetter(int num) {
		StringBuilder sb = new StringBuilder();
		
		while (num > 0) {
			int remainder = num % 26;
			if (remainder == 0) { //如果余数是0
				sb.append("Z");
				num = num - 1;
			} else {             //余数非0
				sb.append((char)(remainder - 1 + 'A'));
			}
			num = num / 26;
		}
		
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new NumToLetter().NumberToLetter(702));
	}
}
