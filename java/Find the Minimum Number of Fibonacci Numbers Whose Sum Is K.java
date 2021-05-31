class Solution {
 
    public int findMinFibonacciNumbers(int k) {
        ArrayList<Long>lis=new ArrayList<>();
        lis.add(1L);
        lis.add(1L);
        long sum=2l;
        if (k==2)return 1;

        while (sum<=k){
            long h=lis.get(lis.size()-1)+lis.get(lis.size()-2);
            lis.add(h);
            sum=h;
        }
        TreeSet<Long>set=new TreeSet<>();
        for(Long i:lis)set.add(i);

        if (set.contains(1l*k))return 1;
        int ans=1;
        sum=0;
        while (!set.isEmpty()){
            Long h=set.pollLast();
            if (h>k||h>k-sum)continue;
            sum+=h;
            if (sum==k)break;
            if (set.contains(1l*k-sum)){
                ++ans;
                break;
            }
            ++ans;
        }
        return ans;
    }
}