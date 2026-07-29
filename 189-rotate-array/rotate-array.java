class Solution {

    public void reverseArray(int[]arr,int start,int end){

        while(start < end){

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {


        int n = nums.length;
        System.out.println(k%n);


        k %= n;


        // Reverse entire array
         int start = 0;
        int end = n-1;

        reverseArray(nums,start,end);

        // reverse first k elements
        start = 0;
        end = k-1;
        reverseArray(nums,start,end);

        // reverse last k elements
        start = k;
        end = n-1;

        reverseArray(nums,start,end);

        
        
    }
}