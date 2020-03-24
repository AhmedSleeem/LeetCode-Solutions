class Solution {
 public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length())return false;
        boolean [] d= new boolean[26];
     
        int[] f= new int[26];
        for (int i = 0; i < s1.length(); i++) {
            f[s1.charAt(i)-'a']++;
            d[s1.charAt(i)-'a']=true;
        }

        int l=0,r=s1.length();
        int [] f2= new int[26];
        
        for (int i = l; i <r ; i++) {
            int idx=s2.charAt(i)-'a';
            ++f2[idx];
        }
        int temp=0;
        for (int i = 0; i < 26; i++) {
            temp+=d[i]?Math.min(f[i],f2[i]):0;
        }
        if (temp==s1.length()){
            return true;
        }

        for (int i = l; r<s2.length(); i++,r++) {
            if (temp==s1.length())return true;
            temp=0;
            int idx=s2.charAt(i)-'a';
            int rrr=s2.charAt(r)-'a';
            --f2[idx];
            ++f2[rrr];
            for (int xxx = 0; xxx < 26; xxx++) {
                temp+=d[xxx]?Math.min(f[xxx],f2[xxx]):0;
            }

        }
        return temp==s1.length();
    }


}