class Solution {
public:
    long long minCost(vector<int>& arr, vector<int>& brr, long long k) {
        //Don't use k...
        long long ans=0;
        for(int i=0; i<arr.size(); i++) ans+=abs(arr[i]-brr[i]);

        //Use K once...
        sort(arr.begin(), arr.end());
        sort(brr.begin(), brr.end());
        long long ans2=k;
        for(int i=0; i<arr.size(); i++) ans2+=abs(arr[i]-brr[i]);
        return min(ans, ans2);
        
    }
};