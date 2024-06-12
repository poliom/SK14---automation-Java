package Lecture9;

public class American extends Person {
    public American(String name, String religion, String language, String nationality, String sex, String egn, boolean hasJob, String jobTitle, String country) {
        super(name, religion, "English","American", sex, egn,hasJob, jobTitle, country);
    }

    public void celebrateThanksgiving() {
        System.out.println("I am celebrating Thanksgiving on the fourth Tuesday in November");
    }
}
