public class Sentence {
    private String sentence;

    public StringBuilder builder = new StringBuilder();

    public Sentence(Word ... word){
        for(int i = 0; i < word.length; i++) {
            if(i != word.length - 1) {
                builder.append(word[i].getWord() + " ");
            }
            else builder.append(word[i].getWord() + ".");
        }
        this.sentence = builder.toString();
    }

    public String getSentence() {
        return sentence;
    }
}
