class Solution {
   public List<List<Integer>> subsets(int[] a) {

        ArrayList<List<Integer>>ans=new ArrayList<>();
        for (int i = 0; i < 1<<a.length; i++) {
            ArrayList<Integer>temp=new ArrayList<>();
            for (int k = 0; k < a.length; k++) {
                if ((i&(1<<k))>0)temp.add(a[k]);
            }
            ans.add(temp);
        }
        return ans;

    }
}