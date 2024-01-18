public class fibonaciseriesusingdynamicp {
    public static int dynamic(int n, int f[]) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (f[n] != 0) {
            return f[n];
        }
        f[n] = dynamic(n - 1, f) + dynamic(n - 2, f);
        return f[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int f[] = new int[n + 1];
        System.out.println("fibnaci element at idx->" + dynamic(n, f));
    }

}
