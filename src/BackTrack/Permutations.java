package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> Solution(int[] nums){
        List<Integer> track = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used,false);
        backTrack(nums, track, used);
        return res;
    }

    private void backTrack(int[] nums, List<Integer> track, boolean[] used){
        if(track.size() == nums.length){
            res.add(List.copyOf(track));
            return;
        }

        for (int i = 0; i < nums.length; i ++){
            if (used[i]){
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backTrack(nums, track, used);
            track.remove(track.size()-1);
            used[i] = false;
        }
    }
}
