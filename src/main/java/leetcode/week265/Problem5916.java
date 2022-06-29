package leetcode.week265;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://leetcode-cn.com/problems/minimum-operations-to-convert-number/
public class Problem5916 {

    public int minimumOperations(int[] nums, int start, int goal) {
        int n=nums.length;
        Queue<Integer> queue=new LinkedList<>();
        Set<Integer> set = new HashSet();
        set.add(start);
        queue.offer(start);
        int count=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int j=0;j<size;j++){
                Integer cur=queue.poll();
                for(int i=0;i<n;i++){
                    int add = cur + nums[i];
                    int min = cur - nums[i];
                    int xor = cur ^ nums[i];
                    if(add==goal|| min==goal || xor==goal){
                        count++;
                        return count;
                    }
                    if(add>=0&&add<=1000&& set.add(add)){
                        queue.offer(add);
                    }
                    if(min>=0&&min<=1000&& set.add(min)){
                        queue.offer(min);
                    }
                    if(xor>=0&&xor<=1000&& set.add(xor)){
                        queue.offer(xor);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
