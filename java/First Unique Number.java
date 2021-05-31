     class FirstUnique {
		// used to store every occurance of each element
            HashMap<Integer,Integer>map;

		//used to keep order of the element which are unique up to this moment 
            LinkedList<Integer>orderOfOcuuranc;
            public FirstUnique(int[] nums) {
                map=new HashMap<>();
                orderOfOcuuranc=new LinkedList();
                for(int i:nums)map.put(i,map.getOrDefault(i,0)+1);
		
		//we iterate over the array elemnt rather than map because with iterator we dont maintain the order of element

                for(int i:nums){
                    if (map.get(i)==1)orderOfOcuuranc.add(i);
                }
            }

            public int showFirstUnique() {

		/*
			the idea is iterate over queue which maintain the order of unique numbers
			if we found that the occurance of number change we simplly remove it from
			the queue else we are sure that this element is the first unique number
			till now
		
		*/
                int ans=-1;
                while (!orderOfOcuuranc.isEmpty()){
                    int y=orderOfOcuuranc.pollFirst();
                    if (map.get(y)==1){
                        ans=y;
                        orderOfOcuuranc.addFirst(y);
                        break;
                    }
                }
                return ans;
            }

            public void add(int value) {
                map.put(value,map.getOrDefault(value,0)+1);
                if (map.get(value)==1)orderOfOcuuranc.addLast(value);
            }
        }


/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */