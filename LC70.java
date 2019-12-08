import java.util.Scanner;

class ClimbingStairs {


    final static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        int n = input.nextInt();
        int [] arr = new int[1000];

        arr[0] = 0;arr[1] = 1;arr[2] = 2;arr[3] = 3;

        if( n <= 3) {System.out.println(n);}
        
        for(int i = 4 ; i <= n ; i++) {
           arr[i] = arr[i-1] + arr[i-2];
        }
        
        System.out.println(arr[n]);
    }
}