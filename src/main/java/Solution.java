import java.util.*;

class Solution {
    public int fourKeyBoard(int times) {
        int dp[] = new int[times + 1];
        dp[0] = 0;
        if (times == 0) return dp[0];
        dp[1] = 1;
        if (times == 1) return dp[1];
        dp[2] = 2;
        if (times == 2) return dp[2];
        for (int i = 3; i <= times; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 3; j <= i; j++) {
                dp[i] = Math.max(dp[i - j] * (j - 1), dp[i]);
            }
        }
        return dp[times];
    }

    public int maxA(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            // 按 A 键
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j < i; j++) {
                // 全选 & 复制 dp[j-2]，连续粘贴 i - j 次
                // 屏幕上共 dp[j - 2] * (i - j + 1) 个 A
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        // N 次按键之后最多有几个 A？
        return dp[N];
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        quickSort(intervals, 0, len - 1);
        // for (int[] arr: intervals) {
        //     System.out.println(Arrays.toString(arr));
        // }
        int res = 0;
        int maxEnd = intervals[len - 1][1];
        for (int i = 0; i < len; i++) {
            int end = intervals[i][1];
            for (int j = i + 1; j < len; j++) {
                if (intervals[j][0] < end) {
                    res++;
                    intervals[j][0] = maxEnd;
                }
            }
        }
        return res;
    }


    public void quickSort(int[][] intervals, int start, int end) {
        if (start >= end
                || intervals == null
                || intervals.length <= 1) {
            return;
        }
        int pivot = intervals[(start + end) / 2][1];
        int i = start, j = end;
        while (i <= j) {
            while (intervals[i][1] < pivot) {
                i++;
            }
            while (intervals[j][1] > pivot) {
                j--;
            }
            if (i < j) {
                swap(intervals, i, j);
                i++;
                j--;
            } else if (i == j) {
                i++;
            }
        }
        quickSort(intervals, start, j);
        quickSort(intervals, i, end);
        return;
    }
    public void swap(int[][] intervals, int i, int j) {
        int[] temp = Arrays.copyOf(intervals[i], intervals[i].length);
        intervals[i] = Arrays.copyOf(intervals[j], intervals[j].length);
        intervals[j] = Arrays.copyOf(temp, temp.length);
    }
    public int minimumLengthEncoding(String[] words) {
        // trie为根节点
        TrieNode trie = new TrieNode();
        // 存储每个word节点与对应长度
        Map<TrieNode, Integer> nodes = new HashMap();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j)
                cur = cur.get(word.charAt(j));
            nodes.put(cur, i);
        }

        int ans = 0;
        for (TrieNode node: nodes.keySet()) {
            if (node.count == 0)
                ans += words[nodes.get(node)].length() + 1;
        }
        return ans;
    }


    public class TrieNode {
        TrieNode[] children;
        int        count;

        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }

        public TrieNode get(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
                count++;
            }
            return children[c - 'a'];
        }
    }
    class LRUCache {

        class Node {
            public int key, value;
            Node prev, next;
            public Node(int k, int v) {
                this.key = k;
                this.value = v;
                prev = null;
                next = null;
            }
        }

        class DoubleList {
            // 在链表头部添加节点 x，时间 O(1)
            public void addFirst(Node x) {

            }

            // 删除链表中的 x 节点（x 一定存在）
            // 由于是双链表且给的是目标 Node 节点，时间 O(1)
            public void remove(Node x) {

            }

            // 删除链表中最后一个节点，并返回该节点，时间 O(1)
            public Node removeLast() {
                return null;
            }

            // 返回链表长度，时间 O(1)
            public int size() {

                return 0;
            }
        }

        public LRUCache(int capacity) {

        }

        public int get(int key) {
            return 0;
        }

        public void put(int key, int value) {

        }
    }
    public boolean canJump(int[] nums) {
        return DFS(nums,0);
    }
    private boolean DFS(int[] nums,int i){//i是当前的位置
        System.out.println(i);
        //1.截止条件
        //跳出或碰到0且没有别的选择
        if (i == 2) {
            i = 2;
        }
        if(i>=nums.length-1||i+nums[i]>=nums.length-1)
        {
            return true;
        }
        // if(nums[i]==0)
        // return false;
        //2.循环
        int j=nums[i];
        while(j>0){
            // for(int j=0;j<nums[i];j++){
            //     if(i+j)
            // }
            //  System.out.println(i);
            //  System.out.println(j);
            //  System.out.println(i+j);
            //  System.out.println(nums[i+j]);
            System.out.println(i+j);

            if(nums[i+j]!=0){
                //System.out.println(i+j);
                // if(i+j>=nums.length-1||i+j+nums[i+j]>=nums.length-1)
                // return true;
                return DFS(nums,i+j);
            }
            j--;
        }
        return false;
    }
    public void gameOfLife(int[][] board) {
        int length = board.length;
        int width = board[0].length;
        int[][] boardCopy = new int[length][width];
        for (int i = 0; i < length; i++) {
            boardCopy[i] = board[i].clone();
        }
        int[] rArr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] cArr = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int r = 0; r < length; r++) {
            for (int c = 0; c <= width; c++) {
                int cellCount = 0;
                for (int i = 0; i < 8; i++) {
                    if (r + rArr[i] >= 0 && r + rArr[i] <= length
                            && c + cArr[i] >= 0 && c + cArr[i] <= width
                            && boardCopy[r + rArr[i]][c + cArr[i]] != 0) {
                        cellCount++;
                    }
                }
                if (board[r][c] != 0) {
                    if (cellCount < 2) {
                        board[r][c] = 0;
                    } else if (cellCount > 3) {
                        board[r][c] = 0;
                    }
                } else if (cellCount == 3) {
                    board[r][c] = 1;
                }
            }
        }
        return;
    }
    public class point {
        int x, y;
        public point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public boolean movingCount(int m, int n, int k) {
        int r = 0, c = 0;
        Stack<point> unvisited = new Stack<>();
        unvisited.push(new point(0, 0));
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        int count = 0;
        while (!unvisited.empty()) {
            point curr = unvisited.pop();
            r = curr.x;
            c = curr.y;
            for (int i = 0; i < 2; i++) {
                // 确认(r + dx[i], c + dy[i])不越界，并且push进栈
                if (r + dx[i] >= 0 && r + dx[i] < m && c + dy[i] >= 0 && c + dy[i] < n && judge(r + dx[i], c + dy[i], k)) {
                    unvisited.push(new point(r + dx[i], c + dy[i]));
                }
            }
            count++;

        }
        return false;
    }
    public boolean judge(int i, int j, int k) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        while (j != 0) {
            sum += j % 10;
            i = j / 10;
        }
        return sum <= k;
    }
    public List<String> generateParenthesis(int n) {
        return backtrace("", n, n);
    }
    private List<String> result = new LinkedList<>();
    private List<String> backtrace(String line, int left, int right) {
        if (left > 0) {
            backtrace(line + "(", left - 1, right);
        }
        if (right > left) {
            backtrace(line + ")", left, right - 1);
        }
        if (right <= 0) {
            result.add(line);
        }
        return result;
    }
    // 删除str1中在str2出现过的字符
    public String merge(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        StringBuilder res = new StringBuilder(str1);
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < len2; i++) {
            map.put(str2.charAt(i), true);
        }
        for (int i = len1 - 1; i >= 0; i--) {
            if (map.get(res.charAt(i)) != null) {
                res.deleteCharAt(i);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().merge("fsdafdasf", "fsadfsadf"));
    }
}


