import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {


    public static void main(String[] args) {
        int[] num = {2, 7, 11, 15};
         System.out.println(Arrays.toString(twoSum(num,9)));
    }

    public static  int[] twoSum(int[] nums, int target) {
        int[] result = new int [2];
        Map<Integer, Integer> numsSoFar = new HashMap<Integer,Integer>();
        int index = 0;
        for(int a : nums) {
            if(numsSoFar.get(target-a) != null) {
               result[1] = index;
               result[0] = numsSoFar.get(target-a);
               break;
            }

            numsSoFar.put(a, index);


            index++; // moving forward
        }
        return result;
        
    }
}