package leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Leetcode676 {

    public static void main(String[] args) {
        String[] dictionary=new String[]{"hello", "leetcode"};
        MagicDictionary obj = new MagicDictionary();
        obj.buildDict(dictionary);

        List<String> searchWords=new ArrayList<>();
        searchWords.add("hello");
        searchWords.add("hhllo");
        searchWords.add("hell");
        searchWords.add("leetcoded");

        for(String searchWord:searchWords){
            boolean param_2 = obj.search(searchWord);
            System.out.println(param_2);
        }

    }

}

class MagicDictionary {
    public static HashSet<String> extend;

    public MagicDictionary() {
        extend=new HashSet<>();
    }

    public void buildDict(String[] dictionary) {
        for(int i=0;i<dictionary.length;i++){
            String cur=dictionary[i];
            extend.add(cur);
        }
    }

    public boolean search(String searchWord) {
        String cur=searchWord;
        StringBuilder builder=new StringBuilder();
        builder.append(cur);
        for(int t=0;t<cur.length();t++){
            for(char ch='a';ch<='z';ch++){
                if(ch!=cur.charAt(t)){
                    builder.setCharAt(t,ch);
                    //System.out.println("t:"+t+" res:"+builder.toString());
                    if(extend.contains(builder.toString())){
                        return true;
                    }
                }
            }
            builder.setCharAt(t,cur.charAt(t));
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */