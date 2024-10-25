public class GeekJump {
    public static void main(String[] args) {
        int[] height = {10, 20, 30, 10};
        System.out.println(recursion(0, height));
    }

    public static int recursion(int i, int[] arr) {
        if (i == arr.length - 1) {
            return 0;
        }
        if (i >= arr.length) {
            return Integer.MAX_VALUE;
        }

        int oneStep = Math.abs(arr[i] - arr[i + 1]) + recursion(i + 1, arr);

        int twoStep = Integer.MAX_VALUE;
        if (i + 2 < arr.length) {
            twoStep = Math.abs(arr[i] - arr[i + 2]) + recursion(i + 2, arr);
        }

        return Math.min(oneStep, twoStep);
    }
}

