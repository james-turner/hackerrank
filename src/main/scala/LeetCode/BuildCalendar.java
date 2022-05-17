package LeetCode;

import java.util.*;

public class BuildCalendar {

    public static void main(String[] args) {

        LinkedList<LinkedList<int[]>> res = buildCalendar(new int[][]{new int[]{1,2},new int[]{3,5}, new int[]{4,6}});

        for(LinkedList<int[]> i: res){
            String s = "";
            for(int[] p: i){
                s += "["+p[0]+","+p[1]+"]";
            }
            System.out.println(s);
        }

    }

    public static LinkedList<LinkedList<int[]>> buildCalendar(int[][] datapoints) {
        LinkedList<LinkedList<int[]>> buffer = new LinkedList<>();
        LinkedList<int[]> current = new LinkedList();
        int currentEnd = datapoints[0][1];
        current.add(datapoints[0]);
        for(int i=1; i<datapoints.length; i++){
            if(datapoints[i][0] < currentEnd){
                current.add(datapoints[i]);
                currentEnd = Math.max(currentEnd, datapoints[i][1]);
            } else {
                buffer.add(current);
                current = new LinkedList<>();
                current.add(datapoints[i]);
                currentEnd = datapoints[i][1];
            }
        }
        if(!current.isEmpty()) buffer.add(current);
        return buffer;
    }
}
