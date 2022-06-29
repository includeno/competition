package acwing.week19;

import java.util.Scanner;

public class Problem3991 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();

        while (T>0){
            int n=sc.nextInt();
            String str=sc.next();

            if(check(str)==true){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
            T--;
        }
    }

    public static boolean check(String str){
        int n=str.length();
        for(int i=1;i<n;i++){
            if(str.charAt(i)=='1'){
                if(str.charAt(i-1)=='1'){
                    return false;
                }
            }
            else{
                if(i+1<n&&str.charAt(i+1)=='0'&&str.charAt(i-1)=='0'){
                    return false;
                }
            }
        }
        return true;
    }
}
