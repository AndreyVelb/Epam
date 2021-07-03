public class Text {
    private String headText;
    private String bodyText;

    public Text(Word word, Sentence ... sentences){
        this.headText = word.getWord();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sentences.length; i++){
            builder.append(sentences[i].getSentence() + " ");
        }
        this.bodyText = builder.toString();
    }

    public void printHeadText() {
        System.out.println(headText);
    }

    public void printText() {
        System.out.println(headText);
        System.out.println();
        System.out.println(bodyText);
    }

    public void suplementText(Sentence sentence){
        StringBuilder builder = new StringBuilder(bodyText);
        builder.append(sentence);
        this.bodyText = builder.toString();
    }
}
