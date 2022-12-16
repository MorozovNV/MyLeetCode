package num1_Two_Sum;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int sum=0;
        int[] res;
        for (int i=0;i<nums.length; i++) {
            for (int j=0;j<nums.length; j++) {
                if (i == j) continue;
                sum = nums[i] + nums[j];
                if (sum==target) return res = new int[] {i,j};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[] {1,2,3,4,5};
        int target = 4;
        array = solution.twoSum(array, target);
        for (int a:array){
            System.out.print(a + "");
        }

    }


}