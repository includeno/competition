package leetcode.week302;

import java.util.Arrays;

public class Leetcode6120 {
    public static void main(String[] args) {
        int[] input=new int[]{1,3,2,1,3,2,2};
        int[] res=numberOfPairs(input);
        System.out.println(Arrays.toString(res));
    }

    public static int[] numberOfPairs(int[] nums) {
        int n=nums.length;
        int[] map=new int[101];
        for(int i=0;i<n;i++){
            map[nums[i]]++;
        }
        int pair=0;
        int left=0;
        for(int i=0;i<=100;i++){
            pair=pair+map[i]/2;
        }
        int[] res=new int[2];
        res[0]=pair;
        res[1]=n-2*pair;
        return res;
    }
}
