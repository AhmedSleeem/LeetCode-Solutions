class Solution {
    int [] []a;
    boolean [][]mem;
    int backtrack(int r,int c,int sum){
        if (r<0||c<0||r>=a.length||c>=a[0].length)return 0;
        if (a[r][c]==0)return sum;
        if (mem[r][c])return 0;
        mem[r][c]=true;
        int ans=Math.max(backtrack(r+1,c,a[r][c]+sum),backtrack(r-1,c,a[r][c]+sum));
        ans=Math.max(backtrack(r,c-1,a[r][c]+sum),Math.max(ans,backtrack(r,c+1,a[r][c]+sum)));
        mem[r][c]=false;
        return ans;
    }
    public int getMaximumGold(int[][] aa) {
        a=aa;
        int ans=0;
        mem=new boolean[a.length][a[0].length];
        for (int i = 0; i < aa.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                ans=Math.max(backtrack(i,j,0),ans);
            }
        }
        return ans;
    }
}