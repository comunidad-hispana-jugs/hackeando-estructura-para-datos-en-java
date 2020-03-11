package org.medellinjug.hackings;

import org.medellinjug.hackings.model.Player;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.function.Predicate;
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

    public static Map<String, Long> getPlayersByClub(List<Player> data){
      return data.stream()
                  .filter(distinctByKey(Player::getClub))
                  .map(Player::getClub)
                  .collect(Collectors.toMap(club -> club, mapToClub -> data.stream()
                          .filter(s -> s.getClub().equals(mapToClub))
                          .count()));
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static Map<String, Long> getPlayersByClubOpt(List<Player> data){
        Map<String, AtomicLong> temp = new ConcurrentHashMap<>();
        Map<String, Long> result = new ConcurrentHashMap<>();

        for (var player: data){
            temp.putIfAbsent(player.getClub(), new AtomicLong(0));
            Long count = temp.get(player.getClub()).incrementAndGet();
            result.put(player.getClub(), count);
        }

        return result;
    }
}
