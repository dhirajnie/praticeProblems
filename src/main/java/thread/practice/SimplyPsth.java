package thread.practice;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;

import java.util.Stack;

public class SimplyPsth {
    public String simplifyPath(String path) {
        String dirs[] = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i] .equals(".") || dirs[i].length() == 0) {
                continue;
            }
            if (stack.isEmpty()) {
                if (!dirs[i].equals("..")) {
                    stack.push(dirs[i]);
                }
            } else if (dirs[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(dirs[i]);
            }
        }
        StringBuffer output = new StringBuffer("");
        while (!stack.isEmpty()) {
            output.insert(0, "/"+stack.pop());
        }

        return output.length()>0?output.toString():"/";
    }

    public static void main(String[] args) {
        System.out.println(new SimplyPsth().simplifyPath("/.../a/../b/c/../d/./"));
        System.out.println(new SimplyPsth().simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(new SimplyPsth().simplifyPath("/home//foo/"));
        System.out.println(new SimplyPsth().simplifyPath("/../"));
    }
}
