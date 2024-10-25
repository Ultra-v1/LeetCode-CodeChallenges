class HouseRobber {
    public static void main(String[] args) {

    }
    public int houseRobber(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }
    public int robRange(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return fn(nums, start, dp, end);
    }
    public static int fn(int[] nums, int index, int[] dp, int end) {
        if (index == end) return nums[end];
        if (index > end) return 0;

        if (dp[index] != -1) return dp[index];

        int robCurrent = nums[index] + fn(nums, index + 2, dp, end);
        int skipCurrent = fn(nums, index + 1, dp, end);

        dp[index] = Math.max(robCurrent, skipCurrent);
        return dp[index];
    }
}

