class Solution {
    // public int maxOperations(int[] arr, int k) {

    //     HashMap<Integer,Integer> hm = new HashMap<>();

    //     for(int i=0;i<arr.length;i++)
    //     {
    //         hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
    //     }

    //     int need =0;
    //     int count = 0;

    //     for(int i=0;i<arr.length;i++)
    //     {
    //         need = k-arr[i];
    //         if(hm.containsKey(need) && hm.containsKey(arr[i]))
    //         {
    //             if(hm.get(arr[i]) == 1)
    //             {
    //                 hm.remove(arr[i]);
    //             }else{
    //                 hm.put(arr[i],hm.get(arr[i])-1);
    //             }
    //             if(hm.get(need) == 1){
    //                 hm.remove(need);
    //             }else{
    //                 hm.put(need,hm.get(need)-1);
    //             }
    //             count++;
    //         }
    //     }

    //     return count;




    //     // int i=0;
    //     // int j= nums.length-1;
    //     // int operations = 0;

    //     // while(i<j)
    //     // {
    //     //     int sum = nums[i] + nums[j];
    //     //     if(sum == k)
    //     //     {
    //     //         i++;
    //     //         j--;
    //     //         operations++;
    //     //     }else
    //     //     {
    //     //         i++;
    //     //         j--;
    //     //     }
    //     // }
    //     // return operations;
    // }


    public static int maxOperations(int[] arr, int k) {

    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
        hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
    }

    int count = 0;

    for (int i = 0; i < arr.length; i++) {
        int need = k - arr[i];
        if (hm.containsKey(need) && hm.get(need) > 0 && hm.get(arr[i]) > 0) {
            if (arr[i] == need && hm.get(arr[i]) < 2) {
                continue;
            }
            hm.put(arr[i], hm.get(arr[i]) - 1);
            hm.put(need, hm.get(need) - 1);
            count++;
        }
    }

    return count;
}
}