import java.util.Arrays;

public class Fibonacci{
  public static void main(String[] args) {
    int n = 5;
    int[] dp = new int[n+1];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    dp[1] = 1;
    // 0 1 1 2 3 5
    System.out.println(fib_recursion(n));
    System.out.println(fib_dynamic_programming(n, dp));
    System.out.println(fib_tabulation(n));
  }
  public static int fib_recursion(int n){
    if(n == 0 || n == 1) return n;

    return fib_recursion(n-1) + fib_recursion(n -2);
  }
  public static int fib_dynamic_programming(int n, int[] dp){
    if(n == 0 || n == 1) return n;

    if(dp[n] != -1) return dp[n];

    dp[n] = fib_dynamic_programming(n-1, dp) + fib_dynamic_programming(n-2, dp);
    return dp[n];
  }
  public static int fib_tabulation(int n){
    int[] dp = new int[n+1];

    dp[0] = 0;
    dp[1] = 1 ;

    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
  }
}
