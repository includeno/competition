package competition.vm;

import java.util.Scanner;

public class Main2 {
    static int[] primes=new int[1000000+10];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int m=sc.nextInt();
        int n=sc.nextInt();

        primes[2]=1;
        for(int i=3;i<=1000000;i++){
            if(check(i)){
                primes[i]=1;
            }
        }

        int count=0;
        for(int i=m;i<=n;i++){
            if(primes[i]==1){
                if(split(i)==true){
                    count++;
                }
                else{
                    //System.out.println(i+" ->");
                }

            }
        }
        System.out.println(count);
    }

    public static boolean split(int number){
        String cur=String.valueOf(number);

        for(int i=0;i<cur.length();i++){
            String firststring=cur.substring(0,i);
            String secondstring=cur.substring(i);
            if(!firststring.equals("")&&!secondstring.equals("")){

                int first=Integer.parseInt(cur.substring(0,i));
                int second=Integer.parseInt(cur.substring(i));
                //System.out.println(number+" =>first:"+first+" =>second"+second);
                if(primes[first]==1&&primes[second]==1){
                    return true;
                }
            }

        }
        return false;
    }



    public static boolean check(int number){
        if(number==1){
            return false;
        }
        for(int i=2;i<=number/i;i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
