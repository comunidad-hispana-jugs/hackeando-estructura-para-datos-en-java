package org.medellinjug.hackings;


import org.medellinjug.hackings.model.Player;

import java.util.List;

public class HackingStream {

    private HackingStream() {
    }


    public static Long playersGreaterThanForLoop(List<Player> data, int evaluation) {
        Long maxAge = 0L;
        for (Player model : data) {//loop
            if (!model.getAge().isEmpty()) {//may not exist
                int age = Integer.parseInt(model.getAge());//mapper
                if (age > evaluation) {//conditional
                    maxAge++;//sum
                }
            }
        }
        return maxAge;
    }

    public static Long playersGreaterThanStream(List<Player> data, int evaluation) {
        return data.stream()//stream
                .filter(model -> !model.getAge().isEmpty())//may not exist
                .map(model -> Integer.parseInt(model.getAge()))//mapper
                .filter(age -> age > evaluation)//conditional
                .count();//sum
    }


    public static Long playersGreaterThanForIterator(List<Player> data, int evaluation) {
        Long maxAge = 0L;
        var it = data.iterator();
        while (it.hasNext()){
            var model = it.next();
            if (!model.getAge().isEmpty()) {//may not exist
                int age = Integer.parseInt(model.getAge());//mapper
                if (age > evaluation) {//conditional
                    maxAge++;//sum
                }
            }
        }
        return maxAge;
    }

}
