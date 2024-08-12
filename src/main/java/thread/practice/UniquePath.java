package thread.practice;



import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniquePath {
    Map<String,Integer> map = new HashMap<>();
    int recur(int[][] obstacleGrid, int i, int j) {
        String key =i+":"+j;
        if (i >= obstacleGrid.length || j >= obstacleGrid[0].length) {
            return 0;
        }
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return 1;
        }
        else if(map.containsKey(key)){
            return map.get(key);
        }
        else if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        int currentPathCount = recur(obstacleGrid, i + 1, j) + recur(obstacleGrid, i, j + 1);
        map.put(key,currentPathCount);
        return currentPathCount;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return recur(obstacleGrid, 0, 0);
    }


    public static void main(String[] args) {
        int inp[][] = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(new UniquePath().uniquePathsWithObstacles(inp));
    }
}
