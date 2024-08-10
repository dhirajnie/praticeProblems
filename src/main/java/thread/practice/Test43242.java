package thread.practice;

import java.util.concurrent.CompletableFuture;

public class Test43242 {


    public static void main(String[] args) {
        CompletableFuture<String> firstP = CompletableFuture.supplyAsync(()->{
            System.out.println("First process");
            return "Success";
        }).exceptionally(e->{
            System.out.println(e);
            return "Exception occured";
        });


    }
}
