import java.util.Arrays;
import java.util.Scanner;

public class Pdd {
	public static void main(String[] args) {
		Pdd2();
		return;
	}

	private static void Pdd4() {
		Scanner in   = new Scanner(System.in);
		int     N    = in.nextInt();
		int[]   data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = in.nextInt();
		}
		in.close();
		int max = -1;
		for (int i = 0; i < N; i++) {
			int gcdVal = data[i];
			int num = 0;
			for (int j = i; j < N; j++) {
				gcdVal = gcd(gcdVal, data[j]);
				num++;
//				System.out.println(gcdVal + " " + num);
				max = Math.max(gcdVal * num, max);
			}
		}
		System.out.println(max);
		return;
	}

	private static int gcd(int a, int b) {
		if (a == 0) return b;
		if (b == 0) return a;
		if (a > b) {
			a = a % b;
		} else {
			b = b % a;
		}
		return gcd(a, b);
	}

	private static void Pdd3() {
		// @Status:AC
		Scanner   in  = new Scanner(System.in);
		int       T   = in.nextInt();
		boolean[] res = new boolean[T];
		for (int i = 0; i < T; i++) {
			int[] arr = new int[4];
			arr[0] = in.nextInt();
			arr[1] = in.nextInt();
			int n = in.nextInt();
			arr[2] = arr[0] + arr[1];
			arr[3] = arr[1] + arr[2];
			res[i] = arr[n % 4] % 3 == 0;
		}
		in.close();
		for (boolean re : res) {
			if (re) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		return;
	}

	private static void Pdd2() {
		Scanner in = new Scanner(System.in);
		int     N  = in.nextInt();
		boolean[] res = new boolean[N];
		for (int i = 0; i < N; i++) {
			int T = in.nextInt();
			int[] len = new int[T];
			int sum = 0;
			for (int j = 0; j < T; j++) {
				len[j] = in.nextInt();
				sum += len[j];
			}
			if ((sum % 4) != 0) {
				res[i] = false;
				continue;
			}
			int edge = sum / 4;
			for (int j = 0; j < T; j++) {
				len[j] = len[j] % 4;
			}
			Arrays.sort(len);

		}
		in.close();
		for (boolean re : res) {
			if (re) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		return;
	}

	private static void Pdd1() {
		// 超时 55% 再次测试没有超时
		Scanner in  = new Scanner(System.in);
		int     N   = in.nextInt();
		int[]   num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = in.nextInt();
		}
		in.close();
		if (N == 1) {
			System.out.println(0);
			return;
		}
		Arrays.sort(num);
		int add = 0;
		for (int i = 1; i < N; i++) {
			if (num[i] <= num[i - 1]) {
				int cur = num[i - 1] - num[i] + 1;
				num[i] += cur;
				add += cur;
			}
		}
		System.out.println(add);
		return;
	}
}
