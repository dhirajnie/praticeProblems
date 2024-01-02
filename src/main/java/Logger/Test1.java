package Logger;

public class Test1 {


    public static void main(String[] args) {
        LoggerSvc loggerSvcinti = new LoggerSvc("");

        Logger logger = new LoggerImpl(loggerSvcinti);

        for(int i =0;i<100;i++)
        logger.info("test"+i);
    }
}
