
//Задача 1.
//Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
//вывести на консоль содержимое, дополнить, удалить.

public class BasicsOfOOP1 {
    public static void main(String[] args) {
        Directory demon = new Directory("Демон, М.Ю. Лермонтов");

        TextFile firstStr = demon.createTextFile("Первая строка", "Печальный Демон, дух изгнанья,");
        TextFile thirdStr = demon.createTextFile("Третья строка", "И лучших дней воспоминанья");

        firstStr.renameFile("Изменное название");
        System.out.println(firstStr.getFileName());

        firstStr.printContent();

        firstStr.suplementFile("Дополненный текст");
        firstStr.printContent();

        firstStr.deleteFile();
        firstStr.renameFile("ffffffffffff");
    }
}
