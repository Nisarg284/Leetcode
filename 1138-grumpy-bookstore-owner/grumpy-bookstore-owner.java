class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        // count unsatisfied customers of first window
        int unsatisfiedCount = 0;
        int idx = 0;

        for(int i = 0;i<minutes;i++)
        {
            if(grumpy[i] == 1)
            {
                unsatisfiedCount+=customers[i];
            }
        }

        // window variables
        int i=1;
        int j=minutes;

        int count = unsatisfiedCount;

        while(j<customers.length)
        {
            if(grumpy[i-1] == 1)
            {
                count -= customers[i-1];
            }

            if(grumpy[j] == 1)
            {
                count += customers[j];
            }

            if(count > unsatisfiedCount)
            {
                unsatisfiedCount = count;
                idx = i;
            }
            i++;
            j++;
        }


        // modification in array
        for(int k = idx;k<idx+minutes;k++)
        {
            if(grumpy[k] == 1)
            {
                grumpy[k] = 0;
            }
        }

        // count satisfied custermers after modification
        int maxSatisfaction = 0;

        for(int k = 0;k<customers.length;k++)
        {
            if(grumpy[k] == 0)
            {
                maxSatisfaction+= customers[k];
            }
        }

        return maxSatisfaction;


        
    }
}