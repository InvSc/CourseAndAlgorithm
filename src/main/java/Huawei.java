import javafx.scene.shape.Circle;

import java.util.*;

public class Huawei {
	static List<String> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		int len = str.length();
		int k = in.nextInt();
		in.close();
		// 处理
		char[] chArr = str.toCharArray();
 		int lastIndex = -1;
//		for (int i = 0; i <= len - k - 1; i++) {
//			for (int j = lastIndex + 1; j <= i + k; j++) {
//
//			}
//		}
		addStr(chArr, k, "", 0);
    	Comparator<? super String> comparator =
        	new Comparator<String>() {
          		@Override
          		public int compare(String o1, String o2) {
            	int len = Math.min(o1.length(), o2.length());
            	for (int i = 0; i < len; i++) {
            		if (o1.charAt(i) != o2.charAt(i)) {
            			return o1.charAt(i) - o2.charAt(i);
				}
            }
            	return 0;
          	}
        };
		list.sort(comparator);
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		System.out.println(list.get(0));
		return;
	}

	private static void addStr(char[] chars, int k, String curr, int pos){
		if (pos == chars.length || curr.length() == chars.length - k) {
			if (curr.length() == chars.length - k) {
				list.add(curr);
			}
			return;
		} else {
			addStr(chars, k, curr, pos + 1);
			addStr(chars, k, curr + chars[pos], pos + 1);
		}
	}

	private static void ExamOne() {
		Scanner in = new Scanner(System.in);
		String str = "";
		Map<Character, Integer> map = new HashMap<>();
		Set<Character> set = new HashSet<>();
		if (in.hasNextLine()) {
			str = in.nextLine();
		} else {
			in.close();
			System.out.println(0);
			return;
		}
		in.close();
//		if (str.length() == 0) {
//      		System.out.println(0);
//      		return;
//		}
		int ret = 1;
		for (int i = 2; i <= str.length(); i++) {
			ret *= i;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!set.contains(ch)) {
				set.add(ch);
			}
			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
			}
		}
		for (char ch : set) {
			ret /= A(map.get(ch));
		}
		System.out.println(ret);
		return;
	}

	public static int A(int num) {
		int ret = 1;
		for (int i = 2; i <= num; i++) {
			ret *= i;
		}
		return ret;
	}
}
