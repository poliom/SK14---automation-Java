package Lecture7.constructors;

public class Employee {
    public String firstName;
    private String lastName;
    private int birthYear;

    public Employee() {
    }

    public Employee(String firstName, String lastName1, int birthYear) {
        this.firstName = firstName;
       lastName = lastName1;
        this.birthYear = birthYear;
    }

    public Employee(String firstName) {
        this(firstName, "Ninovi", 1990);
    }

    public Employee(String firstName, String lastName) {
        this(firstName, lastName, -1);
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setBirthYear(int birthYear){
        this.birthYear = birthYear;
    }

    public int getBirthYear() {
        return birthYear;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
}