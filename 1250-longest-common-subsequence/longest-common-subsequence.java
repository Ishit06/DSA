class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return recur(text1,text2,m,n,dp);
    }
    public int recur(String text1,String text2,int i,int j,int dp[][]){
        if(i==0 || j==0){
            dp[i][j]=0;
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(text1.charAt(i-1)==text2.charAt(j-1)){
            dp[i][j]= 1+recur(text1,text2,i-1,j-1,dp);
            return dp[i][j];
        }
        else{
           int case1=recur(text1,text2,i-1,j,dp);
            int case2=recur(text1,text2,i,j-1,dp);
            dp[i][j]= Math.max(case1,case2);
            return dp[i][j];
        }
        
    }
}