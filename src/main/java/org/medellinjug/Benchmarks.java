package org.medellinjug;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.medellinjug.hackings.HackingStream;
import org.medellinjug.hackings.model.Data;
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
         HackingStream.playersGreaterThanForLoop(
                scopeTester.getData(),
                scopeTester.evaluationAge
        );
    }


    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(1)
    public  void playersGreaterThan_stream(ScopeTester scopeTester){
         HackingStream.playersGreaterThanStream(
                scopeTester.getData(),
                scopeTester.evaluationAge
        );
    }


    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(1)
    public  void getMaxValue_forLoop(ScopeTester scopeTester){
        HackingStream.getMaxForLoop(scopeTester.baseInts);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(1)
    public  void getMaxValue_stream(ScopeTester scopeTester){
        HackingStream.getMaxStream(scopeTester.baseInts);
    }


    @State(Scope.Thread)
    public static class ScopeTester {
        private List<Data> data;
        private Integer evaluationAge = 30;
        private int[] baseInts = {12,32,123,44,12,34,5,3212,45,678,32,122,3,4556,3112,334,5,13,7,661,543,22,1,221,7,66,5545,67,8,9,898,6544};

        public List<Data> getData() {
            return data;
        }

        @Setup(Level.Trial)
        public void doSetup() {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream csvfile = loader.getResourceAsStream("data.csv");
            MappingIterator<Data> personIter;
            try {
                assert csvfile != null;
                personIter = new CsvMapper()
                        .readerWithTypedSchemaFor(Data.class)
                        .readValues(csvfile);
                this.data = personIter.readAll();
            } catch (IOException e) {
                throw new RuntimeException("Error in setup, possibly by the file mapper");
            }
        }

    }
}
