import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class CFAprilLong {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        Set<Integer> ss;

        for(int i=0;i<t;i++) {
            int x = s.nextInt();
            int k = s.nextInt();
            if(Math.pow(2, k) > x) {
                System.out.println(0);
                continue;
            } else if (Math.pow(2, k) == x) {
                System.out.println(1);
            } else {
                ss = primeFactors(x);
                if(ss.size() == k) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }

            
        }
    }
// from geeksforgeeks : https://www.geeksforgeeks.org/java-program-for-efficiently-print-all-prime-factors-of-a-given-number/
    public static Set<Integer> primeFactors(int n) 
    { 
        Set <Integer> s = new HashSet<Integer>();
        // Print the number of 2s that divide n 
        while (n % 2 == 0) { 
            s.add(2);
            n /= 2; 
        } 
  
        // n must be odd at this point.  So we can 
        // skip one element (Note i = i +2) 
        for (int i = 3; i <= Math.sqrt(n); i += 2) { 
            // While i divides n, print i and divide n 
            while (n % i == 0) { 
                s.add(i);
                n /= i; 
            } 
        } 
  
        // This condition is to handle the case whien 
        // n is a prime number greater than 2 
        if (n > 2) 
            s.add(n);
    return s;
    } 
  
}