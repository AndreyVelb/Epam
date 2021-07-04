import java.util.Comparator;

public class BankAccount {
    private String name;
    private String bank;
    private boolean isBlocked;
    private double accountAmount;

    public String getName() {
        return name;
    }

    public void isBlocked(BankAccount account) {
        if(account.isBlocked) System.out.println("Account "+name+" is blocked");
        else System.out.println("Account "+name+" isn't blocked");
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public double getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(double accountAmount) {
        this.accountAmount = accountAmount;
    }

    public BankAccount(String name, String bank, boolean isBlocked, double accountAmount) {
        this.name = name;
        this.bank = bank;
        this.isBlocked = isBlocked;
        this.accountAmount = accountAmount;
    }

    @Override
    public String toString() {
        String s = "Bank account № " + name + " " + bank  + "have in the score " + accountAmount;
        return s;

    }

}
