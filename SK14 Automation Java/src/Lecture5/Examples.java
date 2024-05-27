package Lecture5;

import java.util.*;

public class Examples {
    public static void main(String[] args) {
//        testArrayDeclarationElementInit();
//        testArrayDeclaration();
//        testArrayElementValue();
//        testArrayLoop();
//        testArrayLoopAddValues();
//        testArrayForEachLoop();
//        testMultidimensionalArray();
//        testArrayListDeclaration();
//        testArrayListOperations();
//        testLinkedListInit();
//        testLinkedListOperations();
//        testQueue();
        testStack();
//        testHashSetIterator();
//        testHashSetForEach();
//        testHashSetOperations();
//        testHashMapEntrySet();
//        testHashMapKeySet();
//        testHashMapOperations();
    }

    public static void testArrayDeclarationElementInit() {
        // Creates an array with initialized elements
        //                      0       1       2        3
        String[] carBrands = {"Audi", "Bmw", "Volvo", "Mercedes"};
        int[] evenNumbers = {2, 4, 6, 8, 10};
        double[] degrees = {0, 0.5, 1, 1.5, 2, 2.5};
        long[] bigNumbers = {12548948489L,646646979494L,654494949497L};

        System.out.println(carBrands[2]);
        System.out.println(evenNumbers[2]);
        System.out.println(degrees[2]);

        System.out.println(carBrands.length);
        System.out.println(evenNumbers.length);
        System.out.println(degrees.length);
    }

    public static void testArrayDeclaration() {
        // Creates an array with fixed size. Then adds elements one by one.
        String[] cars = new String[3];
        //cars[0] = "Volvo";
        cars[2] = "Bmw";
        cars[1] = "Mercedes";
        System.out.println(cars[1]);
        System.out.println(cars[0]);
        System.out.println(cars.length);
    }

    public static void testArrayElementValue() {
        String[] carBrands = {"Audi", "Bmw", "Volvo", "Mercedes"};
        carBrands[1] = "Karuca";
        System.out.println(carBrands[1]);
    }

    public static void testArrayLoop() {
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

        System.out.println("Option 1");
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }

        System.out.println("Option 2");
        for (int i = 0; i <= cars.length-1; i++) {
            System.out.println(cars[i]);
        }

        System.out.println("Option 3");
        for (int i = 0; i != cars.length; i++) {
            System.out.println(cars[i]);
        }

