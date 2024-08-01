import java.util.*;

class DictonaryNode {
    DictonaryNode[] indexList = new DictonaryNode[26];
    char data;
    boolean endOfWord;

    @Override
    public String toString() {
        return "DictonaryNode{" +
                "indexList=" + Arrays.toString(indexList) +
                ", data=" + data +
                ", endOfWord=" + endOfWord +
                '}';
    }
}

public class StreamChecker {
    DictonaryNode root = new DictonaryNode();
    StringBuffer stream = new StringBuffer();
    DictonaryNode curr;
    Map<String, DictonaryNode> travesedMap = new HashMap<>();

    public StreamChecker(String[] words) {
        DictonaryNode currentNode = root;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                int charPosition = word.charAt(i) - 'a';
                if (currentNode.indexList[charPosition] != null) {
                    currentNode = currentNode.indexList[charPosition];
                } else {
                    DictonaryNode childNode = new DictonaryNode();
                    childNode.data=word.charAt(i);
                    currentNode.indexList[charPosition] = childNode;
                    currentNode = childNode;
                }
            }
            currentNode.endOfWord = true;
            currentNode = root;
        }
        this.curr = this.root;
    }

    public boolean query(char letter) {
        int charPosition = letter - 'a';
        this.stream.append(letter);
        if (curr.indexList[charPosition] != null) {
            curr = curr.indexList[charPosition];
        } else {
            // current string is not same , sliding window algo
            while (this.stream.length() > 0) {
                this.stream.delete(0, 1);
//                System.out.println("> " + this.stream);
                if (travesedMap.containsKey(this.stream.toString())) {
                    curr = travesedMap.get(this.stream.toString());
                }
            }
        }
        travesedMap.put(this.stream.toString(), curr.indexList[charPosition]);
//        for (int i = 0; i < this.stream.length(); i++) {
//            int charPosition = this.stream.charAt(i) - 'a';
//            if (curr.indexList[charPosition] != null) {
//                curr = curr.indexList[charPosition];
//            } else {
//                return false;
//            }
//        }
        if (curr != null && curr.endOfWord) return true;
        return false;
    }

    public static void main(String[] args) {

        String[] myArray = {"ab", "ba", "aaab", "abab", "baa","de"};
        StreamChecker streamChecker = new StreamChecker(myArray);
        System.out.println(streamChecker.root);
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('d'));
        System.out.println(streamChecker.query('e'));

    }
/*
map


 */

}
