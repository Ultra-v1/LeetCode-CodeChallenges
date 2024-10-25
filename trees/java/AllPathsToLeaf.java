import java.nio.file.Path;
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

public class AllPathsToLeaf {
  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(4);
    function(ans, root, new ArrayList<>());
    for(ArrayList<Integer> it : ans){
      System.out.println(it.toString());
    }
  }
  public static void function(ArrayList<ArrayList<Integer>> ans,
      TreeNode root, ArrayList<Integer> path){
    if(root == null) return;

    path.add(root.val);

    if(root.left == null && root.right == null){
      ans.add(new ArrayList<>(path));
    }
    else{
      function(ans, root.left, path);
      function(ans, root.right, path);
    }
    path.remove(path.size() - 1);
  }
}
