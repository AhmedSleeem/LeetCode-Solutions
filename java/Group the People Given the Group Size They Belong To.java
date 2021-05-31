class Pair  {
    int first, second,third;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public Pair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}





class Solution {
   public static List<List<Integer>> groupThePeople(int[] a) {
        List<List<Integer>>ans= new ArrayList<>();
        ArrayList<Pair>t= new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            t.add(new Pair(i,a[i]));
        }
        Collections.sort(t, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.second-o2.second;
            }
        });
        BitSet visited=new BitSet(a.length);
        for (int i = 0; i < a.length; i++) {
            if (t.get(i).second==1){
                List<Integer>sss=new ArrayList<>();
                sss.add(t.get(i).first);
                visited.set(t.get(i).first);

                ans.add(sss);
            }else break;
        }
        List<Integer> temp=new ArrayList<>();



       
        int size=0;
        outer:
        for (int i = 0; i <a.length; i++) {
            if (visited.get(t.get(i).first))continue;

            size=t.get(i).second;

            for (int j = i; j < a.length; j++) {
                Pair d=t.get(j);
                if (!visited.get(d.first)){
                    if (temp.size()<size){
                        temp.add(d.first);
                        visited.set(d.first);
                    }else{
                        ans.add(temp);
                        temp=new ArrayList<>();
                       i--;
                       break ;
                    }
                }
            }
            if (temp.size()!=0)ans.add(temp);

        }

        return ans;

    }

}