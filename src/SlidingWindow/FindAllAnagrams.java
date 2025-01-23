package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams {

    public List<Integer> Solution(String s, String p){
        List<Integer> results = new ArrayList<>();
        HashMap<Character, Integer> charInWindow = new HashMap<>();
        HashMap<Character, Integer> charInNeed = new HashMap<>();
        for (char c:p.toCharArray()){
            charInNeed.put(c, charInNeed.getOrDefault(c,0)+1);
        }

        int left = 0, right = 0;
        int numOfIncludedChar = 0;
        while (right < s.length()){
            char toBeIncluded = s.charAt(right);
            right ++;
            charInWindow.put(toBeIncluded, charInWindow.getOrDefault(toBeIncluded, 0) + 1);
            if (charInNeed.containsKey(toBeIncluded)){
                if (charInNeed.get(toBeIncluded).equals(charInWindow.get(toBeIncluded))){
                    numOfIncludedChar++;
                }
            }

            while (right - left >= p.length()){
                if (numOfIncludedChar == charInNeed.size()){
                    results.add(left);
                }
                char toBeRemoved = s.charAt(left);
                left ++;
                if (charInNeed.containsKey(toBeRemoved)){
                    if(charInNeed.get(toBeRemoved).equals(charInWindow.get(toBeRemoved))){
                        numOfIncludedChar --;
                    }
                }
                charInWindow.put(toBeRemoved,charInWindow.getOrDefault(toBeRemoved, 0) - 1);
            }
        }
        return results;
    }
}
