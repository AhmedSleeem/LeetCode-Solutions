class Solution {
   
            static class Pair{
                String word;
                int currentDepth;

                public Pair(String word, int currentDepth) {
                    this.word = word;
                    this.currentDepth = currentDepth;
                }
            }

    public int minMutation(String begin, String end,String[] wordList) {

                String beginWord=begin.toLowerCase();
                String endWord=end.toLowerCase();
        HashSet<String>set=new HashSet<>();
        for(String u:wordList)set.add(u.toLowerCase());
        LinkedList<Pair>queue=new LinkedList<>();
        queue.add(new Pair(beginWord,0));
        if (!set.contains(endWord))return -1;

        HashSet<String>taken=new HashSet<>();
        taken.add(beginWord);

        int ans=-1;
        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            System.out.println(pair.word);

            if (pair.word.equals(endWord)){
                ans=pair.currentDepth;
                break;
            }
            for (int i = 0; i < pair.word.length(); i++) {

                    for (int j = 0; j < 26; j++) {
                        StringBuilder temp=new StringBuilder(pair.word);

                           temp.setCharAt(i,(char)(j+'a'));
                           if (set.contains(temp.toString()) &&!taken.contains(temp.toString())) {
                               queue.add(new Pair(temp.toString(), pair.currentDepth + 1));
                               taken.add(temp.toString());
                           }
                               temp.setCharAt(i,pair.word.charAt(i));

                }
            }
        }
       // System.out.println(taken);

        return ans;

    }
}