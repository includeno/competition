package leetcode.week302;

import java.util.*;

public class Leetcode6164 {

    public static void main(String[] args) {
        int[] nums=new int[]{14,32,41,23,1121};
        System.out.println(maximumSum(nums));
    }

    public static int maximumSum(int[] nums) {
        int n=nums.length;
        HashMap<Integer, PriorityQueue<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int number=nums[i];
            int temp=bitSum(number);
            if(map.get(temp)!=null){
                PriorityQueue<Integer> list=map.get(temp);
                list.add(number);
            }
            else{
                PriorityQueue<Integer> list=new PriorityQueue<>((a,b)->{return b-a;});
                list.add(number);
                map.put(temp,list);
            }
        }
        int max=0;
        for(PriorityQueue<Integer> queue:map.values()){
            if(queue.size()>1){
                max=Math.max(max,queue.poll()+ queue.poll());
            }
        }
        return max;
    }

    public static int bitSum(int number){
        String str=String.valueOf(number);
        int sum=0;
        for(int i=0;i<str.length();i++){
            sum=sum+str.charAt(i)-'0';
        }
        return sum;
    }
}
