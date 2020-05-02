import com.sun.corba.se.impl.naming.namingutil.CorbalocURL;

import java.lang.management.BufferPoolMXBean;
import java.util.*;
// JD在线笔试题目
public class JD {



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int     T  = in.nextInt();
        int[][] data = new int[T][2];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 2; j++) {
                data[i][j] = in.nextInt();
            }
        }
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
//        for (int[] line : data) {
//            System.out.println(Arrays.toString(line));
//        }
        int end = 0;
        int max = 0;
        int count = 1;
        int before = 0;
        for (int i = 0; i < T; i++) {
            before = data[i][0];
            if (data[i][0] >= end) {
                count = 1;
                end = data[i][1];
            } else if (data[i][0] > before) {
                if (data[i][1] > end) {
                    end = data[i][1];
                }
            } else {
                count++;
                if (data[i][1] > end) {
                    end = data[i][1];
                }
            }
            System.out.println(count);
            max = Math.max(max, count);
        }
        System.out.println(max);
        return;
    }

    private static void JD1() {
        Scanner in = new Scanner(System.in);
        int     T  = in.nextInt();
        System.out.println(T);
        int[][][] data = new int[T][6][2];
        for (int boxIndex = 0; boxIndex < T; boxIndex++) {
            for (int[] pad : data[boxIndex]) {
                for (int i = 0; i < 2; i++) {
                    pad[i] = in.nextInt();
                }
                Arrays.sort(pad);
            }
            Arrays.sort(data[boxIndex], new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }
                    return o1[0] - o2[0];
                }
            });
        }
//        System.out.println("come here");
        for (int[][] box : data) {
            if (Arrays.equals(box[0], box[1]) && Arrays.equals(box[2], box[3]) && Arrays.equals(box[4], box[5])) {
                if (box[0][0] == box[2][0] && box[0][1] == box[4][0]) {
                    System.out.println("POSSIBLE");
                }
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
        return;
    }

    // 参考解法：找到每轮的区间覆盖数，找到最大的覆盖数就是最少需要安排的座位
    private static int JD2GetNumbers(int[][] users) {
        int max = 1;
        for(int i = 0; i < users.length; i++) {
            int ans = 1;
            // 开始的站点
            int start = users[i][0];
            // 结束的站点
            int end = users[i][1];
            for(int j = 0; j < users.length; j++) {
                if(j != i) {
                    // 存在覆盖区间
                    if(!(end <= users[j][0] || start >= users[j][1])) {
                        ans++;
                    }
                }
            }
            max = Math.max(max, ans);
        }
        return max;
    }
}