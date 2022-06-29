package competition.tencent;

import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        char[][] map=new char[n][n];
        for(int i=0;i<n;i++){
            String line=sc.nextLine();
            String[] lines=line.split(" ");
            for(int j=0;j<n;j++){
                map[i][j]=lines[j].charAt(0);
            }
        }

        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){
                if(map[i][j]!='*'){

                }
            }
        }

    }



}
