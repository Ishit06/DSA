class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int prev[] = new int[amount + 1];
        for (int a = 0; a < amount + 1; a++) {
            if (a % coins[0] == 0) {
                prev[a] = 1;
            } else {
                prev[a] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            int curr[] = new int[amount + 1];
            for (int j = 0; j < amount + 1; j++) {
                int pick =0;
                if (j >= coins[i]) {
                    pick =  curr[j - coins[i]];
                }
                int Nopick = prev[j];
                curr[j] = pick + Nopick;
            }
            prev = curr;
        }
       
        return prev[amount];

    }
}

    
