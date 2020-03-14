package org.medellinjug;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.medellinjug.hackings.HackingMaps;
import org.medellinjug.hackings.HackingStreams;
import org.medellinjug.hackings.model.Player;
import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Benchmarks {

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(1)
    public  void playersGreaterThan_forLoop(ScopeTester scopeTester){
         HackingStreams.playersGreaterThanForLoop(
                scopeTester.getData(),
                scopeTester.evaluationAge
        );
    }


    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(1)
    public  void playersGreaterThan_stream(ScopeTester scopeTester){
         HackingStreams.playersGreaterThanStream(
                scopeTester.getData(),
                scopeTester.evaluationAge
        );
    }


    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(1)
    public  void getPlayersByClub_stream(ScopeTester scopeTester){
        HackingMaps.getPlayersByClub(scopeTester.getData());
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(1)
    public  void getPlayersByClub_map(ScopeTester scopeTester){
        HackingMaps.getPlayersByClub(scopeTester.getData());
    }


    @State(Scope.Thread)
    public static class ScopeTester {
        private List<Player> data;
        private Integer evaluationAge = 30;

        public List<Player> getData() {
            return data;
        }

        @Setup(Level.Trial)
        public void doSetup() {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream csvfile = loader.getResourceAsStream("data.csv");
            MappingIterator<Player> personIter;
            try {
                assert csvfile != null;
                personIter = new CsvMapper()
                        .readerWithTypedSchemaFor(Player.class)
                        .readValues(csvfile);
                this.data = personIter.readAll();
            } catch (IOException e) {
                throw new RuntimeException("Error in setup, possibly by the file mapper");
            }
        }

    }
}
