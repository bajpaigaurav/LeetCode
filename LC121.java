import java.util.Arrays;

class Solution {
    // public int maxProfit(int[] prices) {
    //     int profit;

    //     return profit;
    // }

    public static void main(String[] args) {
        char[] str = {'a','b','c'};
        reverString(str, 0);
        System.out.println(Arrays.toString(str));
    }

    public static void reverString( char[] str, int index) {
        if(str == null || index >= str.length) {
            return;
        }
        reverString(str, index+1);
        char temp;
       temp = str[index];
       str[index] = str[str.length - index - 1];
       str[str.length - index - 1] = temp;
    }
}