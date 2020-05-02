import java.util.*;
import java.util.regex.Pattern;


public class Main {
    public String reverseWords(String s) {
        s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }

    private static void calcuDis() {
        Scanner in = new Scanner(System.in);
        int     n  = in.nextInt();
        int sum = 0;
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
          x[i] = in.nextInt();
          sum += x[i];
          int tmp = in.nextInt();
        }
        double ave = (double) sum / (double) n;
        double dis = 0;
        for (int i = 0; i < n; i++) {
          dis += Math.abs(x[i] - ave);
        }
        System.out.println((int) dis);
        return;
    }

    public void func(int N, int L) {
        for (int i = L; i <= 100; i++) {
            double a = (double) (2 * N - i * i + i) / (double) (2 * i);
            if (a >= 0 && (int) a == a) {
                int b = (int) a;
//                System.out.println(a + " " + b + " " + i);
                for (int j = 0; j < i - 1; j++) {
                    System.out.print((b + j) + " ");
                }
                System.out.println((b + i - 1));
                return;
            }
        }
        System.out.println("No");
        return;
    }

    public static class pair {
        int num1;
        int num2;
        public pair(int x, int y) {
            this.num1 = x;
            this.num2 = y;
        }
    }
    public static void main(String args[])
    {
        meituan2();
        return;
    }

    private static void meituan4() {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = cin.nextInt();
        }
//    System.out.println("输入完成");
        int index = -1;
        int target = (n + 1) / 2;
        for (int i = 0; i < n; i++) {
            if (i <= target && nums[i] == k) {
                index = i;
            }
        }
        System.out.println(index);
        System.out.println(target);
        for (int i = 0; i < n; i++) {
            System.out.println("进入循环");
            int t = (n + 1 + i) / 2;
            int s = i + index;
            System.out.println(i + " " + s + " " + t);
            if (s == t) {
                System.out.println(i);
            }
        }
        return;
    }

    private static void meituan3() {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        List<pair> pairs = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = cin.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pair pair = new pair(nums[i], nums[j]);
                boolean add = pairs.add(pair);
            }
        }
        Collections.sort(pairs, new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                if (o1.num1 == o2.num1) {
                    return o1.num2 - o2.num2;
                }
                return o1.num1 - o2.num1;
            }
        });
        for (int i = 0; i < pairs.size(); i++) {
          System.out.print("(" + pairs.get(i).num1 + "," + pairs.get(i).num2 + ")");
        }

        System.out.println("(" + pairs.get(k - 1).num1 + "," + pairs.get(k - 1).num2 + ")");
        return;
    }

    private static void meituan2() {
        Scanner cin = new Scanner(System.in);
        int a = cin.nextInt();
        int b = cin.nextInt();
        int m = cin.nextInt();
        int x = cin.nextInt();
        int[] arr = new int[100000];
        int idx = 0;
        int ans = 0;
        while (true) {
            x = (a * x + b) % m;
//            if (list.contains(x)) {
//                System.out.println(list.size());
//                return;
//            }
            if (vali(arr, idx)) {
                ans = idx / 2;
                System.out.println(ans);
                return;
            }
            arr[idx++] = x;
        }

    }

    public static boolean vali(int[] arr, int idx) {
        int len = idx / 2;
        int i = 0, j = len;
        while (i < len) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    private static void meituan1() {
        Scanner cin = new Scanner(System.in);
        // n个学生
        int n = cin.nextInt();
        // m科目
        int m = cin.nextInt();
        int[][] grade = new int[n][m];


        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            grade[i][j] = cin.nextInt();
          }
        }
        Set<Integer> res = new HashSet<>();
        for (int j = 0; j < m; j++) {
            int top = -1;
            int topStu = -1;
            for (int i = 0; i < n; i++) {
                if (grade[i][j] > top) {
                    top = grade[i][j];
                    topStu = i;
                }
            }
            res.add(topStu);
            for (int i = 0; i < n; i++) {
                if (grade[i][j] == top) {
                    res.add(i);
                }
            }
        }
        System.out.println(res.size());
        return ;
    }

}