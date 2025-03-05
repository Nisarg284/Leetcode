// class Solution {

//     static class Pair{
//             int val;
//             int idx;

//          public Pair(int val,int idx)
//         {
//             this.val = val;
//             this.idx = idx;
//         }
//     }

//     public double[] medianSlidingWindow(int[] nums, int k) {

//         PriorityQueue<Pair>lower = new PriorityQueue<>((p1,p2)->p2.val - p1.val);
//         PriorityQueue<Pair>upper = new PriorityQueue<>((p1,p2)->p1.val - p2.val);

//         int n = nums.length;
//         double[] ans = new double[n-k+1];

//         for(int i=0;i<k;i++)
//         {
//             lower.add(new Pair(nums[i],i));
//             upper.add(lower.poll());

//             if(lower.size() >= upper.size())
//             {
//                 continue;
//             }else {
//                 lower.add(upper.poll());
//             }
//         }

//         ans[0] = k%2 == 0 ?  (lower.peek().val+upper.peek().val)/2.0 : (double) lower.peek().val;

//         int j = k;
//         int i = 1;
//         int a = 1;

//         while (j<nums.length)
//         {
//             Pair p = new Pair(nums[j],j);

//             while(!lower.isEmpty() && lower.peek().idx < i)
//             {
//                 lower.remove();
//             }

//             while (!upper.isEmpty() && upper.peek().idx < i)
//             {
//                 upper.remove();
//             }

//             lower.add(p);
//             upper.add(lower.remove());

//             if(lower.size() < upper.size())
//             {
//                 lower.add(upper.remove());
//             }

//             if( lower.size() == upper.size())
//             {
//                 ans[a] = ((double) lower.peek().val + (double) upper.peek().val)/2.0;
//             }else {
//                 ans[a] = lower.peek().val;
//             }
//             a++;
//             i++;
//             j++;
//         }

//         return ans;

//     }
// }
class Solution {
public double[] medianSlidingWindow(int[] nums, int k) {
    Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
    TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
    TreeSet<Integer> right = new TreeSet<>(comparator);
    
    Supplier<Double> median = (k % 2 == 0) ?
        () -> ((double) nums[left.first()] + nums[right.first()]) / 2 :
        () -> (double) nums[right.first()];
    
    // balance lefts size and rights size (if not equal then right will be larger by one)
    Runnable balance = () -> { while (left.size() > right.size()) right.add(left.pollFirst()); };
    
    double[] result = new double[nums.length - k + 1];
    
    for (int i = 0; i < k; i++) left.add(i);
    balance.run(); result[0] = median.get();
    
    for (int i = k, r = 1; i < nums.length; i++, r++) {
        // remove tail of window from either left or right
        if(!left.remove(i - k)) right.remove(i - k);

        // add next num, this will always increase left size
        right.add(i); left.add(right.pollFirst());
        
        // rebalance left and right, then get median from them
        balance.run(); result[r] = median.get();
    }
    
    return result;
}
}