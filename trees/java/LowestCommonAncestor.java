public class LowestCommonAncestor {
  public static void main(String[] args) {

  }
  public static void function(TreeNode root, TreeNode p, TreeNode q){
    if(root == null || root == p || root == q){
      return root;
    }

    TreeNode left = function(root.left, p, q);
    TreeNode right = function(root.right, p, q);

    if(left == null) return right;
    if(right == null) return left;
    return root;

  }
}
