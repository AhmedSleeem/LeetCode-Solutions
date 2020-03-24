class Solution {
    public String reorganizeString(String S) {

        char[] a= S.toCharArray();
        PriorityQueue<Integer> [] s= new PriorityQueue[26];
        for (int i = 0; i < 26; i++) {
            s[i]=new PriorityQueue<>();
        }
        for (int i = 0; i < a.length; i++) {
            s[a[i]-'a'].add(i);
        }
     
        StringBuilder ans=new StringBuilder();
        int max=0,idx=0;
        for (int j = 0; j < 26; j++) {
            if (s[j].size()>max&&s[j].size()>0){
                max=s[j].size();
                idx=j;
            }
        }
        ans.append((char)(idx+'a'));
        s[idx].poll();
        int cur=a.length-1;
        while (cur>0){
            int c=ans.charAt(ans.length()-1)-'a';
            max=0;
            idx=-1;
            for (int j = 0; j < 26; j++) {
                if (s[j].size()>max&&s[j].size()>0&&j!=c){
                    max=s[j].size();
                    idx=j;
                }
            }
            if (idx==-1)return "";
            ans.append((char)(idx+'a'));
            s[idx].poll();
            --cur;
        }
        return ans.toString();        
    }
}