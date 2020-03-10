package org.medellinjug.hackings;

import org.medellinjug.hackings.model.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HackingMaps {
    private HackingMaps(){}

    public static Map<String, List<Data>> getPlayerForNationality(List<Data> data){
        return data.stream()
                .collect(Collectors.groupingBy(Data::getNationality));
    }

    public static Map<String, Map<String, Long>> getPlayerForNationalityGroupByClubs(List<Data> data){
       return data.stream()
                .collect(Collectors.groupingBy(Data::getNationality,
                        Collectors.groupingBy(Data::getClub, Collectors.counting())));
    }
}
