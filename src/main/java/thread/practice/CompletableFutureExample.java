package thread.practice;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(String[] args) {
        // Asynchronous task without returning a result
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("Task 1: Running in a separate thread...");
            sleep(1000); // Simulating a long-running task
            System.out.println("Task 1: Completed");
        });

        // Asynchronous task that returns a result
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 2: Running in a separate thread...");
            sleep(2000); // Simulating a long-running task
            return "Task 2: Result";
        });

        // Processing the result of future2 when it completes
        CompletableFuture<String> future3 = future2.thenApply(result -> {
            System.out.println("Task 2: Result received, processing...");
            return result + " -> Processed";
        });

        // Handling the result of future3 and chaining another task
        CompletableFuture<Void> future4 = future3.thenAccept(result -> {
            System.out.println("Task 3: Final result: " + result);
        });

        // Combine results of two futures
        CompletableFuture<Void> combinedFuture = future2.thenCombine(future3, (result2, result3) -> {
            System.out.println("Task 4: Combining results: " + result2 + " and " + result3);
            return "Combined: " + result2 + " & " + result3;
        }).thenAccept(combinedResult -> {
            System.out.println("Task 4: Final combined result: " + combinedResult);
        });

        // Wait for all tasks to complete
        CompletableFuture<Void> allOf = CompletableFuture.allOf(future1, future4, combinedFuture);
        try {
            allOf.get(); // Wait for all futures to complete
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed!");
    }

    // Helper method to simulate a delay
    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
