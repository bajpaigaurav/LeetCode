import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class ChefCLPT {
    




    public static void main(String[] args) {
        
        InputReader in = new InputReader(System.in);

        int t = in.nextInt();

        while(t-- > 0) {

            int n = in.nextInt();

            int[] points = in.nextIntArray(n);

            int q = in.nextInt();

            for(int i = 0; i < q; i++) {

                int x = in.nextInt();
                int y = in.nextInt();
                int index = 0;
                int d = 0;
                for(int p: points) {
                   d = (x-0)*(0 - p) - (y - p)*(p - 0);
                    if(d < 0) {
                        index++;
                        continue;
                    } else if(d > 0) {
                        System.out.println(index);
                        index++;
                        break;
                    } else {
                        System.out.println(-1);
                        index++;
                        break;
                    }
                    
                }

                if(index > n || d < 0) {
                    System.out.println(n);
                }
                // int where_x = 0;
                // int where_y = 0;
                // int index = 0;
                // // tells where x and y belong in list

                // for(int dum: points) {
                //     if( x >= dum) {
                //         where_x = index;
                //     }
                //     if( y >= dum) {
                //         where_y = index;
                //     }
                //     index++;

                // }
                
                // if(where_x == 0 && where_y == 0) {
                //     System.out.println(1);
                // } else if (x == points[where_x]) {

                // } else if (y == points[where_y]) {

                // }

                
                


            }

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
        public long[] nextLongArray(int n) {
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
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