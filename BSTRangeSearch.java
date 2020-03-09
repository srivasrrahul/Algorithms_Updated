

import java.util.LinkedList;
import java.util.List;

//class TreeNode {
//    public int val;
//     public TreeNode left, right;
//    public TreeNode(int val) {
//        this.val = val;
//        this.left = this.right = null;
//     }
//}



public class BSTRangeSearch {
    class Range {
        public int getLow() {
            return low;
        }

        public int getHigh() {
            return high;
        }

        private int low;
        private int high;

        public Range(int low, int high) {
            this.low = low;
            this.high = high;
        }

        boolean inRange(int val) {
            return val >= low && val <= high;
        }
    }
    void search(TreeNode node,Range r,LinkedList<Integer> lst) {
        if (node == null) {

        }else {
            if (node.val > r.getLow()) {
                search(node.left,r,lst);
            }

            if (r.inRange(node.val)) {
                lst.addLast(node.val);
            }

            if (node.val < r.getHigh()) {
                search(node.right,r,lst);
            }

        }
    }
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        Range range = new Range(k1,k2);
        LinkedList<Integer> lst = new LinkedList<>();
        search(root,range,lst);
        return lst;
    }

    public static void main(String[] args) {
        BSTRangeSearch search = new BSTRangeSearch();
        TreeNode root = new TreeNode(2);
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(3);
        TreeNode l3 = new TreeNode(4);
        TreeNode l4 = new TreeNode(5);
        l2.right = l4;
        l4.left = l3;
        root.left = l1;
        root.right = l2;
        List<Integer> lst = search.searchRange(root,3,5);
        for (Integer x : lst) {
            System.out.println(x);
        }
    }
}
