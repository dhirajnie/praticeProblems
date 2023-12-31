package arrayRotation;

import java.util.LinkedList;
import java.util.Queue;

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

class Solution {
  static   public boolean isCompleteTree(TreeNode root) {
      Queue<TreeNode> q = new LinkedList<>();
      if(root==null){
          return true;

      }
      else {
          q.add(root);
          while (!q.isEmpty()){
              
          }
      }
    }

    public static void main(String[] args) {
      TreeNode treeNode= new TreeNode(89);

        isCompleteTree(treeNode;
    }
}