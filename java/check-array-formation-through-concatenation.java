class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        
        
        int n = arr.length;
        for(int e=0;e<arr.length;++e){
          
            boolean state= false;
            outer:
            for(int i = 0;i<pieces.length;++i){
               
                if(pieces[i][0]==arr[e] && pieces[i].length<=n-e){
                    int idx=e;
                   for(int element : pieces[i]){
                       if(element != arr[idx]) return false;
                       ++idx;
                   }
                    
                    state = true;
                    e=idx-1;
                    continue;
                }
            }
            if(!state)return false;
            
            
           
        }
        
        return true;
        
    }
}