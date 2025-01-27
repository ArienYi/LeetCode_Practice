package BFS;

import java.util.*;

public class OpenLock {

    public int Solution(String[] deadends, String target){
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        visited.addAll(Arrays.asList(deadends));
        if (visited.contains("0000")) return -1;
        String start = "0000";
        visited.add(start);
        q.offer(start);
        int step = 0;
        while (!q.isEmpty()){
            int sz = q.size();
            for (int i = 0; i < sz; i++){
                String curr = q.poll();
                if(curr.equals(target)){
                    return step;
                }
                for (String nb:getNeighbors(curr)){
                    if (!visited.contains(nb)){
                        visited.add(nb);
                        q.offer(nb);
                    }
                }
            }
            step ++;
        }

        return -1;

    }

    private List<String> getNeighbors(String code){
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < code.length();i++){
            neighbors.add(plusOneAt(code, i));
            neighbors.add(minusOneAt(code, i));
        }
        return neighbors;
    }

    private String plusOneAt(String code, int idx){
        char[] chars = code.toCharArray();
        if (chars[idx]=='9'){
            chars[idx] = '0';
        }else{
            chars[idx] += 1;
        }
        return new String(chars);
    }

    private String minusOneAt(String code, int idx){
        char[] chars = code.toCharArray();
        if (chars[idx]=='0'){
            chars[idx] = '9';
        }else{
            chars[idx] -= 1;
        }
        return new String(chars);
    }
}
