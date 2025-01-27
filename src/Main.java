import BFS.OpenLock;
import BFS.SlidingPuzzle;
import BackTrack.Permutations;
import BinarySearch.BinarySearch;
import BruteForce.SubarraySum;
import DynamicProgramming.CoinChange;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OpenLock solution = new OpenLock();
        int tmp = solution.Solution(new String[]{
                "0201","0101","0102","1212","2002"
        }, "0202");
        System.out.println(tmp);


    }
}