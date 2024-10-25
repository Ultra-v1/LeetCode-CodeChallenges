import java.lang.reflect.Array;
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


public class RightView {
  public static void main(String[] args) {
    TreeNode x = new TreeNode(1);
    x.left = new TreeNode(2);
    x.right = new TreeNode(3)
;
    x.left.right = new TreeNode(5);
    x.left.right.left = new TreeNode(6);
    x.right.right = new TreeNode(7);
    ArrayList<Integer> map = new ArrayList<>();
    function(x, 0, map);
    System.out.println(map.toString());
  }
  public static void function(TreeNode root, int level, ArrayList<Integer> ans){
    if(root != null){
      // implement reverse pre order traversal
      // Right, Left, Root
      if(level == ans.size()){
        ans.add(root.val);
      }
      function(root.right, level+1,  ans);
      function(root.left,level+1,  ans);
      System.out.println(root.val);
    }
  }
}
