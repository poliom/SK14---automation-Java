package Lecture9;

public class Bulgarian extends Person {

        public Bulgarian(String name, String religion, String language, String nationality, String sex, String egn, boolean hasJob, String jobTitle, String country) {
            super(name, religion, language, nationality, sex, egn, hasJob, jobTitle, country);
        }

        @Override
        public boolean isAdult(){
            System.out.println("Tsveti is an adult.");
            return true;
        }

        @Override
        public boolean canTakeLoan(){
            System.out.println("Tsveti is and adult and can take a loan.");
            return true;
        }

        public void dance(String salsa){
            System.out.println("Tsveti is a dancer and she is dancing " + salsa);
        }

        public void hasWinter(String winter){
            System.out.println("In Bulgaria there are four seasons: spring, summer, autumn and " + winter);
        }

    public void sayHello (String s) {
        System.out.println("Здравейте, радвам се да ви видя!");
    }
}

