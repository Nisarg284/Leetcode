class Solution {
    public int[] findEvenNumbers(int[] digits) 
    {
        // store size of digits array in variable
        int n = digits.length;

        // create new array for storing even numbers
     // size is 450 because we only store 3 digits even numbers so 3 digits even numbers stars from 100 to 999
        ArrayList<Integer> list = new ArrayList<>();

        // counting variable for storing even numbers into array
        // index variable
        int count = 0;

        // Create HashMap
        HashMap<Integer,Integer> hm = new HashMap<>();

        // storing key & value into Hashmap from digits array
        for(int i=0;i<n;i++)
        {
            hm.put(digits[i],hm.getOrDefault(digits[i],0)+1);
        }

        // iterate 100 to 999
        for (int i=100;i<999;i+=2)
        {
            int x=i;
            // find last digit of x
            // store that digit into

            // last digit of i
            int a =x%10;
            x/=10; // 1`s place digit

            // second last digit of i
            int b= x%10;
            x/=10;  // 10`s place digit

            // first digit of i
            int c = x;  // 100`s place digit

            // check map contains a or not
            if(hm.containsKey(a))
            {
                hm.put(a,hm.get(a)-1);
                if(hm.get(a) == 0)
                {
                    hm.remove(a);
                }

                if(hm.containsKey(b))
                {
                    hm.put(b,hm.get(b)-1);
                    if(hm.get(b)==0)
                    {
                        hm.remove(b);
                    }

                    if(hm.containsKey(c))
                    {
                        list.add(i);
                        hm.put(a,hm.getOrDefault(a,0)+1);
                        hm.put(b,hm.getOrDefault(b,0)+1);
                    }
                    else{
                         hm.put(a,hm.getOrDefault(a,0)+1);
                        hm.put(b,hm.getOrDefault(b,0)+1);
                        continue;
                    }

                }
                else{
                    hm.put(a,hm.getOrDefault(a,0)+1);
                    continue;
                }
            }
            else{
                continue;
            }

           
        
        }
         int[] ans = new int[list.size()];

            for(int z=0;z<list.size();z++)
            {
                ans[z] = list.get(z);
            }
    return ans;
}
}