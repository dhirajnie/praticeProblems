package Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLOutput;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class LoggerSvc {

    OutputStream object;

    LoggerSvc(String fileName) {
        try {
            object = new FileOutputStream("./files/abc.txt");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addLog(String data, String processId) throws ExecutionException, InterruptedException, IOException {
        object.write((processId+data).getBytes());
        CompletableFuture.runAsync(() -> flushAll()).get();
    }

    public void flushAll() {
        try {
            object.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
