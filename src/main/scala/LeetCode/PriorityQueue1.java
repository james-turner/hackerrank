package LeetCode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueue1 {

    public static void main(String[] args) {

        PriorityQueue<Integer> l = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        l.add(1);
        l.add(2);
//        System.out.println(l.peek());
//        while(!l.isEmpty()){
//            System.out.println(l.poll());
//        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
        System.out.println(q.poll());

    }
}
