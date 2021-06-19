public class Customer {
    private long id;
    private String name;
    private String suname;
    private String patronymic;
    private String address;
    private long creditCardNum;
    private long bankAccountNum;

    Customer(long id, String suname, String name, String patronymic, String address, long creditCardNum, long bankAccountNum){
        this.id = id;
        this.name = name;
        this.suname = suname;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCardNum = creditCardNum;
        this.bankAccountNum = bankAccountNum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuname() {
        return suname;
    }

    public void setSuname(String suname) {
        this.suname = suname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(long creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public long getBankAccountNum() {
        return bankAccountNum;
    }

    public void setBankAccountNum(long bankAccountNum) {
        this.bankAccountNum = bankAccountNum;
    }

    @Override
    public String toString() {
        String result = this.id + " Гражданин " + this.suname + " " + this.name + " " + this.patronymic + ", живущий по адресу " + this.address
        + " имеет кредитную карту с номером " + this.creditCardNum + " и банковский счет № " + this.bankAccountNum;
        return result;
    }
}
