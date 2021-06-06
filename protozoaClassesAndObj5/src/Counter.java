public class Counter {
    private int min;
    private int max;
    private int current;

    public int getCurrent() {
        return current;
    }

    public Counter(int min, int max, int current){
        this.min = min;
        this.max = max;
        this.current = current;

        if (max < min) {
            int tmp = max;
            max = min;
            min = tmp;
        }

        if (current < min)
            current = min;
        if (current > max)
            current = max;
    }

    public Counter(int min,int max){
        this.min = min;
        this.max = max;

        if (max < min) {
            int tmp = max;
            max = min;
            min = tmp;
        }

        this.current = min;
    }

    public Counter(){
        this(0,10,0);
    }

    public void increment(int steps){
        for(int i = 0; i < steps; i++) {
            current++;
            if (current > max)
                current = min;
        }
    }

    public void decrement(int steps){
        for(int i = 0; i < steps; i++) {
            current--;
            if (current < min)
                current = max;
        }
    }
}
