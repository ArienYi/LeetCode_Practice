package BFS;
import java.util.*;

public class SlidingPuzzle {

    public int Solution(int[][] board){
        Queue<int[][]> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        q.offer(board);
        visited.add(boardToString(board));
        int step = 0;
        int[][] target = new int[][]{
                {1,2,3},
                {4,5,0}
        };
        while (!q.isEmpty()){
            int currSize = q.size();
            for (int i=0; i<currSize; i++){
                int[][] curr = q.poll();
                if(boardToString(curr).equals(boardToString(target))){
                    return step;
                }
                int[] idx = getZeroIndex(curr);
                for(int[][] nb : getNeighbors(curr, idx)){
                    if (!visited.contains(boardToString(nb))){
                        q.offer(nb);
                        visited.add(boardToString(nb));
                    }
                }
            }
            step ++;
        }
        return -1;
    }

    private List<int[][]> getNeighbors(int[][] board, int[] idx){
        int i = idx[0], j = idx[1];
        int n = board.length, m = board[0].length;
        int[][] dirs = new int[][]{
                new int[]{0, 1},
                new int[]{0, -1},
                new int[]{1, 0},
                new int[]{-1,0}
        };
        List<int[][]> neighbors = new ArrayList<>();
        for (int[] dir : dirs){
            int di = i + dir[0];
            int dj = j + dir[1];
            if (di >= 0 && di < n && dj >= 0 && dj < m){
                neighbors.add(swap(board, new int[]{i, j}, new int[]{di,dj}));
            }
        }
        return neighbors;
    }

    private int[][] swap(int[][] board, int[] ij, int[] didj){
        int intIJ = board[ij[0]][ij[1]];
        int[][] nb = copy(board);
        nb[ij[0]][ij[1]] = nb[didj[0]][didj[1]];
        nb[didj[0]][didj[1]] = intIJ;
        return nb;
    }

    private int[][] copy(int[][] board){
        int n = board.length;
        int m = board[0].length;
        int[][] newBoard = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j ++){
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }

    private int[] getZeroIndex(int[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j= 0; j < board[0].length; j++){
                if (board[i][j] == 0){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    private String boardToString(int[][] board){
        String res = "";
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length; j++){
                res = res + Integer.toString(board[i][j]);
            }
        }
        return res;
    }
}
