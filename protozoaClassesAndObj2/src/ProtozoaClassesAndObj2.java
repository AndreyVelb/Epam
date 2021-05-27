public class ProtozoaClassesAndObj2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.setA(6);
        test2.setB(4);
        System.out.println(test2.getA() + test2.getB());
    }
}
class Test2{
    private int a;
    private int b;
    public Test2(){
    }
    public Test2(int a, int b){
        this.a = a;
        this.b = b;
    }
    public void setA(int a) {
        this.a = a;
    }
    public void setB(int b) {
        this.b = b;
    }
    public int getA() {
        return a;
    }
    public int getB() {
        return b;
    }
}
