package thread.practice;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Test43242 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> firstP = CompletableFuture.supplyAsync(() -> {
            System.out.println("First process");
            return "Success";
        }).exceptionally(e -> {
            System.out.println(e);
            return "Exception occured";
        });
        CompletableFuture<String> otherProcess = firstP.thenApply((x) -> {
            return "ok" + x;
        });
        otherProcess.whenComplete((success, exception) -> {
            System.out.println("When completed" + success);
            if (exception != null) {
                System.out.println(success);
            }
        });
    }

}
