// class Solution {
//     public boolean isValidSudoku(char[][] board) {

//         HashSet<Integer> hs = new HashSet<>();

//         for(int i=0;i<board[0].length;i++)
//         {
//             for(int j=0;j<board.length;j++)
//             {
//                 if(!hs.contains(board[i][j]))
//                 {
//                     hs.add(board[i][j]);
//                 }

//             }
//         }
        
//     }
// }


class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i / 3 + b + j / 3))
                        return false;
                }
            }
        }

        return true;
    }
}

