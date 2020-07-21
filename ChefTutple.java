import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class ChefTutple {
    
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);

        int t = in.nextInt();

        while(t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int p = in.nextInt();
            int q = in.nextInt();
            int r = in.nextInt();

            int adiff = Math.abs(p - a);
            int bdiff = Math.abs(q - b);
            int cdiff = Math.abs(r - c);
            if(adiff == 0 && bdiff== 0 && cdiff == 0){
                System.out.println(0);
            } else if(adiff == 0 || bdiff == 0 || cdiff == 0) {

                if(adiff == 0) {
                    if(bdiff == cdiff || cdiff == 0 || bdiff == 0) {
                        System.out.println(1);
                    } else if ((bdiff%cdiff)==0 || (cdiff%bdiff==0)) {
                        System.out.println(1);
                    } else {
                        System.out.println(2);
                    }
                } else if(bdiff == 0) {
                    if(adiff == cdiff || adiff == 0 || cdiff == 0) {
                        System.out.println(1);
                    } else if ((adiff%cdiff)==0 || (cdiff%adiff==0)) {
                        System.out.println(1);
                    } else {
                        System.out.println(2);
                    }
                } else if(cdiff == 0) {
                    if(adiff == bdiff || adiff == 0 || bdiff == 0) {
                        System.out.println(1);
                    } else if ((adiff%bdiff)==0 || (bdiff%adiff==0)) {
                        System.out.println(1);
                    } else {
                        System.out.println(2);
                    }
                }
            } else {
                if((adiff == bdiff && bdiff == cdiff && cdiff == adiff)) {
                    System.out.println(1);
                } else if (adiff == bdiff || bdiff == cdiff || cdiff == adiff ||
                  adiff%bdiff == 0 || bdiff%cdiff==0 || cdiff%adiff==0) {
                    System.out.println(2);
                } else if(adiff != bdiff && bdiff != cdiff && adiff != cdiff){
                    System.out.println(3);
                }
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