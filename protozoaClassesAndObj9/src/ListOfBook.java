import java.util.ArrayList;

public class ListOfBook {
    private ArrayList<Book> listOfBook = new ArrayList<Book>();

    public void add(Book book){
        this.listOfBook.add(book);
    }

    public void geAuthorsBooks(String authorName){
        for(int i = 0; i < listOfBook.size(); i++){
            if(this.listOfBook.get(i).getAuthor().compareTo(authorName) == 0){
                System.out.println(listOfBook.get(i).toString());
            }
        }
    }

    public void getPublishersBooks(String publishing){
        for(int i = 0; i < listOfBook.size(); i++){
            if(this.listOfBook.get(i).getPublishingHouse().compareTo(publishing) == 0){
                System.out.println(listOfBook.get(i).toString());
            }
        }
    }

    public void getBooksIssuedAfterYear(int year){
        for(int i = 0; i < listOfBook.size(); i++){
            if(this.listOfBook.get(i).getYearPablishing() > year){
                System.out.println(listOfBook.get(i).toString());
            }
        }
    }
}
