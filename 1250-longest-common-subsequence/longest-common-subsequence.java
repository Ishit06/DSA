class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int dp[][]=new int[m+1][n+1];
        dp[m][n]=0;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                 if(text1.charAt(i-1)==text2.charAt(j-1)){
            dp[i][j]= 1+ dp[i-1][j-1] ;//recur(text1,text2,i-1,j-1,dp);
           // return dp[i][j];
        }
        else{
           int case1= dp[i-1][j] ;//ecur(text1,text2,i-1,j,dp);
            int case2=   dp[i][j-1];//recur(text1,text2,i,j-1,dp);
            dp[i][j]= Math.max(case1,case2);
            
        }
            }
        }
        return dp[m][n]; //recur(text1,text2,m,n,dp);
    }
   
      
        
    
}