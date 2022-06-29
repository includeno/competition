package acwing.week19;

import java.util.Scanner;

public class Problem3993 {
    static int[] h=new int[200000];
    static int[] sums=new int[200000+1];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int k=sc.nextInt();

        int[] a=new int[n];

        int min=Integer.MAX_VALUE;//最终每堆的数量
        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();

            min=Math.min(min,a[i]);
            max=Math.max(max,a[i]);
            sums[a[i]]++;
        }
        for(int i=1;i<=max;i++){
            sums[i]=sums[i]+sums[i-1];
        }

        int count=0;
        for(int i=max;i>min;){
            int j=i;
            int sum=0;
            while (j>min&&sum+sums[max]-sums[j-1]<=k){
                sum+=sums[max]-sums[j-1];
                j--;
            }
            count++;
            i=j;
        }
        System.out.println(count);

    }


}
