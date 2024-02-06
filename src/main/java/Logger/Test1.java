package Logger;

public class Test1 {


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        LoggerSvc loggerSvcinti = new LoggerSvc("/Users/dhiraj/logger.txt");
        Logger logger = new LoggerImpl(loggerSvcinti);

        for (int i = 0; i < 100; i++)
            logger.info("A" + i+"\n");



        for (int i = 100; i < 1000; i++)
            logger.info("B" + i+"\n");
        long endTime = System.currentTimeMillis();
        System.out.println("Total TIme " + (endTime - startTime));

    }
}
