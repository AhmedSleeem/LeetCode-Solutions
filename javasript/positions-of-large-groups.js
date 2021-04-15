/**
 * @param {string} s
 * @return {number[][]}
 */
var largeGroupPositions = function(s) {
    
    let cur=0,start=0;
    let ans = [];
    for(let index = 1;index<s.length;++index,start++){
        if(s[index]==s[index-1]){
            ++cur;
        }else{
            if(cur>=2){
                ans.push([start-cur,start]);
            }
            
            cur=0;
        }
    }
    if(cur>=2) ans.push([start-cur,start]);
    
    return ans;
    
    
};