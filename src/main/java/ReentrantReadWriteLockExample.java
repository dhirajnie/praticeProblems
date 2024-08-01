import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    private int sharedResource = 0;

    public void write(int value) {
        writeLock.lock();
        try {
            sharedResource = value;
            System.out.println("Written " + value);
        } finally {
            writeLock.unlock();
        }
    }

    public int read() {
        readLock.lock();
        try {
            System.out.println("Read " + sharedResource);
            return sharedResource;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockExample example = new ReentrantReadWriteLockExample();

        // Writing to the resource
        new Thread(() -> example.write(1)).start();
        new Thread(() -> example.write(2)).start();

        // Reading from the resource
        new Thread(() -> example.read()).start();
        new Thread(() -> example.read()).start();
    }
}
