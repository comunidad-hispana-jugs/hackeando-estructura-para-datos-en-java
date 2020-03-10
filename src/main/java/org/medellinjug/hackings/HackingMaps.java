package org.medellinjug.hackings;

import org.medellinjug.hackings.model.Player;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HackingMaps {
    private HackingMaps(){}

    public static Map<String, List<Player>> getPlayerByNationality(List<Player> data){
        return data.stream()
                .collect(Collectors.groupingBy(Player::getNationality));
    }

    public static Map<String, Map<String, Long>> getPlayerByNationalityGroupByClubs(List<Player> data){
       return data.stream()
                .collect(Collectors.groupingBy(Player::getNationality,
                        Collectors.groupingBy(Player::getClub, Collectors.counting())));
    }
}
