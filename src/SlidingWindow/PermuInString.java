package SlidingWindow;

import java.util.HashMap;

public class PermuInString {
    public boolean Solution(String s1, String s2){
        HashMap<Character, Integer> charInWindow = new HashMap<>();
        HashMap<Character, Integer> charNeeded = new HashMap<>();
        for (char c : s1.toCharArray()){
            charNeeded.put(c, charNeeded.getOrDefault(c,0) + 1);
        }
        int left = 0, right = 0;
        int numOfIncludedChar = 0;
        while(right < s2.length()){
            char toBeInclude = s2.charAt(right);
            right ++;
            if (charNeeded.containsKey(toBeInclude)){
                charInWindow.put(toBeInclude, charInWindow.getOrDefault(toBeInclude, 0)+1);
                if (charInWindow.get(toBeInclude).equals(charNeeded.get(toBeInclude))){
                    numOfIncludedChar ++;
                }
            }

            while (right - left >= s1.length()){
                if (numOfIncludedChar == charNeeded.size()){
                    return true;
                }
                char toBeRemoved = s2.charAt(left);
                left ++;
                charInWindow.put(toBeRemoved, charInWindow.getOrDefault(toBeRemoved, 0) -1 );
                if (charNeeded.containsKey(toBeRemoved)){
                    if (!charNeeded.get(toBeRemoved).equals(charInWindow.get(toBeRemoved))){
                        numOfIncludedChar --;
                    }
                }
            }
        }
        return false;
    }
}
