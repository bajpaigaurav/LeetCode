/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class ChefEOEO
{
	
     public static void main(String[] args) {

        InputReader in = new InputReader(System.in);

        int t = in.nextInt();

        // If both TS and JS are even, their values get divided by 2 and the game proceeds with the next turn.
        // If both TS and JS are odd, a tie is declared and the game ends.
        // If TS is even and JS is odd, Tom wins the game.
        // If TS is odd and JS is even, Jerry wins the game.
        // ts - even - 100 ->
        // js - odd and tom ko even - 
        // ts = 100, js = 50 -> 50,25
        
        while(t-- > 0) {
            // initial
            int ts = in.nextInt();
            int js = 0;
            int times= 0;
            int its = ts;
            // solution space can go between -> 0 to ts
            if(ts == 1) {
                System.out.println(js);
                continue;
            } else if ( ts % 2 != 0 ){
                System.out.println(ts/2 );
                continue;
            } else {
                while(ts % 2 == 0) {
                   ts = ts / 2;
                   times++;
                }
                double div = Math.pow(2, times);
                for(double i = div+1 ; i <= its; i++) {
                   if(((i/div) != 0) && (i / div )% 2 == 0 ) {
                       //System.out.println("for ith value"+ i);
                       js++;
                   }
                }
        }

        System.out.println(js);
        
    }
}

    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}