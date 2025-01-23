package BinarySearch;

import java.util.List;

public class FindFirstLast {

    public int[] Solution(int[] nums, int target){
        int leftBound = findLeftBound(nums, target);
        int rightBound = findRightBound(nums, target);
        return new int[]{leftBound,rightBound};
    }

    private int findLeftBound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                right = mid - 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        if (left < 0 || left > nums.length - 1){
            return -1;
        }
        if (nums[left] != target){
            return -1;
        }
        return left;
    }

    private int findRightBound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        if (right < 0 || right > nums.length - 1){
            return -1;
        }
        if (nums[right]!=target){
            return -1;
        }
        return right;
    }
}
