package Medium;

class ReverseString {

	// 方法一：使用build in function
	public String ReverseString1(String str) {
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}

	
	// 方法二：two pointer
	public String ReverseString2(String str) {
		char arr[] = str.toCharArray();
		int left = 0;
		int right = str.length() - 1;
		
		while (left < right) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		
		return new String(arr);
	}
	
	
	
	public static void main(String[] args) {
		ReverseString caozuo = new ReverseString();
		System.out.println(caozuo.ReverseString1("AbcdefgH"));
		System.out.println(caozuo.ReverseString2("AbcdefgH"));
	}

}
