class Solution {
      int rem;
    List<List<Integer>> result;

    void dp(int cur,int k,ArrayList<Integer>list,List<List<Integer>>d){
            if (k<0)return;
            if (k==0){
                d.add(list);
                return;
            }
        for (int i = cur+1; i <=rem; i++) {
            ArrayList<Integer>aa= new ArrayList<>(list);
            aa.add(i);
            dp(i,k-1,aa,d);
        }


    }

    public List<List<Integer>> combine(int n, int k) {
        rem=n;
        result=new ArrayList<>();
        dp(0,k,new ArrayList<>(),result);
        return result;
    }
}