class Solution {
    char[]a;
    public int backtrack(StringBuilder tmp,int n){
        if(tmp.length()==n)return 1;
        
        int ans=0;
        for(char i:a){
            if(tmp.length()==0||i>=tmp.charAt(tmp.length()-1)){
                tmp.append(i);
                ans+=backtrack(tmp,n);
                tmp.deleteCharAt(tmp.length()-1);
            }
        }
        return ans;
    }
    public int countVowelStrings(int n) {
        
        a="aeiou".toCharArray();
       return  backtrack(new StringBuilder(),n);
        
        
    }
}