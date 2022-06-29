package niuke.p20211210;

import java.util.Arrays;
import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] nums=new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
            sum=sum+nums[i];
        }

        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(i!=j){
                    int temp=nums[j]-(n-Math.abs(i-j));
                    if(temp<0){
                        temp=0;
                    }
                    count=count+temp;
                }
            }
            System.out.print(count+" ");
        }
    }
}
