class Solution {
      ArrayList<Integer>[]graph;
    boolean ans;
    int[]color;
    
    
    boolean bipartite(int node){
        boolean state=true;
        for (int child :graph[node]) {
            if (color[child]==0){
                color[child]=1-color[node];
               state&=bipartite(child);
            }else {
                if (color[child]==color[node]){
                    state=false;
                    break;
                }
            }
        }
        return state;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        graph=new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i]=new ArrayList<>();
        for (int i = 0; i < dislikes.length; i++) {
            graph[dislikes[i][0]-1].add(dislikes[i][1]-1);
            graph[dislikes[i][1]-1].add(dislikes[i][0]-1);
        }
        color=new int[n];
      
        boolean ans=true;
        for (int i = 0; i < n; i++) {
            if (color[i]==0)ans&=bipartite(i);
        }
        return ans;
    }
}