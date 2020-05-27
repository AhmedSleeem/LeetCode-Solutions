class Solution {
fun findMaxLength(nums: IntArray): Int {

    var max=0;
   var one=0

    var sum:HashMap<Int,Int> =HashMap()
    sum.put(0,-1)
    for (element in nums.indices) {
        if(nums[element]==1)++one
        else --one

        if (sum.containsKey(one)){
            val get:Int = sum.getOrDefault(one,0)
            max=Math.max(max,element-get)
        }else sum.put(one,element)
        

    //0 1 0 1
    }

    return max

}
//0 1 0 1 0  1
//
}