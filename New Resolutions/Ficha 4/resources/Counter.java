
public class Counter {

    private long count = 0;

    public void add(long value) {
        this.count += value;
    }

    public long get_count() {
        return count;
    }
}
