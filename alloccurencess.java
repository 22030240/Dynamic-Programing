public class alloccurencess {
    public static void allocu(int arr[], int key, int i) {
        if (i == arr.length) {
            return;
        }
        if (arr[i] == key) {
            System.out.println(i + " ");
        }
        allocu(arr, key, i + 1);

    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 4, 5, 6, 2, 7, 3, 2 };
        int key = 2;
        allocu(arr, key, 0);
    }

}
