import java.util.Arrays;

class Solution238 {

    public static void main(String[] args) {
        int[] nums = {2};
       System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {

        if (nums.length <= 1) {
            return nums;
        }
        int maxLen = nums.length;
        int[] forward = new int[maxLen]; // skip first then all
        int[] backward = new int[maxLen]; // skip last then all

        forward[0] = 1;
        backward[maxLen - 1] = 1;
        int temp = 1;
        for (int i = 0; i < maxLen-1; i++) {
            temp = temp * nums[i];
            forward[i+1] = temp;
        }
        temp = 1; // resetting temp for back array
        backward[maxLen - 1] = 1;
        for (int i = maxLen - 2; i >= 0; i--) {
            temp = temp * nums[i + 1];
            backward[i] = temp;
        }

        //System.out.println(Arrays.toString(forward));
        //System.out.println(Arrays.toString(backward));

        for (int i = 0; i < maxLen; i++) {
            forward[i] = forward[i] * backward[i];
        }

        return forward;
    }
}