package leetcode.week262;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Problem2032 {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

        HashSet<Integer> a1=new HashSet<>();
        for(int a:nums1){
            a1.add(a);
        }
        HashSet<Integer> a2=new HashSet<>();
        for(int a:nums2){
            a2.add(a);
        }
        HashSet<Integer> a3=new HashSet<>();
        for(int a:nums3){
            a3.add(a);
        }
        HashSet<Integer> ans=new HashSet<>();
        //求交集
        HashSet<Integer> common=new HashSet<>();
        common.addAll(a1);
        common.retainAll(a2);
        ans.addAll(common);

        common.clear();
        common.addAll(a2);
        common.retainAll(a3);
        ans.addAll(common);

        common.clear();
        common.addAll(a1);
        common.retainAll(a3);
        ans.addAll(common);

        Iterator<Integer> it= ans.iterator();
        List<Integer> result=new ArrayList<>();
        while (it.hasNext()){
            result.add(it.next());
        }
        return result;

    }
}
