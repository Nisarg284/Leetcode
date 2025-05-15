class Solution {
    public int countPrimes(int n) {

        if(n<=2)
        {
            return 0;
        }

        if(n == 3)
        {
            return 1;
        }

        
        // boolean[] composite = new boolean[n];
        // Arrays.fill(composite, true);

        // composite[0] = false;



        // for(int i = 2;i<n;i+=2)
        // {
        //     composite[i] = false;
        // }

        // composite[2] = true;

        // for(int i = 3;i<Math.sqrt(n);i+=2)
        // {
        //     // System.out.println();
        //     if(!composite[i])
        //     {
        //         continue;
        //     }
        //     // System.out.print(i+" : ");
        //     for(int j = i*2;j<n;j+=i)
        //     {
        //         composite[j] = false;
        //     }
        //     // System.out.println();
        // }

        // int count = 0;

        // for(int i = 2;i<n;i++)
        // {
        //     if(composite[i])
        //     {
        //         System.out.print(i+" ");
        //         count++;
        //     }
        // }
        // // System.out.println();
        // return count;



        boolean[] isPrime = new boolean[n];
    Arrays.fill(isPrime, true);

    isPrime[0] = false;
    isPrime[1] = false;

    for (int i = 2; i * i < n; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
    }

    int count = 0;
    for (int i = 2; i < n; i++) {
        if (isPrime[i]) {
            // System.out.print(i + " ");
            count++;
        }
    }

    // System.out.println();
    return count;
    }
}