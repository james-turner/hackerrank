package HackerRank;

public class BinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static class Tuple {
        private final Node node;
        private final int lower;
        private final int upper;

        public Tuple(Node node, int lower, int upper) {
            this.node = node;
            this.lower = lower;
            this.upper = upper;
        }
    }


    static boolean checkBST(Node root) {
        java.util.LinkedList<Tuple> q = new java.util.LinkedList<>();
        q.add(new Tuple(root, 0, 10000));
        while(q.peek() != null){
            Tuple t = q.poll();
            Node elem = t.node;
            if(elem.data <= t.lower || elem.data >= t.upper)
                return false;
            if((elem.left != null && elem.left.data > elem.data) || (elem.right != null && elem.right.data < elem.data))
                return false;
            else {
                if(elem.left != null) q.add(new Tuple(elem.left, t.lower, t.node.data));
                if(elem.right != null) q.add(new Tuple(elem.right, t.node.data, t.upper));
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Node root = new Node();
        Node two = new Node();
        Node one = new Node();
        Node three = new Node();
        Node six = new Node();
        Node seven = new Node();
        Node five = new Node();
        root.data = 4;
        two.data = 2;
        one.data = 1;
        three.data = 3;
        six.data = 6;
        seven.data = 7;
        five.data = 5;
        two.left = one;
        two.right = three;
        six.left = five;
        six.right = seven;
        root.left = two;
        root.right = six;

        System.out.println(checkBST(root));
    }

}
