class Solution {
public:
    int arrangeCoins(int n) {
        
        int left=0,right=n,ans=0;
        
        while(left<=right){
            int mid = left + (right-left)/2;
            long long tmp=(mid*1ll*(mid+1)/2);
            if(tmp<=n){
                ans=mid;
                left=mid+1;
            }else right=mid-1;
        }
        
        return ans;
        
    }
};