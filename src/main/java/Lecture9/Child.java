package Lecture9;

public class Child extends Person{

    public Child(String name, String religion, String language, String nationality, String sex, String egn, boolean hasJob, String jobTitle, String country) {
        super(name, religion, language, nationality, sex, egn, hasJob, jobTitle, country);
    }

    @Override
    public boolean isAdult(){
        System.out.println("The child is not an adult.");
        return false;
    }

    @Override
    public boolean canTakeLoan(){
        System.out.println("The child can not take a loan");
        return false;
    }

    public void setHasJob(boolean hasJob){
        throw new IllegalArgumentException("The child cannot have a job");
    }

    public void play(String toy){
        System.out.println("I am playing with a " + toy);
    }
}
