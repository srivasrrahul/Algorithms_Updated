import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {
    List<List<Integer>> perm(int [] nums,int index) {
        if (index == nums.length-1) {
            List<Integer> lst = new LinkedList<>();
            lst.add(nums[index]);
            List<List<Integer>> retValue = new LinkedList<>();
            retValue.add(lst);
            //System.out.println(retValue.size());
            return retValue;
        }else {
            List<List<Integer>> pendingPerms = perm(nums,index+1);
            List<List<Integer>> returnValue = new LinkedList<>();
            for (List<Integer> lst : pendingPerms) {
                int listSize = lst.size();
                for (int i = 0; i <= listSize; ++i) {
                    List<Integer> copiedList = lst.stream().collect(Collectors.toList());
                    //System.out.println("Copied list " + Arrays.toString(copiedList.toArray()));
                    copiedList.add(i,nums[index]);

                    returnValue.add(copiedList);
                }
            }

            return returnValue;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        if (nums.length == 0) {
            List<List<Integer>> lst = new  LinkedList<>();
            lst.add(new LinkedList<>());
            return lst;
        }else {
            List<List<Integer>> retValue = perm(nums, 0);
            return retValue;
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        //int [] nums = {1,2,3,4,5};
        int [] nums = {};
        List<List<Integer>> lst = permutation.permute(nums);
        System.out.println(lst.size());
        for (List<Integer> l : lst) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
}

