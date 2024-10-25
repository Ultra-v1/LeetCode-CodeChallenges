public class ClimbingI{
  public static void main(String[] a) {
    int n = 3;
    System.out.println(climb(n));
  }
  public static int climb(int n){
    if(n <= 2) return n;

    return climb(n-1) + climb(n-2);
  }
  public int climb_dp(int n) {
        if(n==0 || n==1) return 1;

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i = 2 ; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
  }
}
