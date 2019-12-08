class LC680 {
    public static void main(String[] args) {

        // System.out.println("Hellow");

        System.out.println(validPalindrome(
                "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));

    }

    public static boolean validPalindrome(String s) {
        s = s.toLowerCase();
        int last = s.length() - 1;
        int front = 0;
        int skipped = 0;
        int skippedFrontFalse = 0;
        int skippedLastFalse = 0;
        while (front < last) {
            if (s.charAt(front) == s.charAt(last) && skipped == 0) { // restricting happy path for skipped cases
                front++;
                last--;
            } else {
                // if deletion is needed

                if (s.charAt(front + 1) != s.charAt(last) && skippedFrontFalse == 0) {
                    skippedFrontFalse = 1;
                    skipped = 1;
                }
                if (s.charAt(front) != s.charAt(last + 1) && skippedLastFalse == 0) {
                    skippedLastFalse = 1;
                    skipped = 1;
                }

            }

        }
        return true;

    }

}