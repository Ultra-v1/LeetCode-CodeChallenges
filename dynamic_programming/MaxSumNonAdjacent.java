import java.util.*;

public class MaxSumNonAdjacent {
  public static void main(String[] args) {
    int arr[]  = {1, 2, 4};
    System.out.println(junior(arr, 0));
    int[] dp = new int[arr.length+1];
    Arrays.fill(dp, -1);
    System.out.println(senior(arr, 0, dp));
  }
  public static int junior(int[] arr, int index){
    if(index >= arr.length){
      return 0;
    }
    int take = arr[index] + junior(arr, index+2);
    int notTake = junior(arr, index+1);

    return Math.max(take,   notTake);
  }
  public static int senior(int[] arr, int index, int[] dp){
    if(index >= arr.length) return 0;
    if(dp[index]!= -1) return dp[index];
    int take = arr[index] + senior(arr, index+2, dp);
    int notTake = senior(arr, index+1, dp);
    dp[index] = Math.max(notTake, take);
    return dp[index];
  }
}
