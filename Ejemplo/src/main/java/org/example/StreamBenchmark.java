package org.example;
import org.openjdk.jmh.annotations.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@State(Scope.Benchmark)
public class StreamBenchmark {
    private List<Integer> list;
    @Setup(Level.Trial)
    public void setup(){
        int size = 10000000;
        Random random = new Random();
        list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(1, 50000));
        }
    }

    @Benchmark
    public List<Integer> resultSecuencialBenchmark(){
        return list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    @Benchmark
    public List<Integer> resultParaleloBenchmark(){
        return list.parallelStream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }
}
