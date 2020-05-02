import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {
    public String reverseWords(String s) {
        s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }
    public static void main(String[] args){
        new Main().reverseWords("the sky    is    blue");
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
}