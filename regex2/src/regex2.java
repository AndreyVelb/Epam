
//2. Дана строка, содержащая следующий текст (xml-документ):
//<notes>
//  <note id = "1">
//      <to>Вася</to>
//      <from>Света</from>
//      <heading>Напоминание</heading>
//      <body>Позвони мне завтра!</body>
//  </note>
//      <note id = "2">
//      <to>Петя</to>
//      <from>Маша</from>
//      <heading>Важное напоминание</heading>
//      <body/>
//  </note>
//</notes>
//Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
//тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
//нельзя.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex2 {
    public static void main(String[] args) {
        String xmlText = """
                <notes>
                   <note id = "1">
                       <to>Вася</to>
                       <from>Света</from>
                       <heading>Напоминание</heading>
                       <body>Позвони мне завтра!</body>
                   </note>
                   <note id = "2">
                       <to>Петя</to>
                       <from>Маша</from>
                       <heading>Важное напоминание</heading>
                       <body/>
                   </note>
                </notes>
                """;
        analizatorXMl(xmlText);
    }
    private static void analizatorXMl(String xmlText){
        String [] arrXMLStr = xmlText.split("\n");
        Pattern openTag = Pattern.compile("<\\w+>");
        Pattern closeTag = Pattern.compile("<\\/\\w+>");
        Pattern noBodyTag = Pattern.compile("<\\w+/>");

        Pattern tagWithAtribut = Pattern.compile("<\\w+ \\w+ \\= \\\"\\w+\\\">");
        Pattern namesAtributTag = Pattern.compile("<\\w+ ");
        Pattern namesAtribut = Pattern.compile(" \\w+ ");
        Pattern valuesAtribut = Pattern.compile("\\\"[1-9]\\\"");

        Pattern tagWithChars = Pattern.compile("\\b[а-яёА-Яё!?.,\\s]+");

        for(int i = 0; i < arrXMLStr.length; i++){
            Matcher matchOpenTag = openTag.matcher(arrXMLStr[i]);
            Matcher matchCloseTag = closeTag.matcher(arrXMLStr[i]);
            Matcher matchNoBodyTag = noBodyTag.matcher(arrXMLStr[i]);

            Matcher tagAtribut = tagWithAtribut.matcher(arrXMLStr[i]);
            Matcher nameAtributTag = namesAtributTag.matcher(arrXMLStr[i]);
            Matcher nameAtribut = namesAtribut.matcher(arrXMLStr[i]);
            Matcher valueAtribut = valuesAtribut.matcher(arrXMLStr[i]);

            if(tagAtribut.find() && nameAtributTag.find() && nameAtribut.find() && valueAtribut.find()){
                String nameAtrTag = nameAtributTag.group();
                String nameAtr = nameAtribut.group();
                String valueAtr = valueAtribut.group();
                System.out.println("Тэг " + nameAtrTag + " с атрибутом " + nameAtr +
                                   "значение которого равно " + valueAtr + " открыт");
                continue;
            }

            Matcher charactersSet = tagWithChars.matcher(arrXMLStr[i]);
            if( charactersSet.find() && matchCloseTag.find() && matchOpenTag.find()){
                String nameTag = matchOpenTag.group();
                String charSet = charactersSet.group();
                String nameCloseTag = matchCloseTag.group();
                System.out.println("Тэг " + nameTag + " открыт. В нем заключен текст \""
                        + charSet +"\" Тэг " + nameCloseTag + " закрыт");
                continue;
            }

            if(matchOpenTag.find()){
                String tegName = matchOpenTag.group();
                System.out.println("Тэг " + tegName + " открыт");
                continue;
            }
            if(matchCloseTag.find()){
                String tegName = matchCloseTag.group();
                System.out.println("Тэг " + tegName + " закрыт");
                continue;
            }
            if(matchNoBodyTag.find()){
                String tegName = matchNoBodyTag.group();
                System.out.println("Тэг без тела " + tegName);
            }
        }

    }
}
