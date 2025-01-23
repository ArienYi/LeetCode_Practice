package SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRep {
    public int Solution(String s){

        HashMap<Character, Integer> charInWindow = new HashMap<>();
        int left = 0, right = 0;
        int result = 0;
        while(right < s.length()){
            char toBeIncluded = s.charAt(right);
            right ++;
            charInWindow.put(toBeIncluded, charInWindow.getOrDefault(toBeIncluded,0)+1);
            while (charInWindow.get(toBeIncluded) > 1){
                char toBeRemoved = s.charAt(left);
                left ++;
                charInWindow.put(toBeRemoved, charInWindow.getOrDefault(toBeRemoved, 0) - 1);
            }
            result = Math.max(result, right - left);

        }
        return result;
    }
}
