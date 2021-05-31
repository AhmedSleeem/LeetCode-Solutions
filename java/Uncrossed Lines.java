class Solution {
   int ans;
    int []a;
    int n;
    HashMap<Integer,TreeSet<Integer>>map;
    int [][]mem;

    int dp(int idx,int preidx){
        if (idx>=a.length||preidx>=n) return 0;
        if (mem[idx][preidx]!=-1)return mem[idx][preidx];
        int ret=0;
        if (map.containsKey(a[idx])){
            TreeSet<Integer> integers = map.get(a[idx]);
            Integer ceiling = integers.ceiling(preidx);
            if (ceiling==null)ret=dp(idx+1,preidx);
            else{
                ret=Math.max(ret,1+dp(idx+1,ceiling+1));
                ret=Math.max(ret,dp(idx+1,preidx));
            }
        }else ret=dp(idx+1,preidx);
        
        return mem[idx][preidx]=ret;

    }
    public int maxUncrossedLines(int[] A, int[] B) {
        map=new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            TreeSet<Integer> orDefault = map.getOrDefault(B[i], new TreeSet<>());
            orDefault.add(i);
            map.put(B[i],orDefault);
        }
        ans=0;
        a=A;
        n=B.length;
        mem=new int[A.length][n];
        for (int i = 0; i < A.length; i++) Arrays.fill(mem[i],-1);
        
        return dp(0,0);
    }


}