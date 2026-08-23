class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int lis[]=new int[n];
        int maxlen=1;
        Arrays.fill(lis,1);
        for(int i=1;i<n;i++){
            for(int p=0;p<i;p++){
                if(nums[p]<nums[i]){
                    lis[i]=Math.max(lis[i],1+lis[p]);
                }
                
            }
            if(lis[i]>maxlen){
                maxlen=lis[i];
            }

        }
        return maxlen;
    }
}