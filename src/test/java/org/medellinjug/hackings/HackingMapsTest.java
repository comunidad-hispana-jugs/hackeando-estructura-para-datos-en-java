package org.medellinjug.hackings;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.medellinjug.hackings.model.Data;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class HackingMapsTest {


    @Test
    public void counterPlayer(){
        Map<String, List<Data>> result = HackingMaps.getPlayerForNationality(getData());
        Assertions.assertEquals(164, result.size());
    }

    @Test
    public void counterForTotalPlayer(){
        Map<String, Map<String, Long>> result = HackingMaps.getPlayerForNationalityGroupByClubs(getData());
        Assertions.assertEquals(164, result.size());
    }




    private List<Data> getData(){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream csvfile = loader.getResourceAsStream("data.csv");
        MappingIterator<Data> personIter;
        try {
            assert csvfile != null;
            personIter = new CsvMapper()
                    .readerWithTypedSchemaFor(Data.class)
                    .readValues(csvfile);
            return personIter.readAll();
        } catch (IOException e) {
            throw new RuntimeException("Error in setup, possibly by the file mapper");
        }
    }
}
