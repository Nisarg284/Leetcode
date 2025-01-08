class Solution {
    public boolean searchMatrix(int[][] arr, int target) {

        int firstI = 0;
        int firstJ = arr.length-1;
        int mid1;


        while(firstI <= firstJ)
        {
            mid1 = (firstI+firstJ)/2;
            if(target >= arr[mid1][0] && target <= arr[mid1][arr[mid1].length-1])
            {
                int secondI = 0;
                int secondJ = arr[mid1].length-1;
                int mid2;

                while(secondI <= secondJ)
                {
                    mid2 = (secondI+secondJ)/2;
                    if(arr[mid1][mid2] == target)
                    {
                        return true;
                    }else if(target > arr[mid1][mid2])
                    {
                        secondI = mid2+1;
                    }
                    else
                    {
                        secondJ = mid2-1;
                    }
                     
                }return false;
            }else if(target < arr[mid1][0])
            {
                firstJ = mid1-1;
            }else{
                firstI = mid1+1;
            }
        }

        return false;
        
    }
}