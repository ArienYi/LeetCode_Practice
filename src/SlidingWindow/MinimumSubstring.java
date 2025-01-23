package SlidingWindow;

import java.util.HashMap;

public class MinimumSubstring {

    public String Solution(String s, String t){
        HashMap<Character, Integer> charInT = new HashMap<>();
        HashMap<Character, Integer> charInWindow = new HashMap<>();
        for (char c : t.toCharArray()){
            charInT.put(c, charInT.getOrDefault(c,0) + 1);
        }
        int left = 0, right = 0;
        int numOfIncludedChar = 0;
        int lengthOfResult = Integer.MAX_VALUE;
        String result = new String("");
        while (right < s.length()){
            char toBeIncluded = s.charAt(right);
            right ++;
            charInWindow.put(toBeIncluded, charInWindow.getOrDefault(toBeIncluded, 0) + 1);
            if (charInT.containsKey(toBeIncluded)){
                if(charInWindow.get(toBeIncluded).equals(charInT.get(toBeIncluded))){
                    numOfIncludedChar ++;
                }
            }

            while(numOfIncludedChar == charInT.size()){
                String curr = s.substring(left, right);
                if (curr.length() < lengthOfResult){
                    result = curr;
                    lengthOfResult = curr.length();
                }

                char toBeRemoved = s.charAt(left);
                left ++;
                charInWindow.put(toBeRemoved, charInWindow.getOrDefault(toBeRemoved,0) - 1);
                if(charInT.containsKey(toBeRemoved)){
                    if (charInWindow.get(toBeRemoved)<charInT.get(toBeRemoved)){
                        numOfIncludedChar --;
                    }
                }
            }

        }
        return result;
    }
}
