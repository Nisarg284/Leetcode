class Solution {
    public int search(int[] arr, int target) {

        int n = arr.length;
        int i = 0;
        int j = n-1;

        while(i <= j){

            int mid = i + (j-i) / 2;
            if(arr[mid] == target){
                return mid;
            }

            System.out.println(" mid --------->"+mid+" , value : "+arr[mid]);

            if(arr[mid] >= arr[i] ){
                System.out.print("first: ");
                System.out.println(arr[mid] +" > "+ arr[i]);

                if(target >= arr[i] && target < arr[mid]){
                    j = mid-1;
                }else{
                    i = mid+1;
                }
            }else{
                System.out.print("second: ");
                System.out.println(arr[mid]+ " < " +arr[i]);

                if(target <= arr[j] && target > arr[mid]){
                    i = mid+1;
                }else{
                    j = mid-1;
                }
            }
        }

        return -1;
        
    }
}