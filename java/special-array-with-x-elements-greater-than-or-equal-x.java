class Solution {
    
    

    int check(int[]a,int n ){

        int ans= 0;
        for(int i:a)if(i>=n)++ans;

        return ans-n;

    }

    public int specialArray(int[] nums) {

        Arrays.sort(nums);

        int start = 0 , end = nums.length;

        while(start<=end){
            int mid = start + (end-start)/2;

            int check =check(nums,mid);
            if(check==0){
                return mid;
            }else if (check>0){
                start =mid+1;
            }
            else end=mid-1;

        }

        return -1;
    }
}