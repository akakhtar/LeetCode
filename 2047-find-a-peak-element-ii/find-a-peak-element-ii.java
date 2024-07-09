class Solution {
    public int[] findPeakGrid(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int low = 0;
        int high = r - 1;

        while (low <= high) {
            int midRow = low + (high - low) / 2;
            int maxCol = 0;

           
            for (int j = 0; j < c; j++) {
                if (matrix[midRow][j] > matrix[midRow][maxCol]) {
                    maxCol = j;
                }
            }

           
            boolean isPeak = true;
            if (midRow > 0 && matrix[midRow][maxCol] < matrix[midRow - 1][maxCol]) {
                isPeak = false;
            }
            if (midRow < r - 1 && matrix[midRow][maxCol] < matrix[midRow + 1][maxCol]) {
                isPeak = false;
            }

            if (isPeak) {
                return new int[]{midRow, maxCol};
            } else if (midRow > 0 && matrix[midRow][maxCol] < matrix[midRow - 1][maxCol]) {
                high = midRow - 1;
            } else {
                low = midRow + 1;
            }
        }

        return new int[]{-1, -1};  
    }
}
