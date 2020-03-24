class Solution {
      
          int ans,s;
    int [] a;
    void dp(int cur,int sum){
        if (cur==a.length)ans=sum==s?ans+1:ans;
        else{
            dp(cur+1,sum+a[cur]);
            dp(cur+1,sum-a[cur]);
        }
    }
    public int findTargetSumWays(int[] nums, int S) {
            a=nums;
            s=S;
            dp(0,0);
            return ans;
    }
}