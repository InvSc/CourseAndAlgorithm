import jdk.nashorn.internal.runtime.regexp.joni.Matcher;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import javax.activation.FileDataSource;
import javax.sound.midi.Soundbank;
import java.awt.geom.Area;
import java.util.*;
import java.util.function.BiConsumer;

public class Kuaishou {
	private static int[][] area;
	private static int count = 0, m, n;
	public static void main(String[] args) {
		method1();
		return;
	}

	private static void method4() {
		Scanner in = new Scanner(System.in);
		m = in.nextInt();
		n = in.nextInt();
		area = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				area[i][j] = in.nextInt();
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(i, j);
			}
		}
		System.out.println(count);
		return;
	}

	public static void dfs(int i, int j) {
		// 不在边界且==1
		if (i >= 1 && i < m - 1 && j >= 1 && j < n - 1 && area[i][j] == 1 ) {
			// 四面为0
			if (area[i + 1][j] == 0 && area[i - 1][j] == 0 && area[i][j + 1] == 0 && area[i][j - 1] == 0) {
				count++;
				area[i][j] = 0;
        		System.out.println(i + "\t" + j);
				return;
			}
			area[i][j] = 0;
			dfs(i + 1, j);
			dfs(i - 1, j);
			dfs(i, j + 1);
			dfs(i, j - 1);
		}
		return;
	}

	private static void method1() {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		Map<String, Set<String>> data = new HashMap<>();
		Set<String> heads = new HashSet<>();
		while (k > 0) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
			k--;
			String currString = in.nextLine();
//      		System.out.println(currString);
			String[] split = currString.split("/");
			String head = "";
			if (split.length >= 3) {
				head += split[0] + "//" + split[2];
			}
			heads.add(head);
			String tail = currString.substring(head.length());
			if (data.get(head) == null) {
				data.put(head, new HashSet<String>());
			}
			Set currList = data.get(head);
			currList.add(tail);
			data.put(head, currList);
		}
		List<String> res = new ArrayList<>();
		for (String head1 : heads) {
      		for (String head2 : heads) {
      			if (head1 != head2) {
					Set<String> set1 = data.get(head1);
					int size1 = set1.size();
					Set<String> set2 = data.get(head2);
					int size2 = set2.size();
					set1.addAll(set2);
					if (set1.size() == size1) {
						set2.addAll(set1);
						if (set2.size() == size2) {
							res.add(head1 + " " + head2);
						}
					}
				}
			}
		}
    	if (res.size() == 0) return;
    System.out.println(res.size());
    for (String str : res) {
      System.out.println(str);
	}
		return;
	}
}
