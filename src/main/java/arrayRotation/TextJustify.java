package arrayRotation;

import java.util.*;

public class TextJustify {


  static   public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> lines = new ArrayList<>();
        int currentLineCount =0;
        List<String> currentLine = new ArrayList<>();
        for(String word:words){
             if(currentLineCount==maxWidth || currentLineCount+word.length()+1>maxWidth){
                lines.add(new ArrayList<>(currentLine));
                currentLine.clear();
                currentLineCount = word.length();
                currentLine.add(word);
            }
             else{
                 currentLineCount+=word.length();
                 if(!currentLine.isEmpty()){
                     ++currentLineCount;
                 }
                 currentLine.add(word);

             }


        }
      lines.add(currentLine);

      System.out.println(lines);
        return null;

    }


    public static void main(String[] args) {
      String inp[]= new String[]{"What","must","be","acknowledgment","shall","be","ads12212"};
        System.out.println(fullJustify(inp,16));
    }
}
