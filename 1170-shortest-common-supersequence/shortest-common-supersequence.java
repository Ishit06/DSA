class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int dp[][]=longestCommonSubsequence(str1,str2);
        int m=dp.length;
        int n=dp[0].length;
        int i=m-1;
        int j=n-1;
        StringBuilder sb=new StringBuilder();
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
sb.append(str1.charAt(i-1));
i--;
j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                sb.append(str1.charAt(i-1));
                i--;
            }
            else{
                sb.append(str2.charAt(j-1));
                j--;
            }

        }
        while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }

    public int[][] longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m + 1][n + 1];
        dp[m][n] = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];//recur(text1,text2,i-1,j-1,dp);
                    // return dp[i][j];
                } else {
                    int case1 = dp[i - 1][j];//ecur(text1,text2,i-1,j,dp);
                    int case2 = dp[i][j - 1];//recur(text1,text2,i,j-1,dp);
                    dp[i][j] = Math.max(case1, case2);

                }
            }
        }

        return dp; //recur(text1,text2,m,n,dp);
    }
}