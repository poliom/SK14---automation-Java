package Lecture6;

public class countAllWords {
        public static void main(String[] args) {
            String sentence = "My name is Tsveta";

            int wordCount = countWords(sentence);

            System.out.println("The number of words is: " + wordCount);
        }

        public static int countWords(String sentence) {
            String[] words = sentence.split("\\s+");
            return words.length;
        }
    }