        System.out.println("Reverse print");
        for (int i = cars.length-1; i >= 0; i--) {
            System.out.println(cars[i]);
        }
    }

    public static void testArrayLoopAddValues() {
        // Creates an array with fixed size. Then adds elements one by one.
        int[] numbers = new int[3];

        int singleNumber = 0;

        for(int i=0; i < numbers.length;i++){
            numbers[i] = singleNumber++; // ++ -> num = num + 1
        }

        for (int i = 0; i != numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    public static void testArrayForEachLoop() {
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        for (String arrayElement : cars) {
            System.out.println(arrayElement);
        }
    }

    public static void testMultidimensionalArray() {
/*        int[][] arr=new int[3][3];//3 row and 3 column
        arr[0][0]=1;
        arr[0][1]=2;
        arr[0][2]=3;
        arr[1][0]=4;
        arr[1][1]=5;
        arr[1][2]=6;
        arr[2][0]=7;
        arr[2][1]=8;
        arr[2][2]=9;*/

        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                System.out.println(arr[row][column]);
            }
        }

        System.out.println("Loop on column first");
        for (int column = 0; column < 3; column++) {
            for (int row = 0; row < 3; row++) {
                System.out.println(arr[row][column]);
            }
        }
    }

    public static void testArrayListDeclaration() {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        System.out.println(cars);
        System.out.println(cars.get(0));
    }

    public static void testArrayListOperations() {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo"); //adding element in ArrayList
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        cars.set(1, "Mercedes"); //change element
        cars.remove(2);//Remove element
        System.out.println(cars);
        System.out.println(cars.get(0) /*Aceess element*/);
        //Loop through ArrayList
        for (String i : cars) {
            System.out.println(i);
        }
        Collections.sort(cars); //Sorting ArrayList

        //Loop through ArrayList
        for (String i : cars) {
            System.out.println(i);
        }

        System.out.println("Add with index");
        cars.add(1, "Karuca");
        cars.add("Audi");
        for (String i : cars) {
            System.out.println(i);
        }
    }

    public static void testLinkedListInit() {
        LinkedList<String> cars = new LinkedList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        System.out.println(cars);
        System.out.println(cars.get(0));
    }

    public static void testLinkedListOperations() {
        LinkedList<String> cars = new LinkedList<String>();
        cars.add("Volvo"); //adding element
        cars.addFirst("BMW"); //adding on first position
        cars.addLast("Ford"); //adding on last position
        cars.add(2, "Mazda"); //adding on 3-rd position

        System.out.println(cars);
        System.out.println(cars.get(1));
        System.out.println(cars.getFirst());
        System.out.println(cars.getLast());

        System.out.println(cars);
        cars.remove(); //removes first element
        System.out.println(cars);

        cars.removeFirst(); //removes first element
        System.out.println(cars);

        cars.removeLast(); //removes last element
        System.out.println(cars);

        cars.removeAll(cars); //remove all elements
        System.out.println(cars);
    }

    public static void testQueue() {
        Queue<Integer> queue = new PriorityQueue<>(); // elements of the priority queue are processed according to the priority. The priority is according to the natural ordering.
        //Queue<Integer> queue = new LinkedList<>();

        // Adding items to the queue using add()
        queue.add(10);
        queue.add(20);
        queue.add(15);

        int numElements = queue.size();
        System.out.println("Queue size: " + numElements);
        System.out.println("Queue elements: " + queue);
//        queue.remove();
//        System.out.println("Remove element with remove: " + queue);
        for (int i = 0; i < numElements; i++) {
            // Prints the first element and remove it from the queue
            System.out.println("Removed element: " + queue.poll());
        }
    }

    public static void testStack() {
        Stack<String> elements = new Stack<>();

        // Pushing new items to the top of the Stack
        elements.push("Test1");
        elements.push("Test2");
        elements.push("Test3");
        elements.push("Test4");
        System.out.println("Stack elements: " + elements);

        // Returns top element and remove it from the Stack
        System.out.println("Element removed: " + elements.pop());
        System.out.println("Stack elements: " + elements);


        elements.push("Test5");
        System.out.println("Stack elements: " + elements);
//
//        // Returns top element and remove it from the Stack
//        System.out.println("Element removed: " + elements.pop());
//        System.out.println("Stack elements: " + elements);
//
//        elements.remove(1);
//        System.out.println("Stack elements: " + elements);
    }

    public static void testHashSetIterator() {
        //Creating HashSet and adding elements
        HashSet<String> set = new HashSet();
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        set.add("Five");
        set.add("Two");
        set.add("Two");
        set.add("Two");
        Iterator<String> i = set.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println(set.size());

    }

    public static void testHashSetForEach() {
        HashSet<String> set = new HashSet();
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        set.add("Five");
        set.add("Two");
        set.add("Two");
        set.add("Two");
        for (String i : set) {
            System.out.println(i);
        }
        System.out.println(set.size());
    }

    public static void testHashSetOperations() {
        HashSet<String> set = new HashSet<>();
        set.add("Niki");
        set.add("Ivan");
        set.add("Georgi");
        set.add("Stoyan");
        System.out.println("An initial list of elements: " + set);
        //Removing specific element from HashSet
        set.remove("Ivan");
        System.out.println("After invoking remove(object) method: " + set);
        HashSet<String> set1 = new HashSet<String>();
        set1.add("Ekaterina");
        set1.add("Maya");
        set.addAll(set1);
        System.out.println("Updated List: " + set);
        //Removing all the new elements from HashSet
        set.removeAll(set1);
        System.out.println("After invoking removeAll() method: " + set);
        //Removing elements on the basis of specified condition
        set.removeIf(str -> str.contains("Nik"));
        System.out.println("After invoking removeIf() method: " + set);
        //Removing all the elements available in the set
        set.clear();
        System.out.println("After invoking clear() method: " + set);
    }

    public static void testHashMapEntrySet() {
        //Creating HashMap
        HashMap<Integer, String> map = new HashMap<>();
        //Put elements in Map
        map.put(1, "Mango");
        map.put(2, "Apple");
        map.put(3, "Banana");
        map.put(4, "Grapes");

        System.out.println("Iterating Hashmap...");
        for (Map.Entry m : map.entrySet()) {//entry set returns key-value pairs
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

    public static void testHashMapKeySet() {
        //Creating HashMap
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        //Put elements in Map
        map.put(1, "Mango");
        map.put(2, "Apple");
        map.put(3, "Banana");
        map.put(4, "Grapes");

        for (Integer i : map.keySet()) {//key set returns all keys of the map
            System.out.println(i + " " + map.get(i));
        }
    }

    public static void testHashMapOperations() {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(100, "Ivan");
        hm.put(101, "Georgi");
        hm.put(102, "Stoyan");
        System.out.println("Initial list of elements:");
        for (Map.Entry m : hm.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        System.out.println("Updated list of elements:");
        hm.replace(102, "Miroslav");//replaces the value of a specified key
        for (Map.Entry m : hm.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        System.out.println("Updated list of elements:");
        hm.replace(101, "Georgi", "Anton");//replace the old value of the specified key only if the key is previously mapped with the specified old value
        for (Map.Entry m : hm.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        System.out.println("Updated list of elements:");
        hm.replaceAll((k, v) -> "Asen");//replaces the values of all keys
        for (Map.Entry m : hm.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}