package thread.practice;

class Printer {
    boolean isOdd;

    /*
    Critical section or common space that need to be synchronized
     */
    public synchronized void printEven(int i) throws InterruptedException {
//        System.out.println("printEven()");
        while (isOdd) {
            wait();
        }
        System.out.println("Print Even" + i);
        isOdd=true;
        notify();
    }

    public synchronized void printOdd(int i) throws InterruptedException {
//        System.out.println("printOdd()");
        while (!isOdd) {
            wait();
        }
        System.out.println("Print Odd" + i);
        isOdd=false;
        notify();
    }
}

class EvenThread implements Runnable {
    Printer printer;

    EvenThread(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i = i + 2) {
            try {
                printer.printEven(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class OddThred implements Runnable {
    Printer printer;

    OddThred(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i = i + 2) {
            try {
                printer.printOdd(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


public class OddEventhread {

    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        Thread t1 = new Thread(new EvenThread(printer));
        Thread t2 = new Thread(new OddThred(printer));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
