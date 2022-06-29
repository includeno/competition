package leetcode.week262;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2035 {
    public static void main(String[] args) {
        int[] nums=new int[]{2,-1,0,4,-2,-9};
        System.out.println(minimumDifference(nums));
    }
    public static int minimumDifference(int[] nums) {
        Arrays.sort(nums);

        List<Integer> a1=new ArrayList<>();
        List<Integer> a2=new ArrayList<>();

        a1.add(nums[0]);
        a2.add(nums[1]);
        int sumA1=nums[0];
        int sumA2=nums[1];

        for(int i=2;i<nums.length;i=i+2){

            if(Math.abs(sumA1+nums[i]-(sumA2+nums[i+1]))<Math.abs(sumA2+nums[i]-(sumA1+nums[i+1]))){
                a1.add(nums[i]);
                a2.add(nums[i+1]);
                sumA1=sumA1+nums[i];
                sumA2=sumA2+nums[i+1];
            }
            else {
                a1.add(nums[i+1]);
                a2.add(nums[i]);
                sumA1=sumA1+nums[i+1];
                sumA2=sumA2+nums[i];
            }
        }
        return Math.abs(sumA1-sumA2);
    }
}
