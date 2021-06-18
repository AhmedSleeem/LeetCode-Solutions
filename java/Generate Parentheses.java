class Solution {
    
  
    boolean checkValidity(String s){
        int tmp =0;
        for(char ch : s.toCharArray()){
            if(ch== '(')++tmp;
            else {
                if(tmp == 0)return false;
                else --tmp;
            }
        }
        return tmp==0;
    }
    
    public List<String> generateParenthesis(int n) {
        
        List<String> ans= new ArrayList();
        
        class Pair{
            String text;
            int remainOpen;
            int close;
            
            Pair(String x,int y,int z){
                text = x;
                remainOpen = y ;
                close=z;
            }
            
        }
        
        LinkedList<Pair> queue = new LinkedList();
        
        queue.add(new Pair("(",n-1,n));
        
        
        while(!queue.isEmpty()){
            
           Pair pair =  queue.pollFirst();
            
            // System.out.println(pair.text);
            
            if(pair.text.length() == n*2 &&checkValidity(pair.text)){
                ans.add(pair.text);
                continue;
            }
            
            StringBuilder tmp = new StringBuilder(pair.text);
            
            if(pair.remainOpen > 0 ){
                
                tmp.append('(');
                queue.add(new Pair(tmp.toString(),pair.remainOpen-1,pair.close));
                tmp.deleteCharAt(tmp.length()-1);
                
            }
            if(pair.close>0){
                tmp.append(')');
                queue.add(new Pair(tmp.toString(),pair.remainOpen,pair.close-1));
            }
            
        }
        return ans;
        
    }
}