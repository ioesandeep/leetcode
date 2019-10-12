package medium;

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return search(matrix, 0, matrix[0].length - 1, target);
    }

    boolean search(int[][] arr, int start, int end, int target) {
        if (start < 0 || start >= arr.length || end < 0 || end >= arr[0].length) {
            return false;
        }

        if (arr[start][end] == target) {
            return true;
        }

        if (arr[start][end] > target) {
            return search(arr, start, end - 1, target);
        }

        return search(arr, start + 1, end, target);
    }
}
