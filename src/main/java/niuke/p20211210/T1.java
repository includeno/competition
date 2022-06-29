package niuke.p20211210;

import java.util.Scanner;

public class T1 {
    public static void main3(String[] args) {
        int A=2;
        String num="12345";
        System.out.println(getResult(A,num));
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int T=Integer.parseInt(sc.nextLine());
        while (T>0){
            String line=sc.nextLine();
            String[] strings=line.split(" ");
            int A=Integer.parseInt(strings[0]);
            String num=strings[1];

            System.out.println(getResult(A,num));
            T--;
        }

    }

    public static String getResult(int A,String num){
        StringBuilder re=new StringBuilder(num).reverse();
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<re.length();i++){
            if(i%A==0&&i>0&&i<=re.length()-1){
                builder.insert(0,"_");
            }
            builder.insert(0,String.valueOf(re.charAt(i)));
        }
        return builder.toString();
    }
}
