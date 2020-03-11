package org.medellinjug.hackings;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.medellinjug.hackings.model.Player;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class HackingStreamTest {

    private final Integer CONDITIONAL_AGE = 43;

    @Test
    public void validStreamWithDataModel(){
        Long result = HackingStream.playersGreaterThanStream(getData(), CONDITIONAL_AGE);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void validForLoopWithDataModel(){
        Long result = HackingStream.playersGreaterThanForLoop(getData(), CONDITIONAL_AGE);
        Assertions.assertEquals(3, result);
    }


    private List<Player> getData(){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream csvfile = loader.getResourceAsStream("data.csv");
        MappingIterator<Player> personIter;
        try {
            assert csvfile != null;
            personIter = new CsvMapper()
                    .readerWithTypedSchemaFor(Player.class)
                    .readValues(csvfile);
            return personIter.readAll();
        } catch (IOException e) {
            throw new RuntimeException("Error in setup, possibly by the file mapper");
        }
    }
}
