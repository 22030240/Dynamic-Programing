public class Friendspair {
    public static int frien(int n) {
        // base
        if (n == 1 || n == 2) {
            return n;
        }
        int totalways = 0;
        // pair
        int fnm1 = frien(n - 1);
        int fnm2 = frien(n - 2);
        int pairsum = (n - 1) * fnm2;

        return fnm1 + pairsum;
    }

    public static void main(String[] args) {
        System.out.println("pair of friend-->" + frien(4));
    }
}