package acwing.week19;

import java.util.Scanner;

public class Problem3992 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int w=sc.nextInt();

        int[] a=new int[n];
        int max=0;

        int tmax=0;
        int tmin=0;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            if(tmax+a[i]>0){
                tmax=tmax+a[i];
            }
            else{
                tmax=0;
            }
            if(tmin+a[i]<0){
                tmin=tmin+a[i];
            }
            else{
                tmin=0;
            }

            max=Math.max(max,tmax);
            max=Math.max(max,Math.abs(tmin));
        }
        if(w>=max){

            System.out.println(w-max+1);
        }
        else{
            System.out.println(0);
        }

    }
}
