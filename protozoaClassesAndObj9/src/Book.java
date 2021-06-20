public class Book {
    private long id;
    private String title;
    private String author;
    private String publishingHouse;
    private short yearPablishing;
    private short numberOfPage;
    private short price;
    private String bindingType;


    public Book(long id, String title, String author, String publishingHouse, short yearPablishing, short numberOfPage, short price, String bindingType) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.yearPablishing = yearPablishing;
        this.numberOfPage = numberOfPage;
        this.price = price;
        this.bindingType = bindingType;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public short getYearPablishing() {
        return yearPablishing;
    }

    public void setYearPablishing(short yearPablishing) {
        this.yearPablishing = yearPablishing;
    }

    public short getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(short numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public short getPrice() {
        return price;
    }

    public void setPrice(short price) {
        this.price = price;
    }

    public String getBindingType() {
        return bindingType;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", yearPablishing=" + yearPablishing +
                ", numberOfPage=" + numberOfPage +
                ", price=" + price +
                ", bindingType='" + bindingType + '\'' +
                '}';
    }
}
