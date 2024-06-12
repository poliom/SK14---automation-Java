package Lecture9;

import java.util.List;

public class Italian extends Person {
    public Italian(String name, String religion, String language, String nationality, String sex, String egn, boolean hasJob, String jobTitle, String country) {
            super(name, religion, "Italian","Italian", sex, egn,hasJob, jobTitle, country);
    }

    @Override
    public void sayHello() {
        System.out.println("Ciao!");
    }

    public void makePizza(List<String> ingredients) {
        System.out.println("I am making a pizza with the following ingredients: " + ingredients);
    }
}
