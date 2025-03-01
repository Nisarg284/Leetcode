class Solution:
    def applyOperations(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)-1):
            if nums[i]==nums[i+1]:
                nums[i]*=2
                nums[i+1]=0
                i+=1
        
        l=[0]*len(nums)
        index=0
        for i in range(len(nums)):
            if nums[i]>0:
                l[index]=nums[i]
                index+=1
        return l