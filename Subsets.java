import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets {

    List<List<Integer>> subs(int [] nums,int index) {
        if (index >= nums.length-1) {
            List<Integer> lst = new ArrayList<>();
            lst.add(nums[index]);
            List<List<Integer>> retValue = new LinkedList<>();
            retValue.add(lst);
            //System.out.println(retValue.size());
            retValue.add(new ArrayList<>());
            return retValue;
        }else {
            List<List<Integer>> pendingSubs = subs(nums,index+1);
            List<List<Integer>> returnValue = new LinkedList<>();
            returnValue.addAll(pendingSubs);
            for (List<Integer> lst : pendingSubs) {
                List<Integer> copiedList = lst.stream().collect(Collectors.toList());
                copiedList.add(nums[index]);
                copiedList.sort(null);
                returnValue.add(copiedList);

            }

            return returnValue;
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        if (nums.length == 0) {
            List<List<Integer>> lst = new LinkedList<>();
            List<Integer> l = new ArrayList<>();
            lst.add(l);
            return lst;

        }
        return subs(nums,0);
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int [] nums = {};
        List<List<Integer>> lst = subsets.subsets(nums);
        System.out.println(lst.size());
        for (List<Integer> l : lst) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
}
