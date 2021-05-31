
class Pair  {
    int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;

    }




}

class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        ArrayList<Pair>ans= new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans.add(new Pair(i,j));
            }
        }

        Collections.sort(ans, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int f=Math.abs(o1.first-r0)+Math.abs(o1.second-c0);
                int s=Math.abs(o2.first-r0)+Math.abs(o2.second-c0);
                if (s==f){
                    if (o1.first==o2.first)return o1.second-o2.second;
                    return o1.first-o2.first;
                }
                return f-s;
            }
        });
        
        int[][]res= new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            res[i]=new int[]{ans.get(i).first,ans.get(i).second};
        }
        return res;

    }
}