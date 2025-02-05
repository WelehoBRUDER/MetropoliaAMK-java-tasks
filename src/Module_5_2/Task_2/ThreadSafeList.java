package Module_5_2.Task_2;

import java.util.ArrayList;

public class ThreadSafeList<T> extends ArrayList<T> {

    @Override
    public synchronized boolean add(T e) {
        return super.add(e);
    }

    @Override
    public synchronized T remove(int index) {
        return super.remove(index);
    }

    @Override
    public synchronized int size() {
        return super.size();
    }
}
