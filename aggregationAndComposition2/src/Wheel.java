public class Wheel {
    private String position;

    public Wheel(String position){
        this.position = position;
    }

    public void changeWheel(){
        System.out.println(this.position + " колесо заменено.");
    }
}
