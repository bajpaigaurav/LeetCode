class LC125 {


    public static void main(String[] args) {
        
        //System.out.println("Hellow");
  
        System.out.println(isPalindrome("abaaab"));


    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int last = s.length()-1;
        int front = 0;
        int skipped = 0;
        while(front<last) {
            
            if (s.charAt(front) == s.charAt(last)) {
                front++;last--;
            } else if(s.charAt(front) != s.charAt(last) && skipped == 0){
                if(s.charAt(front+1) == s.charAt(last)) {
                    front++; skipped = 1;
                } else {
                    last--; skipped =1;
                }
                
            } else {
                return false;
            }
            
        }
        return true;
    
    }

}