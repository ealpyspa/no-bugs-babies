package practice_1;

public class BankAccount implements Printable {
    private String bankAccount;
    private int balance;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    @Override
    public void print() {
        System.out.println("Account balance is: " + this.balance);
    }
}
