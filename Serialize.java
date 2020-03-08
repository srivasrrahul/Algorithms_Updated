class ParserState {
    private String inputString;
    private int parserIndex;

    ParserState(String inputString) {
        this.inputString = inputString;
        parserIndex = -1;

    }

    void consume(String x) {
        parserIndex += x.length();
    }

    String lookAhead() {
        return String.valueOf(inputString.charAt(parserIndex+1));
    }

    String consumeTill(char x) {
        StringBuilder consumer = new StringBuilder();
        while (inputString.charAt(parserIndex+1) != x) {
            consumer.append(inputString.charAt(parserIndex+1));
            parserIndex += 1;
        }

        return consumer.toString();
    }
}
public class Serialize {

    void serializeNode(TreeNode node,StringBuilder encoder) {
        if (node == null) {
            encoder.append("[]");
        }else {

            encoder.append("[");
            encoder.append(String.valueOf(node.val));
            encoder.append(",");
            serializeNode(node.left,encoder);
            encoder.append(",");
            serializeNode(node.right,encoder);
            encoder.append("]");

        }
    }


     TreeNode deserializeNode(ParserState parserState) {
         parserState.consume("[");
         if (parserState.lookAhead().equals("]") == false) {
            String nodeVal = parserState.consumeTill(',');
            TreeNode node = new TreeNode(Integer.valueOf(nodeVal));
            parserState.consume(",");
            TreeNode left = deserializeNode(parserState);
            parserState.consume(",");
            TreeNode right = deserializeNode(parserState);
            node.left = left;
            node.right = right;
            parserState.consume("]");
            return node;
         }else {
             parserState.consume("]");
             return null;
         }

    }
    public String serialize(TreeNode root) {
        StringBuilder encoder = new StringBuilder();
        serializeNode(root,encoder);

        return encoder.toString();

    }
    public TreeNode deserialize(String data) {
        // write your code here
        ParserState parserState = new ParserState(data);
        TreeNode root = deserializeNode(parserState);
        return root;


    }

    public static void main(String[] args) {
        Serialize serialize = new Serialize();
        TreeNode node = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(3);
        TreeNode l5 = new TreeNode(5);


        node.left = l1;
        node.right = l2;
        l1.right = l5;
        String serializedData = serialize.serialize(node);
        TreeNode n1 = serialize.deserialize(serializedData);
        System.out.println(n1.val);
        System.out.println(n1.left.val);
        System.out.println(n1.right.val);
        System.out.println(n1.left.right.val);


    }
}
