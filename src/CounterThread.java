/**
 * Created by Admin on 18.02.2016.
 */
public class CounterThread implements Runnable {
    private CounterClass parent;
    private int ending;
    private boolean hasEnded = false;

    public CounterThread(CounterClass parent, int ending) {
        this.ending = ending;
        this.parent = parent;
    }

    @Override
    public void run() {
        synchronized (parent) {
            while (!hasEnded) {
                if (parent.dataInt > ending) {
                    break;
                }
                System.out.println(parent.dataInt);
                parent.dataInt++;

            }
        }
        this.stop();
    }

    public void stop() {
        hasEnded = true;
    }
}
