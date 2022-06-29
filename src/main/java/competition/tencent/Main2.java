package competition.tencent;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();

        while (T>0){
            int n=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            System.out.println(jump(a));
            T--;
        }
    }


    public static int jump(int[] a){

        int n=a.length;
        int[] sums=new int[n];
        //i是起点
        int max=0;
        for(int i=n-1;i>=0;i--){
            int count=0;
            int j=i;
            while (j<n){
                if(sums[j]!=0){
                    count=count+sums[j];
                    break;
                }
                else{
                    int step=a[j];
                    count=count+step;
                    j=step+j;
                }
            }
            sums[i]=count;
            max=Math.max(max,count);
        }
        return max;
    }
}
