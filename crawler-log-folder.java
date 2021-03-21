class Solution {
    public int minOperations(String[] logs) {
        
        int stack=0;
        for(String s:logs){
            if(s.equals("../")){
		if(stack>0)--stack;
	    }
            else if(!s.equals("./"))++stack;
        }
        
        return stack;
        
    }
}