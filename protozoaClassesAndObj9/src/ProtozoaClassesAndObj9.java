
//9. Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
//метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
//методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
//Найти и вывести:
//a) список книг заданного автора;
//b) список книг, выпущенных заданным издательством;
//c) список книг, выпущенных после заданного года.

public class ProtozoaClassesAndObj9 {
    public static void main(String[] args) {
        Book book1 = new Book((long)213, "Java.Полное руководство", "Шилдт", "Moskow_publishing", (short) 2020,(short) 1600,(short) 120, "hard cover");
        Book book2 = new Book((long)214, "12 правил жизни", "Питерсон", "SP_publishing", (short) 2019,(short) 600,(short) 60, "soft cover");
        Book book3 = new Book((long)216, "Метаморфозы", "Овидий", "Moskva", (short) 1985,(short) 500,(short) 45, "hard cover");

        ListOfBook listOfBook = new ListOfBook();
        listOfBook.add(book1);
        listOfBook.add(book2);
        listOfBook.add(book3);

        listOfBook.geAuthorsBooks("Шилдт");
        listOfBook.getPublishersBooks("Moskva");
        listOfBook.getBooksIssuedAfterYear(1985);
    }
}
