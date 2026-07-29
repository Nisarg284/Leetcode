class Solution {
    public void merge(int[] arr, int m, int[] brr, int n) {


        int i = 0;
        int j = 0;
        int k = 0;

        int []ans = new int[m + n];

        while(i < m && j < n){


            if(arr[i] <= brr[j]){
                ans[k] = arr[i];
                i++;
            }else{
                ans[k] = brr[j];
                j++;
            }
            k++;
        }

        while(i < m){
            ans[k] = arr[i];
            i++;
            k++;
        }

        while(j < n){
            ans[k] = brr[j];
            j++;
            k++;
        }

        for(int l = 0;l<n+m;l++){
            arr[l] = ans[l];
        }
        
    }
}