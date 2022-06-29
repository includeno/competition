package acwing.week28;

import java.util.Scanner;

public class Problem4082 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String input=sc.next();
        System.out.println(count(input));
    }


    public static int count(String s){
        int count=0;
        int n=s.length();
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(s.charAt(i)=='Q'&&s.charAt(j)=='A'&&s.charAt(k)=='Q'){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
