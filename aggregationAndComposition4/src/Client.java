import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Client {
    private String name;
    private String surname;
    private List<BankAccount> accounts = new ArrayList<BankAccount>();
    private Comparator<BankAccount> compareByAmount = new CompareByAccountAmount();

    public Client(String name, String surname,  BankAccount ... allUsersAccounts) {
        this.name = name;
        this.surname = surname;
        for (int i = 0; i < allUsersAccounts.length; i++) {
            accounts.add(allUsersAccounts[i]);
        }
    }

    public double totalAmount(){
        double total = 0;
        for(BankAccount ac : accounts) {
            total += ac.getAccountAmount();
        }
        return total;
    }

    public double totalAmountByPositiveAccount(){
        double total = 0;
        for(BankAccount ac : accounts) {
            if(ac.getAccountAmount() > 0) {
                total += ac.getAccountAmount();
            }
        }
        return total;
    }

    public double totalAmountByNegativeAccount(){
        double total = 0;
        for(BankAccount ac : accounts) {
            if(ac.getAccountAmount() < 0) {
                total += ac.getAccountAmount();
            }
        }
        return total;
    }

    public void compareByAmount(){
        Collections.sort(accounts,compareByAmount);
        for (BankAccount ac : accounts){
            System.out.println(ac.toString());
        }
    }

    public void searchByAccountNumber(String accountNumber){
        for(BankAccount ac : accounts){
            if(ac.getName().equals(accountNumber)){
                System.out.println(ac.toString());
                return;
            }
        }
        System.out.println("This account isn'n found.");

    }

    private class CompareByAccountAmount implements java.util.Comparator<BankAccount>{

        @Override
        public int compare(BankAccount o1, BankAccount o2) {
            if(o1.getAccountAmount() > o2.getAccountAmount())return 1;
            else if (o1.getAccountAmount() < o2.getAccountAmount()) return -1;
            else return 0;
        }
    }
}
