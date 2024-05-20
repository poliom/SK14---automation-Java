package Lecture4;

public class Examples {
    public static void main(String[] args) {
//        testArithmeticOperations();
//        testAssignmentOperators();
//        testAutoOperator();
//        testLogicalOperator();
//        testIfStatement();
//        testNestedIfStatement();
//        testIfElseStatement();
//        testIfElseIfStatement();
//        testTernaryOperator();
//        testSwitchStatement();
//        testForLoop();
        testWhileLoop();
//        testDoWhileLoop();
//        testContinueStatement();
        testBreakStatement();
    }

    public static void testArithmeticOperations() {
        int num1 = 101;
        int num2 = 20;

        System.out.println("num1 + num2: " + (num1 + num2));
        System.out.println("num1 - num2: " + (num1 - num2));
        System.out.println("num1 * num2: " + (num1 * num2));
        System.out.println("num1 / num2: " + (num1 / num2));
        System.out.println("num1 % num2: " + (num1 % num2));
    }

    public static void testAutoOperator() {
        int num1 = 100;
        int num2 = 200;

        num1++; // 101
        num2--; // 199

        //Increases num2 after the result is calculated
        System.out.println(num1 + num2++); // 101 + 199 = 300; num2 + 1 = 200

        //Increases num2 before the result is calculated
        System.out.println(num1 + (++num2)); // 101 + (200 + 1) = 302

        System.out.println((++num1) + (++num2));
    }

    public static void testAssignmentOperators() {
        int num1 = 10;
        int num2 = 20;

        num2 = num1;
        System.out.println("= Output: " + num2);

        num2 += num1;
        System.out.println("+= Output: " + num2);

        num2 -= num1;
        System.out.println("-= Output: " + num2);

        num2 *= num1;
        System.out.println("*= Output: " + num2);

        num2 /= num1;
        System.out.println("/= Output: " + num2);

        num2 %= num1;
        System.out.println("%= Output: " + num2);
    }

    public static void testLogicalOperator() {
        boolean b1 = true;
        boolean b2 = false;

        System.out.println("b1 && b2: " + (b1 && b2));
        System.out.println("b1 || b2: " + (b1 || b2));
        System.out.println("!(b1 && b2): " + !(b1 && b2));

        b2 = true;
        System.out.println("b1 && b2: " + (b1 && b2));
        System.out.println("b1 || b2: " + (b1 || b2));
        System.out.println("!(b1 && b2): " + !(b1 && b2));
    }

    public static void testTernaryOperator() {
        int num1, num2;
        num1 = 25;
        /* num1 is not equal to 10 that's why
         * the second value after colon is assigned
         * to the variable num2
         */
        num2 = (num1 == 10) ? 100 : 200;
        /*
        if (num1 == 10){
            num2 = 100;
        }
        else{
            num2 = 200;
        }
         */
        System.out.println("num2: " + num2);

        /* num1 is equal to 25 that's why
         * the first value is assigned
         * to the variable num2
         */
        num2 = (num1 == 25) ? 100 : 200;
        System.out.println("num2: " + num2);

    }

    public static void testIfStatement() {
        int num = 110;
        if (num < 100) {
            System.out.println("number is less than 100");
        }
        if (num<100 || num == 700){
            System.out.println("number is less than 100 or is equal to 700");
        }
        if (num == 110){
            System.out.println("number is 110");
        }
    }

    public static void testNestedIfStatement() {
        int num = 70;
        if (num < 100) {
            System.out.println("number is less than 100");
            if (num > 50) {
                System.out.println("number is greater than 50");
                if (num < 80){
                    System.out.println("number is less than 80");
                }
            }
        }
    }

    public static void testIfElseStatement() {
        int num = 120;
        if (num < 50) {
            System.out.println("num is less than 50");
        } else {
            System.out.println("num is greater than or equal 50");
        }
    }

    public static void testIfElseIfStatement() {
        int num = 123456;
        if (num < 100 && num >= 10) {
            System.out.println("Its a two digit number");
        } else if (num < 1000 && num >= 100) {
            System.out.println("Its a three digit number");
        } else if (num < 10000 && num >= 1000) {
            System.out.println("Its a four digit number");
        } else {
            System.out.println("number is not between 1 & 99999");
        }
    }

    public static void testSwitchStatement() {
        int i = 2;
        switch (i) {
            case 1:
                System.out.println("Case1 ");
                break;
            case 2:
                System.out.println("Case2 ");
                break;
            case 3:
                System.out.println("Case3 ");
                break;
            default:
                System.out.println("Default ");
        }
    }

    public static void testForLoop() {
        for (int i = 10; i > 1; i--) {
            System.out.println("The value of i is:" + i);
        }
    }

    public static void testForIterateArray() {
        int[] arr = {2, 11, 45, 9};
        //i starts with 0 as array index starts with 0 too
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void testWhileLoop() {
        int i = 10;
        while (i > 1) {
            System.out.println(i);
            i--;
        }
    }

    public static void testWhileLoopArray() {
        int[] arr = {2, 11, 45, 9};
        //i starts with 0 as array index starts with 0 too
        int i = 0;
        while (i < 4) {
            System.out.println(arr[i]);
            i++;
        }

    }

    public static void testDoWhileLoop() {
        int i = 10;
        do {
            System.out.println(i);
            i--;
        } while (i > 1);

    }

    public static void testDoWhileLoopIterateArray() {
        int[] arr = {2, 11, 45, 9};
        //i starts with 0 as array index starts with 0
        int i = 0;
        do {
            System.out.println(arr[i]);
            i++;
        } while (i < 4);

    }

    public static void testContinueStatement() {
        for (int j = 0; j <= 6; j++) {
            if (j == 4) {
                continue;
            }
            System.out.print(j + " ");
        }

    }

    public static void testBreakStatement() {
        int var;
        for (var = 100; var >= 10; var--) {
            System.out.println("var: " + var);
            if (var == 91) {
                break;
            }
        }
        System.out.println("Out of for-loop");
    }
}
