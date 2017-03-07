package benchmarks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class HashMapBenchmark {
    private static final int MAP_SIZE = 100;

    @Benchmark
    public void testInsert(Blackhole bh) {
        Map<Integer, String> map = new HashMap<>(MAP_SIZE);
        for (int i = 1; i < MAP_SIZE; i++) {
            map.put(i, Integer.toString(i));
        }
        bh.consume(map);
    }

    @Benchmark
    public void testLookup(Blackhole bh, FilledMap filledMap) {
        Map<Integer, String> map = filledMap.map;
        for (int i = 1; i < MAP_SIZE; i++) {
            bh.consume(map.get(i));
        }
    }

    @Benchmark
    public void testDelete(Blackhole bh, FilledMap filledMap) {
        Map<Integer, String> map = new HashMap<>(filledMap.map);
        for (int i = 1; i < MAP_SIZE; i++) {
            map.remove(i);
        }
        bh.consume(map);
    }

    @State(Scope.Benchmark)
    public static class FilledMap {
        public Map<Integer, String> map = new HashMap<>(MAP_SIZE);

        public FilledMap() {
            for (int i = 1; i < MAP_SIZE; i++) {
                map.put(i, Integer.toString(i));
            }
        }
    }
}
