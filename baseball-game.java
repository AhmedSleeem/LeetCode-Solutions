class Solution {
    public int calPoints(String[] ops) {
        
        Stack<Integer> stk = new Stack();
        
        for(String s : ops){
            if((s.charAt(0)>='0'&&s.charAt(0)<='9')||(s.charAt(0)=='-')){
                stk.push(Integer.parseInt(s));
            }else if(s.equals("+")){
                int y=stk.pop();
                int y1=stk.pop();
                    stk.push(y1);
                stk.push(y);
                stk.push(y+y1);
            }else if(s.equals("D")){
                    stk.push(stk.peek()*2);
            }else if(s.equals("C")){
                    stk.pop();
            }
             System.out.println(stk);
        }
       
        
        int ans=0;
        while(!stk.isEmpty())ans+=stk.pop();
        
        return ans;
        
    }
}