class CombinationIterator {
    
    
    
    
    
    char[]a;
    TreeSet<String>set;
    void backtrack(StringBuilder s,int  n,int idx){
        if(s.length()==n){
            set.add(s.toString());
            return ;
        }
        StringBuilder tmp=new StringBuilder(s);
        for(int i=idx;i<a.length;++i){
            if(tmp.length()==0||tmp.charAt(tmp.length()-1)<a[i]){
            tmp.append(a[i]);
            backtrack(tmp,n,idx+1);
            tmp.deleteCharAt(tmp.length()-1);
        }
        }
    }

    public CombinationIterator(String c, int n) {
            a=c.toCharArray();
        Arrays.sort(a);
        set=new TreeSet();
        backtrack(new StringBuilder(),n,0);
        
    }
    
    public String next() {
        return set.pollFirst();
        
    }
    
    public boolean hasNext() {
        return !set.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */