package Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.StandardOpenOption;
import java.sql.SQLOutput;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class LoggerSvc {

    FileOutputStream object;
    long charCount=0;
    LoggerSvc(String fileName) {
        try {
            File file = new File(fileName);
            file.createNewFile();
            object = new FileOutputStream(fileName);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addLog(String data, String processId) throws ExecutionException, InterruptedException, IOException {
        this.charCount += (processId+data).length();
        object.write((processId+data).getBytes());
        System.out.println("Add log start");

        if(charCount>1000){
            CompletableFuture.runAsync(() -> flushAll()).get();
        }
        System.out.println("Add log end");
    }

    public void flushAll() {
        try {
            System.out.println("Flush called");
            object.flush();
            this.charCount =0;
//            object.close();
            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
