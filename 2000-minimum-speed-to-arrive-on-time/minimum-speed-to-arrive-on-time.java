class Solution {

    public static boolean isValid(int[] dist, double hour, int mid, int n) {
        double currHrs = 0;

        for (int i = 0; i < n; i++) {
            double d = dist[i] * 1.0 / mid;

            if (i != n - 1) {
                currHrs += Math.ceil(d);
            } else {
                currHrs += d;
            }

            if (currHrs > hour) {
                return false;
            }

        }

        // System.out.println(currHrs + " ");

        return currHrs <= hour;
    }

    public int minSpeedOnTime(int[] dist, double hour) {

        int n = dist.length;

        int i = 1;
        // int j = Arrays.stream(dist).sum();
        int j = (int)1e7;

        int ans = -1;

        while (i <= j) {
            int mid = (i + j) / 2;

            if (isValid(dist, hour, mid, n)) {
                ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return ans;

    }
}