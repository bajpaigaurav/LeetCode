import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class UniqueCharactersSubstring {

// using sliding window - with hashmap

final static Scanner input = new Scanner(System.in);
public static void main(final String[] args) {
      
    String s = input.nextLine();
    Map<Character,Integer> window = new HashMap<Character,Integer>();
    int maxLength = 0;
    int windowStart = 0;
  
    for( int i = 0; i < s.length() ; i++) {


       if(window.containsKey(s.charAt(i))) {
           
           if (windowStart <= window.get(s.charAt(i)) ) {
            windowStart = window.get(s.charAt(i)) + 1;
           }
           
        }

        window.put(s.charAt(i), i); 

        maxLength = Math.max(maxLength, i - windowStart + 1);
    //     System.out.println(window.toString());
    // System.out.println(maxLength);
    }
    // System.out.println(window.toString());
    System.out.println(maxLength);
}



}