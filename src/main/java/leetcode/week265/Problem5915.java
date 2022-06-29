package leetcode.week265;

import base.ListNode;

import java.util.ArrayList;

public class Problem5915 {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> list=new ArrayList<>();
        ListNode p=head;
        ArrayList<Integer> count=new ArrayList<>();
        int i=0;
        while (p!=null){
            list.add(p.val);
            p=p.next;
            if(i>=2){
                if(list.get(i-1)>list.get(i)&&list.get(i-1)>list.get(i-2)){
                    count.add(i-1);
                }
                else if(list.get(i-1)<list.get(i)&&list.get(i)<list.get(i-2)){
                    count.add(i-1);
                }
            }
            i++;
        }

        if(count.size()<2){
            return new int[]{-1,-1};
        }
        else{
            int max=count.get(count.size()-1)-count.get(0);
            int min=Integer.MAX_VALUE;
            for(int j=1;j<count.size();j++){
                min=Math.min(min,count.get(j)-count.get(j-1));
            }
            return new int[]{min,max};
        }
    }
}
