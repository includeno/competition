package acwing.week28;

import java.util.Scanner;

public class Problem4083 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int N=100000+5;
        int[] nums=new int[N];
        for(int i=0;i<n;i++){
            nums[sc.nextInt()]++;
        }
        int ans=1;
        for(int d=2;d<=N;d++){
            int temp=0;
            for(int i=d;i<N;i=i+d){
                temp=temp+nums[i];
            }
            ans=Math.max(ans,temp);
        }
        System.out.println(ans);
    }
}
