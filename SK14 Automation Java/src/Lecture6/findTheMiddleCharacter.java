package Lecture6;

public class findTheMiddleCharacter {
        public static void main(String[] args) {
            String message = "Tsveta";
            int middleIndex = message.length() / 2;
            char middleChar = message.charAt(middleIndex);

            System.out.println("The middle character is: " + middleChar);
        }
    }

