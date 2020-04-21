/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        
        List<Integer>d= binaryMatrix.dimensions();
        
        int n=d.get(0),m=d.get(1);
        
        BitSet col=new BitSet(m);
      for(int i=0;i<n;++i){
          for(int k=m-1;k>=0;--k){
              if(col.get(k))continue;
              
              if(binaryMatrix.get(i,k)==1){
                  col.set(k);
              }
              else 
              {
                  break;
              }
          }
          
          if(col.get(0))break;
      }
        
    for(int l=0;l<m;++l)
        if(col.get(l))return l;
    
        
        
        return -1;
    }
}