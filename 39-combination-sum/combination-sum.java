class Solution {


    public static void helper(int idx,List<Integer> subAns,List<List<Integer>> ans,int[] candidates, int target){

        if(target == 0){
            ans.add(new ArrayList<>(subAns));
            return;
        }

        if(idx >= candidates.length || target < 0){
            return;
        }

        for(int i = idx;i<candidates.length;i++){

            if(target >= candidates[i]){
                subAns.add(candidates[i]);
                System.out.println(subAns);
                helper(i,subAns,ans,candidates,target-candidates[i]);
                subAns.removeLast();
            }
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subAns = new ArrayList<>();

        int idx = 0;
        
        helper(idx,subAns,ans,candidates,target);

        return ans;
        
    }
}