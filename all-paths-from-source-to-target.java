class Solution {
    
    List<List<Integer>>ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans=new ArrayList();
        List<Integer>list=new ArrayList();
        list.add(0);
        dfs(list,graph,0);
        return ans;
    }
    
    public void dfs(List<Integer>list,int[][]graph,int des){
         List<Integer>tmp=new ArrayList(list);
        if(des==graph.length-1){
            
            ans.add(tmp);
            return; 
        }
       
        
        for(int i:graph[des]){
            
            tmp.add(i);
            dfs(tmp,graph,i);
            tmp.remove(tmp.size()-1);
        }
    }
}