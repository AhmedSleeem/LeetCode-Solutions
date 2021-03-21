class Solution {
public:
    string simplifyPath(string path) {
        stack<string> s;
        string ans;
        int n = path.size();
        for(int i=0;i<n;i++)
        {
            if(path[i]=='/')
                continue;
            string t="";
            while(i<n && path[i]!='/')
            {
                t+=path[i];
                i++;
            }
            i--;
            if(t==".") // it means we should remain in current dir
                continue; 
            if(t=="..") // it means we have to our previous dir
            {
                if(!s.empty())
                    s.pop();
                continue;
            }
            s.push(t); // if "." or ".." is not there, then we will push it into our stack
        }
        while(!s.empty())
        {
            ans = "/" + s.top() + ans; //because in our stack the name of the dir are stored in reverse order, so we are are adding our ans at back
            s.pop();
        }
        if(ans.size()==0)
            return "/";
        else
            return ans;
    }
};