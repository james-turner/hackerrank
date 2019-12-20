package HackerRank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//class Node {
//    Node left;
//    Node right;
//    int data;
//
//    Node(int data) {
//        this.data = data;
//        left = null;
//        right = null;
//    }
//}
//
//class Solution {
//
//    /*
//    class Node
//        int data;
//        Node left;
//        Node right;
//    */
//    public static Node lca(Node root, int v1, int v2) {
//        // Write your code here.
//        Node res = root;
//        while(true){
//            if(v1 < res.data && v2 < res.data){
//                res = res.left;
//            } else if(v1 > res.data && v2 > res.data) {
//                res = res.right;
//            } else break;
//        }
//
//        return res;
//    }
//
//    public static Queue<Node> findV(Node root, int v){
//        Queue<Node> stack = new LinkedList<>();
//        Node base = root;
//        stack.add(base);
//        while(base.data != v){
//            if(v < base.data) base = base.left;
//            else base = base.right;
//            stack.add(base);
//        }
//        return stack;
//    }
//
//
//
//    public static Node insert(Node root, int data) {
//        if(root == null) {
//            return new Node(data);
//        } else {
//            Node cur;
//            if(data <= root.data) {
//                cur = insert(root.left, data);
//                root.left = cur;
//            } else {
//                cur = insert(root.right, data);
//                root.right = cur;
//            }
//            return root;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int t = scan.nextInt();
//        Node root = null;
//        while(t-- > 0) {
//            int data = scan.nextInt();
//            root = insert(root, data);
//        }
//        int v1 = scan.nextInt();
//        int v2 = scan.nextInt();
//        scan.close();
//        Node ans = lca(root,v1,v2);
//        System.out.println(ans.data);
//    }
//}