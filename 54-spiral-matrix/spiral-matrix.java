class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List <Integer> ans  = new ArrayList<>();
int starRow = 0;
        int starCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;
        while (starRow <= endRow && starCol <= endCol) {

            // left to right
            for (int j = starCol; j <= endCol; j++)
            {
                // System.out.print(spiral[starRow][j] + " ");
                ans.add(matrix[starRow][j]);
            }
            

            // top to bottom
            for (int i = starRow + 1; i <= endRow; i++)
            {
                // System.out.print(spiral[i][endCol] + " ");
                ans.add(matrix[i][endCol]);
            }

            // rigth to left
            for (int j = endCol - 1; j >= starCol; j--)
            {
                if(starRow==endRow)
                {
                    break;
                }
                // System.out.print(spiral[endRow][j] + " ");

                ans.add(matrix[endRow][j]);
            }

            // bottom to up
            for (int i = endRow - 1; i >= starRow + 1; i--)
            {
                if(starCol==endCol)
                {
                    break;
                }
                // System.out.print(spiral[i][starCol] + " ");
                ans.add(matrix[i][starCol]);
            }
            starRow++;
            starCol++;
            endRow--;
            endCol--;
        }

        return ans;
        
    }
}