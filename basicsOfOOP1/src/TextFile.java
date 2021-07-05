public class TextFile extends File{

    private String textFileName;
    private String content;
    private Directory parent;

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    @Override
    public String getFileName() {
        return this.textFileName;
    }

    public void setTextFileName(String textFileName) {
        this.textFileName = textFileName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void renameFile(String newName) {
        if(this.parent.searchByFileName(textFileName) == true) {
            this.textFileName = newName;
        }
        else System.out.println("Такого файла не существует");
    }

    @Override
    public void printContent() {
        if(parent.searchByFileName(this.textFileName)) {
            System.out.println(content);
        }
        else System.out.println("Такого файла не существует");
    }

    public void suplementFile(String addition) {
        if(parent.searchByFileName(this.textFileName)) {
            StringBuilder builder = new StringBuilder();
            builder.append(content);
            builder.append(" " + addition);
            this.content = builder.toString();
        }
        else System.out.println("Такого файла не существует");
    }

    @Override
    public void deleteFile() {
        if(parent.searchByFileName(this.textFileName)) {
            parent.deleteFile(this);
        }
        else System.out.println("Такого файла не существует");
    }
}
