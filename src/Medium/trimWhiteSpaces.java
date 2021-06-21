package Medium;

public class trimWhiteSpaces {

	public String trimSpaces(char[] charArray, int length) {
		int i = 0, j = 0;

		while (j < length) {
			while (j < length && charArray[j] == ' ') { // 跳过开头的spaces
				j++;
			}

			while (j < length && charArray[j] != ' ') { // 跳过开头的空格后，保留有字母的地方
				charArray[i] = charArray[j];
				i++;
				j++;
			}

			while (j < length && charArray[j] == ' ') { // 遇到单词间的多个空格，j保持往右，i停留在前一个单词的结尾
				j++;
			}

			if (j < length) {
				charArray[i] = ' '; // keep only one space
				i++;
			}
		}

		// while过后此时的i就是最右的非空格的位置的右边一位
		return new String(charArray).substring(0, i);
	}

	public static void main(String[] args) {
		// System.out.println("Hello World!");
		String s = "   nibohui   is   really  awesome ";
		String res = "";
		String cur = "";

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				if (cur.equals("")) {
					continue;
				} else {
					res += cur + " ";
					cur = "";
				}
			} else {
				cur += c;
			}
		}

		if (cur != "") {
			res += cur;
		}

		if (res.charAt(res.length() - 1) == ' ') {
			res = res.substring(0, res.length() - 1);
		}

		System.out.println("---" + res + "---");
	}
}