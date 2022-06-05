// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            //need All "[", "]",and"(",")", if cannot find correct, stop.
            //1. find "[". if no, stop. Else, continue.
            if(markdown.indexOf("[", currentIndex)==-1){
                break;
            }else{
                int openBracket = markdown.indexOf("[", currentIndex);
                //2. find "](", instead of ] and ( separated. 
                if(markdown.indexOf("](", openBracket)==-1){
                    break;
                }else{
                    int closeBracketOpenParen = markdown.indexOf("](", openBracket);
                    
                    if(markdown.indexOf(")", closeBracketOpenParen)==-1){
                        break;
                    }else{
                        int closeParen = markdown.indexOf(")", closeBracketOpenParen);
                        String subToReturn = markdown.substring(closeBracketOpenParen + 2, closeParen).replace(" ","");
                        if(subToReturn != null){
                            toReturn.add(subToReturn);
                        }
                        
                        currentIndex = closeParen + 1;
                    }
                }
            }
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}



