package Lecture8.examples.encapsulation;

public class Examples {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("Ivan Ivanov");
        double balance = bankAccount.getAccountBalance();
        String accNum = bankAccount.getAccountNumber();

        System.out.println(bankAccount.getOwnerName() + " " + balance + " " + accNum);
        bankAccount.setOwnerName("Vidko Videv");
        System.out.println(bankAccount.getOwnerName() + " " + balance + " " + accNum);

        bankAccount.makeTransaction(200);
        balance = bankAccount.getAccountBalance();
        System.out.println(bankAccount.getOwnerName() + " " + balance + " " + accNum);
    }
}
