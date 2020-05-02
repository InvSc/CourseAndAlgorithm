// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.text.DecimalFormat;
import java.util.*;

public class Tencent {
	public static void main(String[] args) {
		wzy1();
		return;
	}

	private static void method4() {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		while (T >= 0) {
//			System.out.println("size" + queue.size());
			T--;
			String str = in.nextLine();
			if (str.length() >= 2) {
				if (str.charAt(1) == 'd') {
					String[] s = str.split(" ");
					if (s.length >= 2) {
						int num = Integer.parseInt(s[1]);
						queue.offer(num);
					}
				} else if (str.charAt(1) == 'o') {
          			queue.poll();
				} else if (str.charAt(1) == 'e') {
          			System.out.println(queue.peek());
				}
			}
		}
		return;
	}

	private static void method2() {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T > 0) {
			T--;
			int n = in.nextInt();
			int[][] A = new int[n][2];
			int[][] B = new int[n][2];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 2; j++) {
					A[i][j] = in.nextInt();
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 2; j++) {
					B[i][j] = in.nextInt();
				}
			}
			int min = Integer.MAX_VALUE;
			// A[i] B[j]
 			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int dis = (A[i][0] - B[j][0]) * (A[i][0] - B[j][0])
						+ (A[i][1] - B[j][1]) * (A[i][1] - B[j][1]);
					min = Math.min(min, dis);
				}
			}
 			double res = Math.sqrt(min);
//			DecimalFormat df = new DecimalFormat();
			System.out.printf(String.format("%.3f", res));
		}
		return;
	}

	private static void method1() {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
//    	System.out.println(T);
		for (int i = 0; i < T; i++) {
			int Q = in.nextInt();
//      		System.out.println(Q);
			Queue<Integer> queue = new LinkedList<>();
			String tmp = in.nextLine();
			for (int i1 = 0; i1 < Q; i1++) {
//        		System.out.println(i1);
				String str = in.nextLine();
				if (str.length() >= 2) {
					// PUSH
					if (str.charAt(1) == 'U') {
						String[] s = str.split(" ");
						if (s.length >= 2) {
							int num = Integer.parseInt(s[1]);
//							System.out.println("PUSH" + num);
							queue.offer(num);
						}
					// TOP
					} else if (str.charAt(0) == 'T') {
//						System.out.println("TOP");
//            			System.out.println(queue.size());
						if (queue.size() == 0) {
							System.out.println(-1);
						} else {
							System.out.println(queue.peek());
						}
					// POP
					} else if (str.charAt(0) == 'P') {
//						System.out.println("POP");
//						System.out.println(queue.size());
						if (queue.size() == 0) {
							System.out.println(-1);
						} else {
							queue.poll();
						}
					// SIZE
					} else if (str.charAt(0) == 'S') {
//						System.out.println("SIZE");
						System.out.println(queue.size());
					// CLEAR
					} else if (str.charAt(0) == 'C') {
//						System.out.println("CLEAR");
						queue.clear();
					}
				}
			}
		}
		return;
	}
	public static void wzy1() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int q = input.nextInt();
			for (int j = 0; j < q; j++) {
				String op = input.next();
				if (op.contains("PU")) {
//                    queue.add(Integer.parseInt(op.substring(op.lastIndexOf(" ") + 1)));
					queue.add(input.nextInt());
				} else if (op.contains("PO")) {
					if (queue.peek() == null) result.add(-1);
					else queue.poll();
				} else if (op.contains("TO")) {
					if (queue.peek() == null) result.add(-1);
					else result.add(queue.peek());
				} else if (op.contains("SI")) {
					result.add(queue.size());
				}else if (op.contains("CL")) {
					queue.clear();
				}
			}
		}
		input.close();

		for (int i : result) {
			System.out.println(i);
		}

	}
}