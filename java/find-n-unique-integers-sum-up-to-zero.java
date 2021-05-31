class Solution {
    public int[] sumZero(int n) {
        int []ans= new int[n];
        
        if(n==1)return new int[]{0};
        else if(n%2==1){
            
            ans[0]=7000;
            ans[1]=-4000;
            ans[2]=-3000;
            
            int i=3,num=1;
            while(i<n){
                ans[i++]=num;
                ans[i++]=(0-num);
                
                ++num;
            }
        }else{
                int i=0,num=1;
            while(i<n){
                ans[i++]=num;
                ans[i++]=(0-num);
                
                ++num;
            }
        }
        
      return ans;  
    }
}