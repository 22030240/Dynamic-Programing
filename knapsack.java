import java.util.*;

public class knapsack {
    public static int recursion(int val[], int wt[], int w, int n) {
        if (w == 0 || n == 0) {
            return 0;
        }
        int m = 0;
        if (wt[n - 1] <= w) {
            // include
            int ans1 = val[n - 1] + recursion(val, wt, w - wt[n - 1], n - 1);
            // exclude

            int ans2 = recursion(val, wt, w, n - 1);

            m = Math.max(m, Math.max(ans1, ans2));
        } else {
            recursion(val, wt, w, n - 1);
        }
        return m;
    }

    public static int dynamic2(int val[], int wt[], int w, int n) {
        int dp[][] = new int[n + 1][w + 1];
        for (int i = 0; i < dp.length + 1; i++) {
            for (int j = 0; j < dp[0].length + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (wt[i - 1] <= w) {
                    // include
                    dp[i][j] = Math.max((val[i - 1] + dp[i - 1][j - wt[i - 1]]), dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }

    public static int dynamic1(int val[], int wt[], int w, int n, int dp[][]) {
        if (n == 0 || w == 0) {
            return 0;
        }
        if (dp[n][w] != -1) {
            return dp[n][w];
        }
        if (wt[n - 1] <= w) {
            // include
            int ans1 = val[n - 1] + dynamic1(val, wt, w - wt[n - 1], n - 1, dp);

            // exclude
            int ans2 = dynamic1(val, wt, w, n - 1, dp);
            dp[n][w] = Math.max(ans1, ans2);

        } else {
            dynamic1(val, wt, w, n - 1, dp);
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int w = 7;
        System.out.println(dynamic2(val, wt, w, val.length));
        int dp[][] = new int[wt.length + 1][w + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(dynamic1(val, wt, w, val.length, dp));
    }

}
