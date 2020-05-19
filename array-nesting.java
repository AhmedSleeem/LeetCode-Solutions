class Solution {
     public int arrayNesting(int[] nums) {
        int max=0;

        for (int i = 0; i < nums.length; i++) {
            int idx=i,cur=0;

            if (nums[idx]!=-1) {

                while (idx>=0) {
                    
                    if (idx<0||nums[idx]==-1)break;
                    int y=idx;
                    idx=nums[y];
                    nums[y]=-1;
                    ++cur;
                    

                }
                max=Math.max(max,cur);
            }
        }

        return max;
    }
}