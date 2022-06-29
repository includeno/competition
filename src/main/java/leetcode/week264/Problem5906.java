package leetcode.week264;

import java.util.ArrayList;
import java.util.List;

public class Problem5906 {

    public static void main(String[] args) {
        Problem5906 fff=new Problem5906();
        //System.out.println(fff.countValidWords("cat"));
        //System.out.println(fff.countValidWords("cat and  dog"));
        System.out.println(fff.countValidWords(". ! 7hk  al6 l! aon49esj35la k3 7u2tkh  7i9y5  !jyylhppd et v- h!ogsouv 5"));
    }

    public int countValidWords(String sentence) {

        int n=sentence.length();
        StringBuilder builder=new StringBuilder();
        List<String> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(sentence.charAt(i)!=' '){
                builder.append(sentence.charAt(i));
            }
            else{
                if(builder.length()>0){
                    ans.add(builder.toString());
                }
                builder=new StringBuilder();
            }
        }
        if(builder.length()>0){
            ans.add(builder.toString());
        }
        int count=0;
        List<String> collect=new ArrayList<>();
        for(String a:ans){
            if(valid_1(a)&&valid_2(a)&&valid_3(a)){
                count++;
                collect.add(a);
            }
        }
        return count;
    }

    public boolean valid_1(String input){
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)>='0'&&input.charAt(i)<='9'){
                return false;
            }
        }
        return true;
    }

    public boolean valid_2(String input){
        int count=0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='-'){
                count++;
                if(i==0||i==input.length()-1){
                    return false;
                }
                if(i-1>=0&&(input.charAt(i-1)>'z'||input.charAt(i-1)<'a')){
                    return false;
                }
                if(i+1<input.length()&&(input.charAt(i+1)>'z'||input.charAt(i+1)<'a')){
                    return false;
                }
            }
            if(count>1){
                return false;
            }

        }
        return true;
    }

    public boolean valid_3(String input){
        int count=0;
        for(int i=0;i<input.length();i++){
            if((input.charAt(i)=='!')||(input.charAt(i)==',')||(input.charAt(i)=='.')){
                count++;
                if(i!=input.length()-1){
                    return false;
                }
            }
            if(count>1){
                return false;
            }

        }
        return true;
    }
}
