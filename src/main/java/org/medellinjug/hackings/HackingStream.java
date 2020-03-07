package org.medellinjug.hackings;


import org.medellinjug.hackings.model.Data;

import java.util.List;

public class HackingStream {

    private HackingStream(){}

    public static Long playersGreaterThanForLoop(List<Data> data, int evaluation){
        Long total = 0L;
        for(Data model: data){//loop

            if(!model.getAge().isEmpty()){//may not exist
                int age = Integer.parseInt(model.getAge());//mapper
                if(age > evaluation){//conditional
                    total++;//sum
                }
            }
        }
        return total;
    }


    public  static Long playersGreaterThanStream(List<Data> data, int evaluation){
        return data.stream()//stream
                .filter(model -> !model.getAge().isEmpty())//may not exist
                .map(model -> Integer.parseInt(model.getAge()))//mapper
                .filter(age -> age > evaluation)//conditional
                .count();//sum
    }

}
