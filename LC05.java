import java.util.Scanner;

class Lc5 {

    private static final Scanner scanner = new Scanner(System.in);
    static int startOfPalindrome = 0;
    static int maxLengthPalindrome = 1; // for single character
    static String s;

    public static void main(String[] args) {

        s = scanner.nextLine();

        for (int i = 0; i < s.length(); i++) {
            checkPalindrome(i - 1, i+1);
            checkPalindrome(i, i + 1);
        }
        
        System.out.println(maxLengthPalindrome +" " +s.substring(startOfPalindrome, startOfPalindrome+maxLengthPalindrome));
    }

    public static void checkPalindrome(int left, int right) {
        int currentPalLength = 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

            currentPalLength = right - left + 1;
            if (currentPalLength > maxLengthPalindrome) {
                maxLengthPalindrome = currentPalLength;
                startOfPalindrome = left;
            }
            left -= 1;
            right += 1;
        }
        
    }
}