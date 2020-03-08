import java.util.LinkedList;

class Index {
    private int value;
    private int index;

    public Index(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }
}

public class MinStack {


    private LinkedList<Integer> stack = new LinkedList<>();
    private LinkedList<Index> minValuesStack = new LinkedList<>();


    public MinStack() {
        // do intialization if necessary
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.addFirst(number);

        if (minValuesStack.size() == 0) {
            minValuesStack.addFirst(new Index(number,0));
        }else {

            int minValue = minValuesStack.getFirst().getValue();
            //System.out.println("Adding number = " + number + " minValue = " + minValue);
            if (number <= minValue) {
                minValuesStack.addFirst(new Index(number,stack.size()-1));
            }
        }


    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int currentIndex = stack.size()-1;
        int poppedValued = stack.removeFirst();
        int minValueIndex = minValuesStack.getFirst().getIndex();
        if (currentIndex == minValueIndex) {
            minValuesStack.removeFirst();
        }
        return poppedValued;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return minValuesStack.getFirst().getValue();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(30);
        minStack.push(20);
        minStack.push(10);
        minStack.push(10);
        minStack.push(20);
        minStack.push(1);

        System.out.println(minStack.min());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());


    }
}
