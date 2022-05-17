package LeetCode;

public class SearchInRotatedArray {

    public static void main(String[] args) {

        System.out.println(findRotationPoint(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findRotationPoint(new int[]{4, 5, 6, 7, 8, 9, 10, -9, 0, 1, 2}));

    }

    public static int findRotationPoint(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[right] < nums[mid]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
