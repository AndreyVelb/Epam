public abstract class File {
    private String fileName;
    Directory parent;

    public File(String fileName, Directory parent) {
        this.fileName = fileName;
        this.parent = parent;
    }

    public abstract String getFileName();

    public File(){
        this.fileName = fileName;
    }

    public void renameFile(String newName){
        this.fileName = newName;
    }

    public abstract void printContent();

    public void suplementFile(){};

    public abstract void deleteFile();
}
