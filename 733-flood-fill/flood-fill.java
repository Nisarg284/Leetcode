class Solution {


    public static void helper(int row,int col,int srcColor,int color,int[][]image,int n,int m){

        if(row < 0 || col < 0 || row >= n || col >= m || image[row][col] == color){
            return;
        }

        if(image[row][col] == srcColor){
            image[row][col] = color;
            helper(row-1,col,srcColor,color,image,n,m);
            helper(row,col+1,srcColor,color,image,n,m);
            helper(row+1,col,srcColor,color,image,n,m);
            helper(row,col-1,srcColor,color,image,n,m);
        }
        

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {


        int srcColor = image[sr][sc];

        int n = image.length;
        int m = image[0].length;

        helper(sr,sc,srcColor,color,image,n,m);

        return image;
        
    }
}