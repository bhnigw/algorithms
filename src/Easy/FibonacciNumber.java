package Easy;

public class FibonacciNumber {

	public static int Fibonacci1(int n) {
		if (n <= 1) {
			return n;
		}

		return Fibonacci1(n - 1) + Fibonacci1(n - 2);
	}

	public static int Fibonacci2(int n) {
		int dp[] = new int[n + 1]; // 需要1个额外的空间来处理n = 0的情况

		dp[0] = 0; // 初始前两位数
		dp[1] = 1;

		for (int i = 2; i <= n; i++) { // 初始值是2
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}

	public static int Fibonacci3(int n) {
		int num1 = 0, num2 = 1; // 初始前两位数
		int sum = 0;

		if (n == 0) {
			return num1;
		}

		for (int i = 2; i <= n; i++) {
			sum = num1 + num2;
			num1 = num2;
			num2 = sum;
		}

		return sum;
	}

	public static void main(String args[]) {
		int N = 10;

		System.out.println(Fibonacci1(N));
		System.out.println(Fibonacci2(N));
		System.out.println(Fibonacci3(N));
	}

}
