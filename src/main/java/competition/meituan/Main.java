package competition.meituan;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        while (T>0){

            int n=sc.nextInt();
            int m=sc.nextInt();
            int k=sc.nextInt();

            int[][] graph=new int[n+1][n+1];
            for(int i=0;i<m;i++){
                int from=sc.nextInt();
                int to=sc.nextInt();
                graph[from][to]=1;
                graph[to][from]=1;
            }

            int[] record=new int[k];
            int flag=0;
            for(int i=0;i<k;i++){
                record[i]=sc.nextInt();
                if(i>0&&graph[record[i]][record[i-1]]!=1){
                    flag=1;
                }
            }
            if(flag==1){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }


            T--;
        }

    }
}
