package leetcode.week265;

public class Problem5914 {

    public int smallestEqual(int[] nums) {
        int n= nums.length;
        for(int i=0;i<n;i++){
            if(i%10==nums[i]){
                return i;
            }
        }
        return -1;
    }
}
