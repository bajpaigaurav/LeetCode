import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class ChefCardGame {
    

    public static void main(String[] args) {
        

        InputReader in = new InputReader(System.in);

        int t = in.nextInt();

        while(t-- > 0) {
            int n = in.nextInt();
            long suma = 0, sumb =0;
            long chef = 0, some = 0;
            for(int i = 0; i < n; i++) {
                long a = in.nextLong();
                long b = in.nextLong();

                suma = getSum(a);
                sumb = getSum(b);
                System.out.println(a +"->"+suma +" "+b+"->"+sumb);
                if(suma > sumb) {
                chef++;
                } else if (suma < sumb) {
                some++;
                } else {
                    chef++;some++;
                }

            }

            if(chef > some) {
                System.out.println(0+" "+chef);
            } else if (some > chef) {
                System.out.println(1+" "+some);
            } else {
                System.out.println(2+" "+chef);
            }
        }
    }
// from geeks
    static long getSum(long n) 
    {     
        long sum = 0; 
          
        while (n > 0 || sum > 9)  
        { 
            if (n == 0) { 
                n = sum; 
                sum = 0; 
            } 
            sum += n % 10; 
            n /= 10; 
        }

        return sum;
    } 


    // for fast IO
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