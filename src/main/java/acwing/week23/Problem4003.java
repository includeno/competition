package acwing.week23;

import java.util.Arrays;
import java.util.Scanner;

public class Problem4003 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        Arrays.sort(nums);
        int max=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(nums[i]<0){
                max=Math.max(max,nums[i]);
            }
            else{
                if(!check(nums[i])){
                    System.out.println(nums[i]);
                    return;
                }
            }

        }

    }

    public static boolean check(int temp){
        double t=Math.sqrt(temp);
        for(int i=0;i<(int)t+1;i++){
            if(i*i==temp){
                return true;
            }
        }
        return false;
    }
}
