package Logger;

import java.lang.reflect.Constructor;

public class LoggerImpl implements Logger {

    LoggerSvc loggerSvc;
    String processId;

    LoggerImpl(LoggerSvc loggerSvc){
        this.loggerSvc = loggerSvc;
    }

    @Override
    public void info(String logStr) {
        try {
            this.loggerSvc.addLog(logStr, processId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public void error(String logStr) {

    }
}
