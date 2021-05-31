class Solution {
    public int maxProduct(int[] num) {
        Arrays.sort(num);
        
        return (num[num.length-1]-1)*(num[num.length-2]-1);
    }
}