package space.kuzznya.leetcode.task54;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int leftBound = 0;
        int rightBound = matrix[0].length - 1;

        int topBound = 0;
        int bottomBound = matrix.length - 1;

        List<Integer> result = new ArrayList<>();

        while (leftBound <= rightBound && topBound <= bottomBound) {
            for (int i = leftBound; i <= rightBound; i++) {
                result.add(matrix[topBound][i]);
            }

            for (int i = topBound + 1; i <= bottomBound; i++) {
                result.add(matrix[i][rightBound]);
            }

            if (leftBound < rightBound && topBound < bottomBound) {
                for (int i = rightBound - 1; i >= leftBound; i--) {
                    result.add(matrix[bottomBound][i]);
                }
                for (int i = bottomBound - 1; i > topBound; i--) {
                    result.add(matrix[i][leftBound]);
                }
            }

            leftBound++;
            rightBound--;
            topBound++;
            bottomBound--;
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        printMatrix(matrix);
        System.out.println(spiralMatrix.spiralOrder(matrix));

        matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        printMatrix(matrix);
        System.out.println(spiralMatrix.spiralOrder(matrix));

        matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
        printMatrix(matrix);
        System.out.println(spiralMatrix.spiralOrder(matrix));

        matrix = new int[][]{{1}};
        printMatrix(matrix);
        System.out.println(spiralMatrix.spiralOrder(matrix));

        matrix = new int[][]{{1,2},{3,4}};
        printMatrix(matrix);
        System.out.println(spiralMatrix.spiralOrder(matrix));
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
