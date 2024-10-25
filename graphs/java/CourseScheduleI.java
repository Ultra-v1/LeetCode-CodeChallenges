import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleI {
  public static void main(String[] args) {

  }
  public static boolean isValid(int N, int[][] arr){
    // create a directed graph
    // do a topological sorting of the graph
    // check if all nodes exist there
    // if yes -> return true
    // else -> false
    List<Integer>[] adj = new int[N+1][N+1];
    for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();
    for(int i = 0  ; i < arr.length; i++){
      int u = arr[i][0];
      int v = arr[i][1];

      adj[v].add(u);
    }

    int[] topologicalArray = topo(int N, int[][] adj);
    if(topologicalArray.length < N) return false;
    return true;
  }
  public static int[] topo(int N, int[][] adj){
    int[] inDegree = new int[N+1];

    for(int i = 0 ; i < V; i++){
      for(int j : adj[i]){
        inDegree[j]++;
      }
    }

    int[] ans = new int[V];
    int index = 0;

    Queue<Integer> q = new LinkedList<>();

    for(int i = 0 ; i < V; i++){
      if(inDegree[i] == 0){
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int polled = q.poll();

      ans[index++] = polled;

      inDegree[polled]--;

      for(int neighbor : adj[node]){
        inDegree[neighbor]--;

        if(inDegree[neighbor] == 0) q.add(neighbor);
      }
    }
    return Arrays.copyOfRange(ans, 0, idx);
  }
}
