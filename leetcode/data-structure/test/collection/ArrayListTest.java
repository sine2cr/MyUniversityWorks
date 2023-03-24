package collection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    @Test
    void test() {
//        顺序表
        ArrayList<Integer> list = new ArrayList<>();
        list.add( 111,0);
        list.add( 222,1);
        list.add( 333,1);
        list.add( 444,1);
        System.out.println(list.remove(2));
        System.out.println(list.toString());

    }
}