class Solution {
     public int[] findOrder(int numCourses, int[][] prerequisites) {

        int []degree=new int[numCourses];
        for(int i=0;i<prerequisites.length;++i)degree[prerequisites[i][0]]++;
        int []ans=new int[numCourses];
        LinkedList<Integer>list=new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (degree[i]==0)list.add(i);
        }
        int currentindex=0;
        int sum=0;
        while (!list.isEmpty()){
            int curr=list.poll();
            ++sum;
            ans[currentindex++]=curr;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1]==curr){
                    if (--degree[prerequisites[i][0]]==0)list.add(prerequisites[i][0]);
                }
            }
        }


        return sum==numCourses?ans:new int[]{};
    }
}