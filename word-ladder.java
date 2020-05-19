class Solution {
     static class Pair{
        String word;
        int currentDepth;

        public Pair(String word, int currentDepth) {
            this.word = word;
            this.currentDepth = currentDepth;
        }
    }
        
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


	//use Hashset O(1) instead of List O(N) because we make search in bfs and we want to minimize time 
        HashSet<String>set=new HashSet<>();
        for(String u:wordList)set.add(u);

        LinkedList<Pair>queue=new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        if (!set.contains(endWord))return 0;
        

	/*
	used to make sure that every transition must taked at most one if 
	we delete it we dont know when we say no answer because the LinkedList will never be empty

	*/  
        HashSet<String>taken=new HashSet<>();
        

        int ans=0;

	//BSF
        while (!queue.isEmpty()){
            Pair pair = queue.poll();

            if (pair.word.equals(endWord)){
                ans=pair.currentDepth;
                break;
            }
            for (int i = 0; i < pair.word.length(); i++) {
			
			
               		//we try all posibilities to change one char at time
                    for (int j = 0; j < 26; j++) {
                        StringBuilder temp=new StringBuilder(pair.word);

                           temp.setCharAt(i,(char)(j+'a'));
				//check that the generated string within set and no seen before
                           if (set.contains(temp.toString()) &&!taken.contains(temp.toString())) {
                               queue.add(new Pair(temp.toString(), pair.currentDepth + 1));
                               taken.add(temp.toString());
                           }
                               temp.setCharAt(i,pair.word.charAt(i));
                    
                }
            }
        }

        return ans;

    }
}