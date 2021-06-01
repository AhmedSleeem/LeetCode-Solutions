/**
 * @param {number[]} arr
 * @param {number[][]} pieces
 * @return {boolean}
 */
var canFormArray = function(arr, pieces) {
      const n = arr.length;
        for(let e=0;e<arr.length;++e){
          
            let state= false;
            outer:
            for(let i = 0;i<pieces.length;++i){
               
                if(pieces[i][0]==arr[e] && pieces[i].length<=n-e){
                    let idx=e;
                   for(let element of pieces[i]){
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
        
};