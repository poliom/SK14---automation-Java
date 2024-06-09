package Lecture9;

public class Italian extends Person {

        public Italian (String name, String religion, String language, String nationality, String sex, String egn, boolean hasJob, String jobTitle, String country) {
            super(name, religion, language, nationality, sex, egn, hasJob, jobTitle, country);
        }

        @Override
        public boolean isAdult(){
            System.out.println("Carla is an adult.");
            return true;
        }

        @Override
        public boolean canTakeLoan(){
            System.out.println("Carla is and adult and can take a loan.");
            return true;
        }

        public void hasJob (String doctor){
            System.out.println("Carla is a doctor and she is a very hardworking doctor" );
        }

        public void hasPasta (String pasta){
            System.out.println("In Italy they have the best gelato in the world and also pasta");
        }

        public void sayHello (String s) {
        System.out.println("Ciao, bella, mi piace vederti!");
    }
    }

