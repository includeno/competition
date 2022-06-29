package leetcode.week261;

import java.util.Arrays;

public class Problem5891 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m=rolls.length;


        int max=n*6;
        int min=n*1;


        int sum=mean*(n+m);
        int rollsSum=0;
        for(int i=0;i<m;i++){
            rollsSum=rollsSum+rolls[i];
        }
        if(sum-rollsSum>max||sum-rollsSum<min){
            return new int[0];
        }
        int[] ans=new int[n];
        Arrays.fill(ans,1);
        sum=sum-min-rollsSum;

        for(int i=0;i<n;i++){
            if(sum>=5){
                ans[i]=6;
                sum=sum-5;
            }
            else{
                ans[i]=1+sum;
                sum=0;
                break;
            }
        }
        return ans;

    }
}
