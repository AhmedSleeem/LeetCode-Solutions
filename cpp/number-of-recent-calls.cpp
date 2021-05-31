class RecentCounter {
public:
    
    queue<int>qu;
    
    RecentCounter() {
        
    }
    
    int ping(int t) {
        qu.push(t);
        while(!qu.empty()&&t-qu.front()>3000){
            qu.pop();
        }
        return (int)qu.size();
    }
};

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter* obj = new RecentCounter();
 * int param_1 = obj->ping(t);
 */