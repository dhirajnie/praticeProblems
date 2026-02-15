package Tree;

import com.practice.utils.Tree;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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


    public boolean checkSymetic (TreeNode left, TreeNode right) {

        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val) {
            return false;
        }
        return checkSymetic(left.left, right.right) && checkSymetic(left.right, right.left);

    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return checkSymetic(root.left,root.right);
    }




    public static void main(String[] args) throws NoSuchAlgorithmException {
    String url ="abc.example.com";
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(url.getBytes(StandardCharsets.UTF_8));

// Take first 8 bytes (64 bits)
        long value = ByteBuffer.wrap(hash).getLong();
        System.out.println(value);

        // String → bytes (encoding)
        byte[] bytes = "abc".getBytes(StandardCharsets.UTF_8);

// bytes → String (decoding)
        String text = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(text);



// Convert to Base62
//        String shortCode = Base62.encode(Math.abs(value));
    }
}
