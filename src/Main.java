import BinarySearch.BinarySearch;
import DynamicProgramming.CoinChange;

public class Main {
    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        int tmp = solution.Solution(new int[]{2}, 3);
        System.out.println(tmp);


    }
}