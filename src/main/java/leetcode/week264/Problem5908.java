package leetcode.week264;

import java.util.*;
import java.util.stream.Collectors;

public class Problem5908 {

    public static void main(String[] args) {
        int[] parents=new int[]{1,2,3,4,5,6};
        Problem5908 fff=new Problem5908();
        parents=new int[]{-1,2,0,2,0};
        System.out.println(fff.countHighestScoreNodes(parents));
    }

    public int countHighestScoreNodes(int[] parents) {
        int n=parents.length;
        int[] score=new int[n];
        int max=Integer.MIN_VALUE;

        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int key=parents[i];
            if(key==-1){
                continue;
            }
            if(map.get(key)==null){
                List<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(key,list);
            }
            else{
                List<Integer> list=map.get(key);
                list.add(i);
                map.put(key,list);
            }
        }

        return 0;
    }


}
