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

    }

    @Override
    public void error(String logStr) {

    }
}
