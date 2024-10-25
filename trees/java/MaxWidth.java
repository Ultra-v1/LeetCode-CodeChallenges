import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

class Pair{
  int first, last;
  TreeNode node;
  public Pair(int first, int last, TreeNode node){
    this.first = first;
    this.last = last;
    this.node = node;
  }
}
class Pair {

  int index;
  TreeNode node;
  public Pair(int index, TreeNode node){
    this.index= index;
    this.node = node;
  }

}
public class MaxWidth {
  public static void main(String[] args) {

  }
  public static int function(TreeNode root){
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(0, root));

    int answer = 0;
    int start = 0;
    int last = 0;
    while (!q.isEmpty()) {
      int minimum_index_of_two_nodes = q.peek().index;

      int size = q.size();
      for (int i = 0; i < size; i++) {
         int curr_index = q.peek().index - minimum_index_of_two_nodes;

         if(i == 0) start = curr_index;
         if(i == q.size() - 1) last = curr_index;

         TreeNode node = q.peek().node;
         q.poll();
         if(node.left != null) q.offer(new Pair(curr_index * 2+ 1), node.left);
         if(node.right != null) q.offer(new Pair(curr_index * 2 + 2, node.right));
      }
      ans = Math.max(ans, last - start + 1);
    }
    return ans;
  }
}
