class Solution {
    public int minCostToMoveChips(int[] chips) {
        HashMap<Integer,Integer>map= new HashMap<>();
        HashSet<Integer>set= new HashSet<>();
        for (int i = 0; i < chips.length; i++) map.merge(chips[i],1,Integer::sum);

        int ans=Integer.MAX_VALUE;
        for (int i = 0; i < chips.length; i++) {
            if (!set.contains(chips[i])){
                set.add(chips[i]);
                int cnt=0;
                for(int element:map.keySet()){
                    if (element==chips[i])continue;
                    cnt+=(Math.abs(chips[i]-element))%2==0?0:map.get(element);
                }
                ans=Math.min(ans,cnt);
            }
        }
        return ans;
    }
}