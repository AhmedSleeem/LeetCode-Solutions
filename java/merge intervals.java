class Solution {
  public   int[][] merge(int[][] a) {
      if(a==null||a.length==0)return new int[][]{};
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0])return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        int n=a.length;
        ArrayList<Pair> ans= new ArrayList<>();
        Pair temp = new Pair(a[0][0],a[0][1]);
        for (int i = 1; i <n ; i++) {
            if (temp.second>=a[i][0]){
                temp=new Pair(Math.min(temp.first,a[i][0]),Math.max(temp.second,a[i][1]));
            }
            else{
                ans.add(temp);
                    temp=new Pair(a[i][0],a[i][1]);
            }
        }
        ans.add(temp);

        int [][]d= new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            d[i]=new int[]{ans.get(i).first,ans.get(i).second};
        }
        return d;
    }
}
class Pair  {
    int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }




}