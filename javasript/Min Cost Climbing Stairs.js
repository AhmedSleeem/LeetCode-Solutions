/**
 * @param {number[]} cost
 * @return {number}
 */

let mem = [];
 
    
    function solve( idx, arr){
        if(idx>=arr.length)return 0;
        if(mem[idx]!=-1)return mem[idx];
        
        let ans= arr[idx]+solve(idx+1,arr);
        ans=Math.min(ans,arr[idx]+solve(idx+2,arr));
        
        return mem[idx]=ans;
        
    }


var minCostClimbingStairs = function(cost) {
        
    for(let i=0;i<cost.length;++i)mem[i]=-1;
        return Math.min(solve(0,cost),solve(1,cost));
};


   
   
        
      
        
    
