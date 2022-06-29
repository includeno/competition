package leetcode.week270;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem5942 {

    public int[] findEvenNumbers(int[] digits) {
        int n=digits.length;
        HashSet<Integer> set=new HashSet<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    int num=digits[i]*100+digits[j]*10+digits[k];
                    if(i!=j&&j!=k&&i!=k&&digits[i]!=0&&digits[k]%2==0&&!set.contains(num)){
                        ans.add(num);
                        set.add(num);
                    }
                }
            }
        }
        Collections.sort(ans);
        int[] res=new int[ans.size()];
        int count=0;
        for(Integer temp:ans){
            res[count++]=temp;
        }
        return res;
    }
}
