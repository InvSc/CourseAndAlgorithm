import java.util.Scanner;

public class DuXiaoman {
    private static int n, a, b, c;
    int cost = 0;
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    a = in.nextInt();
    b = in.nextInt();
    c = in.nextInt();
    int[] cities = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        cities[i] = in.nextInt();
    }
    System.out.println(getCost(1, cities));
    return;
  }
  public static int getCost(int curr, int[] cities) {
      if (curr == n) return 0;
      return min(getCost(cities[curr], cities) + a, getCost(curr + 1, cities) + c, getCost(curr - 1, cities) + b);
  }
  public static int min(int a, int b, int c) {
      return Math.min(Math.min(a, b), c);
  }
}
