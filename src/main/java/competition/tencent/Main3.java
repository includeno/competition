package competition.tencent;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.next();

        System.out.println(cal(input));
    }

    public static long cal(String input){
        long ans=0;
        Deque<Character> op=new ArrayDeque<>();
        Deque<Long> number=new ArrayDeque<>();

        int n=input.length();
        for(int i=0;i<n;i++){
            if(input.charAt(i)=='+'){
                op.push(input.charAt(i));
                if(!op.isEmpty()&&op.peek()=='*'&&number.size()>1){
                    long one=number.pop();
                    long two=number.pop();
                    long result=one*two;
                    number.push(result);
                    op.pop();
                }
            }
            else if(input.charAt(i)=='x'){
                op.push(input.charAt(i));

                if(!op.isEmpty()&&op.peek()=='@'&&number.size()>1){
                    long one=number.pop();
                    long two=number.pop();
                    long result=one|(one+two);
                    number.push(result);
                    op.pop();
                }
            }
            else if(input.charAt(i)=='@'){
                op.push(input.charAt(i));
            }
            else{
                //拼整数
                StringBuilder builder=new StringBuilder();
                int start=i;
                int end=i+1;
                while (end<n&&Character.isDigit(input.charAt(end))){
                    end++;
                }
                builder.append(input.substring(start,end));
                number.push(Long.parseLong(builder.toString()));
                if(end>i+1){
                    i=end-1;
                }
                if(!op.isEmpty()&&op.peek()=='@'&&number.size()>1){
                    long one=number.pop();
                    long two=number.pop();
                    long result=one|(one+two);
                    number.push(result);
                    op.pop();
                }

            }
        }
        while (number.size()>1&&!op.isEmpty()){
            if(op.peek()=='@'){
                long one=number.pop();
                long two=number.pop();
                long result=one|(one+two);
                number.push(result);
                op.pop();
            }
            else if(op.peek()=='x'){
                long one=number.pop();
                long two=number.pop();
                long result=one*two;
                number.push(result);
                op.pop();
            }
            else{
                long one=number.pop();
                long two=number.pop();
                long result=one+two;
                number.push(result);
                op.pop();
            }

        }
        ans=number.pop();

        return ans;
    }
}
