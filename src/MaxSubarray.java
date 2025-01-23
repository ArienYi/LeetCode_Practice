public class MaxSubarray {
    public int Solution(int[] nums){
        int left = 0, right = 0;
        int sum = 0;
        while(right < nums.length){
            sum += nums[right];
            right ++;
            while(sum - nums[left] > sum){
                sum -= nums[left];
                left ++;
            }
        }
        return sum;
    }
}
