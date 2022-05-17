package LeetCode;

import java.util.*;

public class ArrayReverse {

    public static void main(String[] args) {

        Integer[] a = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        List<Integer> l = Arrays.asList(a);
        Collections.reverse(l);
        ArrayList<Integer> l1 = new ArrayList(l);
        System.out.println(l1);

    }

}
