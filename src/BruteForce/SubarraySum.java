package BruteForce;

public class SubarraySum {
    public int Solution(int[] nums){
        int[] starts = new int[nums.length];
        int[] preSums = new int[nums.length+1];
        preSums[0] = 0;
        for (int i = 0; i < nums.length; i++){
            starts[i] = Math.max(0,i - nums[i]);
        }
        for(int j = 1; j < preSums.length; j++){
            preSums[j] = preSums[j-1] + nums[j-1];
        }

        int result = 0;
        for (int index = 0; index < nums.length; index++){
            if (starts[index] == index){
                result += nums[index];
            } else{
                result += preSums[index+1] - preSums[starts[index]];
            }
        }
        return result;
    }

}
