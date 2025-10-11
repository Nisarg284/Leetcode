class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        

        int i = 0;
        int j = 0;

        Arrays.sort(players);
        Arrays.sort(trainers);

        int n = players.length;
        int m = trainers.length;

        int count = 0;

        while( i < n && j < m)
        {
            if(players[i] <= trainers[j])
            {
                i++;
                count++;
            }
            j++;
        }

        return count;
    }
}