public class Counter implements AutoCloseable{
    private static Integer count;
    private static Counter counter;
    private Counter(){}

    public static Counter startCounter(){
        if(counter == null) {
            counter = new Counter();
            counter.count = 0;
            return counter;
        }
        return counter;
    }
    public void add(){
        count++;
    }
    public void remove(){
        count--;
    }
    public Integer getSize(){
        return count;
    }
    @Override
    public void close() throws Exception {

    }
}
