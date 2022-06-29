package acwing.dp;

import java.util.Scanner;

public class Problem1027 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[][] nums=new int[n][n];

        //n*n
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            int num=sc.nextInt();
            if(x==0&&y==0&&num==0){
                break;
            }
            else {
                nums[x][y]=num;
            }
        }

        
    }
}
