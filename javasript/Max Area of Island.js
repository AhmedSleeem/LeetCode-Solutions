/**
 * @param {number[][]} grid
 * @return {number}
 */

let dx = [1,-1,0,0];
let dy = [0,0,1,-1];
let R=0,c=0;

 function dfs (x,y,gr){
     if(x>=R||x<0||y>=C||y<0 || gr[x][y]!=1 )return 0;
     
     gr[x][y]=2;
     
     let ans = 1;
     for(let i=0;i<4;++i){
         ans += dfs(x+dx[i],y+dy[i],gr);
     }
     
     return ans;
    
};
var maxAreaOfIsland = function(grid) {
    R = grid.length;
    C= grid[0].length;
    
    let ans = 0;
    for(let row =0;row<R;++row){
        for(let col=0; col<C;++col){
            if(grid[row][col]==1)ans=Math.max(ans,dfs(row,col,grid));
        }
    }
    return ans;
    
};