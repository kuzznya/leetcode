package space.kuzznya.leetcode.task63;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] grid = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) grid[i][j] = 0;
                else if (i == 0 && j == 0) grid[i][j] = 1;
                else if (i == 0) grid[i][j] = grid[i][j - 1];
                else if (j == 0) grid[i][j] = grid[i - 1][j];
                else grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
        return grid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        UniquePaths2 uniquePaths2 = new UniquePaths2();
        System.out.println(uniquePaths2.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println(uniquePaths2.uniquePathsWithObstacles(new int[][]{{1,0}}));
    }
}
