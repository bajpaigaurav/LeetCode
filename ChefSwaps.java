import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;

public class ChefSwaps {
    

public static void main(String[] args) {
    
    InputReader in = new InputReader(System.in);

    int t = in.nextInt();

    


    while( t-- > 0) {

        int n = in.nextInt();
        HashMap<Long,Integer> frequency = new HashMap<>();
        long[] a = in.nextLongArray(n);
        long[] b = in.nextLongArray(n);

        for(int i = 0; i < n; i++) {

            if(frequency.get(a[i]) == null) {
                frequency.put(a[i],1);
            } else {
                frequency.put(a[i], frequency.get(a[i])+1);
            }

            if(frequency.get(b[i]) == null) {
                frequency.put(b[i],-1);
            } else {
                frequency.put(b[i], frequency.get(b[i])+ (-1));
            }
            
        }
        // minimum key - having zero value
        // counting non zero items
        long min = Integer.MAX_VALUE;
        long count = 0;
        boolean minusOne = false;
        List<Long> list = new ArrayList<Long>();
        long directSwapping = 0;
        for(long key : frequency.keySet()) {
            if(min > key) {
                min = key;
            }
            if(frequency.get(key) != 0) {
                count += Math.abs(frequency.get(key)/2);
                list.add(key);

            }
            if(frequency.get(key) % 2 != 0) {
                minusOne = true;
                
            }
        }
        list.sort(null);

        for(int i = 0; i < list.size()/2 ;i++) {
            directSwapping += list.get(i);
        }
        // for(long key: frequency.keySet()) {
        //     System.out.println(key+"->"+frequency.get(key));
        // }
        // System.out.println(min+">"+count);
        if(minusOne == true) {
            System.out.println(-1);
        } else if(count == 0) {
            System.out.println(0);
        } else {
            if(frequency.get(min)==0) {
                System.out.println(min*(count));
            } else {
                System.out.println(min*(count-1) > directSwapping ? directSwapping : min*(count-1));
            }
            
        }


    }

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