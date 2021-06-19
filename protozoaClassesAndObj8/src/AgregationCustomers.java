import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AgregationCustomers {
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public void add (Customer customer){
        customers.add(customer);
    }

    public void buyerList(){
        Comparator<Customer> compareFullName = new CompareBySuname().thenComparing(new CompareByName().thenComparing(new CompareByPatronymic()));
        Collections.sort(this.customers, compareFullName);

        for(Customer c : this.customers){
            System.out.println(c.toString());
        }
    }

    public void creditCardNumRange(long min, long max){

        for(Customer c : customers){
            if(c.getCreditCardNum() >= min && c.getCreditCardNum() <= max){
                System.out.println(c.toString());
            }
        }
    }

    private class CompareByName implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    private class CompareByPatronymic implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
            return o1.getPatronymic().compareTo(o2.getPatronymic());
        }
    }

    private class CompareBySuname implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
            return o1.getSuname().compareTo(o2.getSuname());
        }
    }
}
