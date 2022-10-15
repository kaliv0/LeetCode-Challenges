/*
    118. Pascal's triangle

    Given an integer numRows, return the first numRows of Pascal's triangle.
    In Pascal's triangle, each number is the sum of the two numbers directly above it.
 */

import java.util.Arrays;

public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        int[][] result = createTriangle(numRows);
        System.out.println(Arrays.deepToString(result));
    }

    private static int[][] createTriangle(int rowCount) {
        int[][] triangle = new int[rowCount][];
        triangle[0] = new int[]{1};

        for (int i = 1; i < rowCount; i++) {
            triangle[i] = new int[i + 1];
            // initialize first and last element of each row as 1
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                // perform simple addition of elements of above row
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        return triangle;
    }
}