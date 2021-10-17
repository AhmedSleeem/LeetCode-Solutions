class Solution {
    public int maxAbsoluteSum(int[] nums) {
        
        int firstAns = 0,sum=0;
        
        for(int num :nums){
            sum+=num;
            if(sum>0)firstAns=Math.max(sum,firstAns);
            else sum=0;
        }
        
        for(int i=0;i<nums.length;++i)nums[i]*=-1;
        
        int secondAns = 0;
        sum=0;
        
        for(int num :nums){
            sum+=num;
            if(sum>0)secondAns=Math.max(sum,secondAns);
            else sum=0;
        }
        
        return Math.max(secondAns,firstAns);
        
        
    }
}