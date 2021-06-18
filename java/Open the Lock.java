
class Solution {
    
    public int openLock(String[] deadends, String target) {
        
        
        String start = "0000";  // lock starts at 0000
        
        /*  We will use set to store the deadends.
            We can check if any possibility is a deadend or not. */
        
        Set<String> dead = new HashSet<>();
        for (String str : deadends) {
            dead.add(str);
        } 
        
        /* Base Cases */
        
        if (dead.contains(start)) {
            return -1;   // If start point is itself a dead end, it is not possible.
        }
        
        if (target.equals(start)) {
            return 0;   // If start point is itself the target, moves required are 0
        }
        
        /* Actual Implementation */
        
        Set<String> visited = new HashSet<>();  // for tracking the visited permutations
        Queue<String> q = new LinkedList<>();   // for tracking non-visited && non-deadends permutations
        
        q.add(start);  // Initialize queue with start {0000}
        
        
        /* Loop moves will be incremented after all permutations of queue size are done.
            
            eg: move = 0  : queue = {0000}                     q.size() = 1
                move = 1  : queue = {0001, 0010, ,0900, 9000}  q.size() <= 8  
                move = 2  : queue = {0002, 0020, ,0901, 8000}  q.size() <= 8*8 (some moves may be deadlock or visited)
                move = 3  : queue = {0012, 0030, ,0911, 8100}  q.size() <= 8*8*8   ... and so on
                
                So, at any point, (moves = diff. of digits from start)
                eg: 0000  -> {0012, 0030, ,0911, 8100} => move = 3
        */

        for (int moves = 1; !q.isEmpty(); moves++) {
            
            /* Check for all elements in the queue having 1 digit difference than previous
               (all others are done in previous loop) */
            
            for (int n = q.size(); n > 0; n--) {
                
                // Fetch curr element in queue, and check for its 8 possible moves
                String curr = q.poll();
                
                /*  Consider 8 possible moves from the curr position
        
                    Eg: From { 0 0 0 0}
                    Below are the 8 possible moves =>
            
                    0001  0010  0100  1000   (scroll the lock number downwards for each pos)
                    0009  0090  0900  9000   (scroll the lock number upwards for each pos)
        
                */
                
                for (int i=0; i<4; i++) {
                    
                    // Moves from scrolling the lock down and up
                    char[] down = curr.toCharArray();
                    char[] up = curr.toCharArray();
                    
                    down[i] = (char) ((down[i] - '0' + 1) % 10 + '0');
                    up[i] = (char) ((up[i] - '0' + 9) % 10 + '0');
                    
                    String downStr = new String(down);
                    String upStr = new String(up);
                    
                    /* Check scenarios for the updated permutation moves of string */
                    
                    if (target.equals(downStr) || target.equals(upStr)) {
                        return moves;  // reached till the target, return curr no. of moves
                    }
                    
                    // If identified permutation NOT visited and NOT deadEnd, add in queue for further research
                    
                    if (!dead.contains(downStr) && !visited.contains(downStr)) {
                        q.add(downStr);
                    }
                    visited.add(downStr);  // mark the permutation as visited now.
                    
                    if (!dead.contains(upStr) && !visited.contains(upStr)) {
                        q.add(upStr);
                    }
                    visited.add(upStr);  // mark the permutation as visited now.
                    
                }
                
                
            }
            
            
        }

        return -1;
        
    }
}