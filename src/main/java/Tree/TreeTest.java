package Tree;

import com.practice.utils.Tree;

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


public class TreeTest {


    public boolean checkSymetic (TreeNode left, TreeNode right){

        if(left==null && right==null)
            return true;
        if(left==null || right ==null)
            return false;
        if(left.val!=right.val){
            return false;
        }
        return checkSymetic(left.left,right.right) && checkSymetic(left.right,right.left);

    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return checkSymetic(root.left,root.right);
    }




    public static void main(String[] args) {

    }
}
