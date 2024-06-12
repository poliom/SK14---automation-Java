package Lecture9;

import java.time.LocalDate;

public class Person {
    private final String name;
    private final String  religion;
    private final String language;
    private final String nationality;
    private String sex;
    private String egn;
    private String birthDate;
    private int age;
    private String  jobTitle;
    private boolean hasJob;
    private String country;

    public Person(String name, String religion, String language, String nationality, String sex, String egn, boolean hasJob, String jobTitle, String country) {
        this.name = name;
        this.religion = religion;
        this.language = language;
        this.nationality = nationality;
        this.hasJob = hasJob;
        this.jobTitle = jobTitle;
        this.country = country;
        setEgn(egn);
        setAge(egn);
        setBirthDate(egn);
        setSex(sex);
    }

    private void setAge(String egn){
        // Get current year
        int currentYear = LocalDate.now().getYear();
        // Calculate the age
        this.age = currentYear - Integer.parseInt(personBirthYear(egn));
    }

    private void setBirthDate(String egn){
        // Get the month part of egn
        String month = egn.substring(2,4);
        // Get the date part of egn
        String date = egn.substring(4,6);
        this.birthDate = personBirthYear(egn) + "-" + month + "-" + date;
    }

    private void setEgn(String egn){
        if (egn.length() == 10 && containsOnlyDigits(egn)){
            this.egn = egn;
        } else {
            throw new RuntimeException("The provided EGN is not Valid! The EGN must contain only 10 digits!");
        }
    }

    private void setSex(String sex){
        try {
            validateSex(sex);
            this.sex = sex;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private void validateSex(String sex) throws Exception {
        String male = "Male";
        String female = "Female";

        // ! -> reverse if sex.equalsIgnoreCase(male) is true will be false for second is the same
        if (!sex.equalsIgnoreCase(male) && !sex.equalsIgnoreCase(female)){
            throw new Exception("Please provide a valid value for sex. Valid options are 'male' or ' female'.");
        }
    }

    private boolean containsOnlyDigits(String egn) {
        try {
            if (egn.contains("-") || egn.contains("+")){
                return false;
            }
            Long.parseLong(egn);
            //return true; // option 1
        } catch(NumberFormatException ex){
            return false;
        }
        return true; // option 2
    }

    private String personBirthYear(String egn){
        // Get the year part of egn
        String secondPartOfBirthYear = egn.substring(0,2);
        // Get the month part of egn
        String month = egn.substring(2,4);

        String birthYear;

        if (month.startsWith("4") || month.startsWith("5")){
            birthYear = "20" + secondPartOfBirthYear;
        }
        else {
            birthYear = "19" + secondPartOfBirthYear;
        }

        return birthYear;
    }

    public void setHasJob(boolean hasJob){
        this.hasJob = hasJob;
    }
    public void setJobTitle(String jobTitle){
        this.jobTitle = jobTitle;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getBirthDate(){
        return this.birthDate;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getCountry() {
        return country;
    }

    public void sayHello(){
        if (language.equalsIgnoreCase("English")){
            System.out.println("Hello!");
        } else if (language.equalsIgnoreCase("Italian")) {
            System.out.println("Ciao!");
        } else if (language.equalsIgnoreCase("Bulgarian")){
            System.out.println("Здравей!");
        }

//        switch (language){
//            case "Bulgarian":
//            case "bulgarian":
//                System.out.println("Чао!");
//                break;
//            case "Italian":
//                System.out.println("Ciao!");
//                break;
//            default:
//                System.out.println("Hello!");
//        }
    }

    public void celebrateEaster(){
        if (religion.equalsIgnoreCase("Orthodox") || religion.equalsIgnoreCase("Catholic")){
            System.out.println("I am celebrating Easter");
        }else {
            System.out.println("I am not celebrating Easter");
        }
    }

    public boolean isAdult(){
        switch (country){
            case "Bulgaria":
            case "Italy":
                if (age >= 18){
                    return true;
                }
                else {
                    return false;
                }
            case "USA":
                return age >= 21;
            default:
                throw new RuntimeException("We don`t have information about country: " + country);
        }
    }

    public boolean canTakeLoan(){
        return hasJob;
    }
}
