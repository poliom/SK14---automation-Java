package Lecture4.ReverseList;

import java.util.ArrayList;
import java.util.List;

public class ReverseList {
        public static void main (String[] args) {

            int[] List;
            java.util.List < Integer > list1 = new ArrayList <>();
            list1.add(10);
            list1.add(20);
            list1.add(30);
            list1.add(40);
            list1.add(50);

            java.util.List < Integer > reverselist = new ArrayList <>();

            for (int i = list1.size() - 1; i >= 0; i--) {
                reverselist.add(list1.get(i));
                }

            System.out.println("Original List" + list1);
            System.out.println("Reversed List" + reverselist);
                }
            }
