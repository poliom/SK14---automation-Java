package Lecture4.ListOfNumbersIteration;

import java.util.ArrayList;
import java.util.List;

public class ListOfNumbersIteration {
    public static void main (String[] args) {

        int[] List;
        List< Integer > list1 = new ArrayList <>();
        list1.add(12);
        list1.add(15);
        list1.add(32);
        list1.add(42);
        list1.add(55);
        list1.add(75);
        list1.add(122);
        list1.add(132);
        list1.add(150);
        list1.add(180);
        list1.add(200);

        for (int number : list1) {
            if (number > 150) {
                break;
            }

            if (number % 5 == 0) {
                System.out.println(number);
            }
        }
    }
}
