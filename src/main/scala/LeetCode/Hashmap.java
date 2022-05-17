package LeetCode;

import java.util.HashMap;

public class Hashmap {

    public static void main(String[] args) {

        int[] a = new int[]{0,1,2,1,2,0,2,1};
        sortColors(a);
        for(int i =0; i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    public static void sortColors(int[] nums) {
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i =0; i<nums.length;i++){
            if(m.containsKey(nums[i])){
                m.put(nums[i], m.get(nums[i])+1);
            } else {
                m.put(nums[i], 1);
            }
        }

        int pos = 0;
        for(int j = 0; j<3; j++){
            if(m.containsKey(j)){
                int count = m.get(j);
                for(int k = 0; k<count; k++){
                    nums[k+pos] = j;
                }
                pos += count;
            }
        }

    }
}
