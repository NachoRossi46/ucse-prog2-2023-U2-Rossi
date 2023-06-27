package org.example;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args)  throws RunnerException, Exception{
        Options options = new OptionsBuilder()
                .include(StreamBenchmark.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(10)
                .forks(1)
                .build();

        new Runner(options).run();

        // Ejercicio 3:
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> generarNumeroAleatorio());
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> generarNumeroAleatorio());
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> generarNumeroAleatorio());
        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> generarNumeroAleatorio());

        CompletableFuture<Integer> allFutures = CompletableFuture.allOf(future1, future2, future3, future4)
                .thenApplyAsync(v -> {return future1.join() + future2.join() + future3.join() + future4.join();});

        int sum = allFutures.get();
        System.out.println("La suma es: " + sum);

        //Ejercicio 4
        CompletableFuture<Integer> futureMasRapido = CompletableFuture.anyOf(future1, future2, future3, future4)
                .thenApplyAsync(result -> (Integer) result);

        int valor = futureMasRapido.get();
        System.out.println("Valor de la tarea más rápida: " + valor);
    }

    private static int generarNumeroAleatorio() {
        return ThreadLocalRandom.current().nextInt(100, 500);
    }
}