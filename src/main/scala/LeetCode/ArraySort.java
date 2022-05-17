package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraySort {

    public static void main(String[] args) {

        Integer[] a = new Integer[]{1,2,4,3,6,5,7,8,9,10};
        Arrays.sort(a, Collections.reverseOrder());

        for(int i = 0; i < a.length; i++){
            System.out.println(i);
        }

    }
}
