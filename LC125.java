class LC125 {

    public static void main(String[] args) {
        
        //System.out.println("Hellow");
  
        System.out.println(isPalindrome("ab2a"));


    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int last = s.length()-1;
        int len = s.length(), cycle = 0;
        int front = 0;
     
        while(front<last) {
            if(Character.isLetter(s.charAt(front)) != true && Character.isDigit(s.charAt(front)) != true){
                front++;
              //continue;
            } else if (Character.isLetter(s.charAt(last)) != true && Character.isDigit(s.charAt(last)) != true) {
                last--;
                //continue;
            } else if (s.charAt(front) == s.charAt(last)){
                front++;last--;
            } else {
                return false;
            }
            
        }
        return true;
    
    }

}