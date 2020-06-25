package homework;

import java.util.ArrayList;

public class Winner {

    public String judge(String poker){
        int a=0;
        if(poker.charAt(22)==' ') a=1;

        String string1 = poker.substring(7, 21+a);
        String string2 = poker.substring(29+a);
        Grade grade1 = new Grade(string1);
        Grade grade2 = new Grade(string2);
        int num1 = grade1.grade(), num2 = grade2.grade();
        if(num1>num2) return "Black wins";
        else if(num1<num2) return "White wins";
        ArrayList<Integer> black = grade1.getNum();
        ArrayList<Integer> white = grade2.getNum();
        int same = compare(num1, black, white);
        if(same==1) return "Black wins";
        else if(same==2) return "White wins";
        return "Tie";
    }

    private int compare(int num, ArrayList<Integer>black, ArrayList<Integer>white){
        if(black.get(0)==1) {
            black.remove(0);
            black.add(14);
        }
        if(white.get(0)==1) {
            white.remove(0);
            white.add(14);
        }
        if(num==7||num==6||num==5||num==1){
            for(int i=4; i>=0; i--){
                if(black.get(i)>white.get(i)) return 1;
                else if(black.get(i)<white.get(i)) return 2;
            }
            return 0;
        }
        else if(num==4){
            if(black.get(2)>white.get(2)) return 1;  //三条第三张必为三条的大小
            return 2;
        }
        else if(num==3){
            int[] a = new int[3];
            int[] b = new int[3];
            int a1=twopair(black), b1=twopair(white), a2=2, b2=2;
            for(int i=4; i>=0; i=i-2){
                if(i!=a1) a[a2--] = black.get(i);
                if(i!=b1) b[b2--] = white.get(i);
            }
            a[0] = black.get(a1);
            b[0] = white.get(b1);
            for(int i=2; i>=0; i--){
                if(a[i]>b[i]) return 1;
                else if(a[i]<b[i]) return 2;
            }
            return 0;
        }
        else{
            int a = onepair(black), b = onepair(white);
            int a1 = black.get(a), b1 = white.get(b);
            black.remove(a+1);
            black.remove(a);
            black.add(a1);
            white.remove(b+1);
            white.remove(b);
            white.add(b1);
            for(int i=3; i>=0; i--){
                if(black.get(i)>white.get(i)) return 1;
                else if(black.get(i)<white.get(i)) return 2;
            }
            return 0;
        }
    }

    private int twopair(ArrayList<Integer> list){
        if(list.get(1) == null ? list.get(3) != null : !list.get(1).equals(list.get(3))) return 2;
        if(list.get(0) == null ? list.get(1) != null : !list.get(0).equals(list.get(1))) return 4;
        return 0;
    }

    private int onepair(ArrayList<Integer> list){
        int i;
        for(i=0; i<3; i++){
            if(list.get(i) == null ? list.get(i + 1) == null : list.get(i).equals(list.get(i + 1))) break;
        }
        return i;
    }
}
