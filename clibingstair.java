public class clibingstair {
    public static int countways(int n, int f[]) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (f[n] != 0) {
            return f[n];
        }
        f[n] = countways(n - 1, f) + countways(n - 2, f);
        return f[n];
    }

    public static void climbing(int n) {
        int f[] = new int[n + 1];
        f[0] = 1;

        for (int i = 1; i < n + 1; i++) {
            if (i == 1) {
                f[i] = f[i - 1];
            } else {
                f[i] = f[i - 1] + f[i - 2];
            }

        }
        System.out.println(f[n]);
    }

    public static void main(String[] args) {
        int n = 8;
        int f[] = new int[n + 1];
        System.out.println("ways to up destination->>>" + countways(n, f));
        climbing(n);
    }

}
