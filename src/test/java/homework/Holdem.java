package homework;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Holdem {

    @Test
    public void test(){
        Winner winner = new Winner();
        String ans = winner.judge("Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH");
        assertEquals("White wins", ans);
        System.out.println(ans);
    }

    @Test
    public void test2(){
        Winner winner = new Winner();
        String ans = winner.judge("Black: 2H 4S 4C 2D 4H White: 2S 8S AS QS 3S");
        assertEquals("White wins", ans);
        System.out.println(ans);
    }

    @Test
    public void test3(){
        Winner winner = new Winner();
        String ans = winner.judge("Black: 2H 3H 5H 9H KH White: 2C 3H 4S 5C 6H");
        assertEquals("Black wins", ans);
        System.out.println(ans);
    }

    @Test
    public void test4(){
        Winner winner = new Winner();
        String ans = winner.judge("Black: 2H 3D 5S 9C KD White: 2D 3H 5C 9S KH");
        assertEquals("Tie", ans);
        System.out.println(ans);
    }

    @Test
    public void test5(){
        Winner winner = new Winner();
        String ans = winner.judge("Black: 3H 3D 3S 9C KD White: 5D 5H 5C 9S KH");
        assertEquals("White wins", ans);
        System.out.println(ans);
    }

    @Test
    public void test6(){
        Winner winner = new Winner();
        String ans = winner.judge("Black: 3H 3D 4S 4C KD White: 3S 3C 4D 4H KH");
        assertEquals("Tie", ans);
        System.out.println(ans);
    }

    @Test
    public void test7(){
        Winner winner = new Winner();
        String ans = winner.judge("Black: 3H 3D 4S 4C 10D White: 3S 3C 4D 4H KH");
        assertEquals("White wins", ans);
        System.out.println(ans);
    }

    @Test
    public void test8(){
        Winner winner = new Winner();
        String ans = winner.judge("Black: AH KD JS QC 10D White: QS JC 10D AH KH");
        assertEquals("Tie", ans);
        System.out.println(ans);
    }
}
