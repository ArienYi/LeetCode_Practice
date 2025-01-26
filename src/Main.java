import BFS.SlidingPuzzle;
import BackTrack.Permutations;
import BinarySearch.BinarySearch;
import BruteForce.SubarraySum;
import DynamicProgramming.CoinChange;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SlidingPuzzle solution = new SlidingPuzzle();
        int tmp = solution.Solution(new int[][]{
                {4,1,2},
                {5,0,3}
        });
        System.out.println(tmp);


    }
}