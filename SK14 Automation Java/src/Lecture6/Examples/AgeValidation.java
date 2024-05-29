package Lecture6.Examples;

import java.util.Scanner;

public class AgeValidation {
    public boolean IsUserAdult(){
//        Full code implementation
//        boolean isAdult;
//        if (age >= 18){
//            isAdult = true;
//        }
//        else{
//            isAdult = false;
//        }
//        Short code implementation
        boolean isAdult = false;
        if (age >= 18){
            isAdult = true;
        }
        return isAdult;
    }
    // variable used only into this class
    private int age;
    // for every variable should be created get and set methods
    private String birthYear = "1500";
    // Get method
    public int getAge(){
        return age;
    }
    // Set method
    public void setAge(int age){
        if (age >= 0){
            this.age = age;
        }
    }
    public String getBirthYear(){
        return birthYear;
    }
    public  void setBirthYear(String birthYear){
        this.birthYear = birthYear;
    }
}
