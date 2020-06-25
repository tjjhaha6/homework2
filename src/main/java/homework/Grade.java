package homework;

import java.util.ArrayList;
import java.util.Collections;

public class Grade {

    private ArrayList<Character> alphabet = new ArrayList<Character>();
    private ArrayList<Integer> num = new ArrayList<Integer>();
    private String string;

    public Grade(String input){
        string = input;
    }

    public ArrayList<Integer> getNum() {
        return num;
    }

    public Integer grade(){
        String[] splitString = string.split(" ");
        for(String part: splitString){
            if(part.length()>2) num.add(10);
            else {
                char c = part.charAt(0);
                int n;
                switch (c){
                    case 'K': n=13; break;
                    case 'Q': n=12; break;
                    case 'J': n=11; break;
                    case 'A': n=1; break;
                    default: n=(int)c - (int)'0';
                }
                num.add(n);
            }
            alphabet.add(part.charAt(part.length()-1));
        }
        Collections.sort(num);
        boolean continuous = isContinuous(num);
        boolean color = isColor(alphabet);
        // 返回等级
        if(continuous && color) return 7;
        else if(color) return 6;
        else if(continuous) return 5;
        return much(num)+1;
    }

    // 判断是否为顺子
    private boolean isContinuous(ArrayList<Integer> num){
        for(int i=0; i<num.size()-2; i++){
            if((num.get(i + 1) != num.get(i) +1)) return false;
        }
        return num.get(num.size() - 1) != 13 || num.get(0) == 1;
    }

    // 判断是否同色
    private boolean isColor(ArrayList<Character> alphabet){
        for(int i=0; i<alphabet.size()-1; i++){
            if(alphabet.get(i + 1) != alphabet.get(i)) return false;
        }
        return true;
    }

    // 判断是否有对子或者三个
    private int much(ArrayList<Integer> num){
        int time = 0, most = 1, mid = 1;
        for(int i=0; i<num.size()-2; i++){
            if(num.get(i + 1) == null ? num.get(i) == null : num.get(i + 1).equals(num.get(i))){
                mid++;
                if(mid>most) most = mid;
                time++;
            }
            else {
                mid = 1;
            }
        }
        if(most>=3) return 3;   // 三条
        else if(most==2&&time==2) return 2;  // 两对
        else if(most==2) return 1; // 一对
        else return 0; // 散排
    }
}
