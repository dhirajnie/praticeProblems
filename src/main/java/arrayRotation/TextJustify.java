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

      List<String> result = new ArrayList<>();

      for(List<String> line : lines) {
          long  gap = maxWidth - line.stream().mapToLong(String::length).sum();
          int uniformGap = line.size() > 1 ? (int)(gap / (line.size()-1)): (int) gap;

          StringBuilder currentJustLine = new StringBuilder();
          for(String word:line){
              int fillSpace = Math.min((int)gap,uniformGap);
              currentJustLine.append( fill(word,fillSpace));
              gap -= uniformGap ;
          }
          result.add(currentJustLine.toString());
          System.out.println(currentJustLine);
      }
        return result;
    }
    static String fill(String word,int spaceSize ){
      StringBuilder spaces = new StringBuilder();
      while (spaceSize>0){
          spaces.append(" ");
          --spaceSize;
      }
      return word+spaces.toString();
    }


    public static void main(String[] args) {
      String inp[]= new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        System.out.println(fullJustify(inp,20));
    }
}
