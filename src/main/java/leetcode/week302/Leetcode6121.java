package leetcode.week302;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.math.BigInteger;

//https://leetcode.cn/problems/query-kth-smallest-trimmed-number/
public class Leetcode6121 {
    public static void main(String[] args) {
        String[] nums=new String[]{"102","473","251","814"};
        int[][] queries=new int[][]{{1,1}, {2,3},{4,2},{1,2}};
        int[] res=smallestTrimmedNumbers(nums,queries);
        System.out.println(Arrays.toString(res));
    }

    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] res=new int[queries.length];
        PriorityQueue<Entry> priorityQueue=new PriorityQueue<>((a,b)->{
            if(a.value.compareTo(b.value)<0){
                return -1;
            }
            else if(a.value.compareTo(b.value)>0){
                return 1;
            }
            else if(a.index< (b).index){
                return -1;
            }
            else {
                return 1;
            }
        });
        for(int i=0;i<queries.length;i++){
            int k=queries[i][0];
            int trim=queries[i][1];
            for(int e=0;e<nums.length;e++){
                priorityQueue.offer(new Entry(e,new BigInteger(nums[e].substring(nums[e].length()-trim))));
            }
            int temp=0;
            while (k>0){
                Entry entry = priorityQueue.poll();
                temp=entry.index;
                //System.out.println("k:"+k+" =>"+entry.value+" ~"+entry.index);
                k--;
            }
            res[i]=temp;
            priorityQueue.clear();
        }
        return res;
    }

    static class Entry{
        public int index;
        public BigInteger value;
        public Entry(int index,BigInteger value){
            this.index=index;
            this.value=value;
        }
    }
}
