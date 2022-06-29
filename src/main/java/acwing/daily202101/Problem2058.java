package acwing.daily202101;

import java.util.HashSet;
import java.util.Scanner;

public class Problem2058 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String two=sc.next();
        String three=sc.next();

        HashSet<Integer> set=new HashSet<>();
        StringBuilder builder=new StringBuilder(two);
        for(int i=0;i<two.length();i++){
            for(int j=0;j<=1;j++){
                if(builder.charAt(i)-'0'!=j){
                    char ch=builder.charAt(i);
                    builder.setCharAt(i, (char) ('0'+j));
                    int number=getNumber(builder.toString(),2);
                    set.add(number);
                    builder.setCharAt(i, ch);
                }

            }
        }

        builder=new StringBuilder(three);
        for(int i=0;i<three.length();i++){
            for(int j=0;j<=2;j++){
                if(builder.charAt(i)-'0'!=j){
                    char ch=builder.charAt(i);
                    builder.setCharAt(i, (char) ('0'+j));
                    int number=getNumber(builder.toString(),3);
                    if(set.contains(number)){
                        System.out.println(number);
                        return;
                    }
                    builder.setCharAt(i, ch);
                }
            }
        }
    }

    public static int getNumber(String number,int count){
        int base=1;
        int sum=0;
        for(int i=number.length()-1;i>=0;i--){
            sum=sum+(number.charAt(i)-'0')*base;
            base=base*count;
        }
        return sum;
    }
}
