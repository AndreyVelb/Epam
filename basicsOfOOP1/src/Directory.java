import java.util.ArrayList;
import java.util.List;

public class Directory {
    String directoryName;
    List<File> scroll;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        scroll = new ArrayList<>();
    }

    public TextFile createTextFile(String name, String content){
        TextFile textFile = new TextFile();
        textFile.setTextFileName(name);
        textFile.setContent(content);
        textFile.setParent(this);
        this.scroll.add(textFile);
        return textFile;
    }

    public void deleteFile(File file){
        scroll.remove(file);
    }

    public boolean searchByFileName(String fileName){
        for (File f : scroll){
            if(f.getFileName() == fileName){
                return true;
            }
        }
        return false;
    }
}
