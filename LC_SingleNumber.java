import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {

    public static void main(final String[] args) {
        System.out.println(singleNumber({1,2,3,4}));
    }
    public static Set<Integer> singleNumber(int[] nums) {
          Map<Integer,Integer> h = new HashMap<Integer,Integer>();
        //base
        if(nums.length == 1)
        {return nums[0];}
        else {
            for(int i = 0; i < nums.length; i++) {
                if(h.get(i) == null) {
                h.put(i,i);
                } else {
                    h.remove(i);
                }
            }
        }

        return h.;
        
    }
}