class Solution {
       List<String>ans;
    int rem;

    void backtrack(int opening,int closing , StringBuilder s,List<String>result){
        if (opening>   rem||closing> rem||closing>opening)return;
        if (opening==closing){
           if(rem==closing&&closing>0){      
               result.add(s.toString());
                return;
           }
        }
    
       
        if(opening<rem) {
            StringBuilder s1=new StringBuilder(s.toString());
            backtrack(opening+1,closing,s1.append("("),result);
            
        }
         if(closing<rem) {
              StringBuilder s1=new StringBuilder(s.toString());
             backtrack(opening,closing+1,s1.append(')'),result);
         }
    }


    public List<String> generateParenthesis(int n) {
        rem=n;
        ans=new ArrayList<>();
        backtrack(0,0, new StringBuilder(),ans);
        return ans;
    }
}