
//1. Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
//консоль текст, заголовок текста.

public class AggregationAndComposition1 {
    public static void main(String[] args) {
        Word mama = new Word("мама");
        Word mula = new Word("мыла");
        Word ramu = new Word("раму");
        Word rama = new Word("рама");
        Word bula = new Word("была");
        Word chistoy = new Word("чистой");

        Sentence sentence1 = new Sentence(mama, mula, ramu);
        Sentence sentence2 = new Sentence(rama, bula, chistoy);

        Text text = new Text(mama, sentence1,sentence2);

        text.printText();


    }


}
