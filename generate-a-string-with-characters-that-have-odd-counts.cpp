class Solution {
public:
    string generateTheString(int n) {
        string g="";
        if(n&1){
            if(n==1)return "a";
            else if(n==3)return "abc";
            else{
                
                for(int i=0;i<n-2;++i)g+="a";
                g+='b';
                g+='c';
            }
        }else{
            if(n==2)return "ab";
            for(int i=0;i<n-1;++i)g+="a";
            g+="b";
            
        }
        return g;
        
    }
};	