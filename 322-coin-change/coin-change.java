class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int prev[] = new int[amount + 1];
        for (int a = 0; a < amount + 1; a++) {
            if (a % coins[0] == 0) {
                prev[a] = a / coins[0];
            }
            else{
                prev[a]=(int)(1e9);
            }
        }

        for(int i=1;i<n;i++){
            int curr[]=new int[amount+1];
            for(int j=0;j<amount+1;j++){
                int pick=(int)(1e9);
                if(j>=coins[i]){
                    pick=1+curr[j-coins[i]];
                }
                int Nopick=prev[j];
                curr[j]=Math.min(pick,Nopick);
            }
            prev=curr;
        }
        if (prev[amount]== (int) (1e9)) {
            return -1;
        }
        return prev[amount];
    
    }

}