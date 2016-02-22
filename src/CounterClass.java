import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Admin on 18.02.2016.
 */
public class CounterClass {
    private int endingpoint;
    int cpus = 0;
    ExecutorService threadPool;
    public Integer dataInt;
    private ArrayList<CounterThread> data;

    public CounterClass(int startingpoint, int endingpoint) {
        this.endingpoint = endingpoint;
        this.dataInt = new Integer(startingpoint);

        Runtime rnt = Runtime.getRuntime();
        cpus = rnt.availableProcessors();
        threadPool = Executors.newFixedThreadPool(cpus);
        data = new ArrayList<>();
        for (int i = 0; i < cpus; i++) {
            data.add(new CounterThread(this, endingpoint));
        }
    }

    public void calculate() throws InterruptedException {
        for (CounterThread run : data) {
            threadPool.execute(new Thread(run));
        }
    }
}
