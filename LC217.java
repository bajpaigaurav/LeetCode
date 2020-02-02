import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class SolutionLC217 {

   public static void main(String[] args) {
       int[] a = {1,2};
       System.out.println(containsDuplicate(a));  ;
   }


    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (Integer integer : nums) {   
        set.add(integer);
        }
        //System.out.println(nums.length+"-"+set.size()+"-"+ set);
        if(nums.length > 0 && nums.length != set.size()) {
            return true;
        } else {
            return false;
        }
    }
}

