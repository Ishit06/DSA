class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder(s);
        return longestCommonSubsequence(s,sb.reverse().toString());
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int prev[]=new int[n+1];
        prev[n]=0;
        for(int i=1;i<m+1;i++){
            int curr[]=new int[n+1];
            for(int j=1;j<n+1;j++){
                 if(text1.charAt(i-1)==text2.charAt(j-1)){
            curr[j]= 1+ prev[j-1] ;//recur(text1,text2,i-1,j-1,dp);
           // return dp[i][j];
        }
        else{
           int case1= prev[j] ;//ecur(text1,text2,i-1,j,dp);
            int case2=   curr[j-1];//recur(text1,text2,i,j-1,dp);
            curr[j]= Math.max(case1,case2);
            
        }
            }
            prev=curr;
        }
       
        return prev[n]; //recur(text1,text2,m,n,dp);
    }
    
    
   
}