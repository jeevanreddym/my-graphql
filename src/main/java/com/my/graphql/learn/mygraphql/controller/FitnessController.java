package com.my.graphql.learn.mygraphql.controller;

import com.my.graphql.learn.mygraphql.model.fitness.Coach;
import com.my.graphql.learn.mygraphql.model.fitness.Difficulty;
import com.my.graphql.learn.mygraphql.model.fitness.FitnessClass;
import graphql.GraphQLContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.*;

@Slf4j
@Controller
public class FitnessController {


    @QueryMapping
    public List<FitnessClass> schedule(
            @Argument Coach coach,
            GraphQLContext context) {
        log.info("schedule({})", coach);

        Calendar currentDateTime = Calendar.getInstance();
        Date startTime = currentDateTime.getTime();

        currentDateTime.add(Calendar.HOUR, 1);
        Date endTime = currentDateTime.getTime();

        return List.of(
                FitnessClass.builder()
                        .id(UUID.randomUUID())
                        .coach(coach)
                        .startsAt(startTime.toString())
                        .endsAt(endTime.toString())
                        .difficulty(Difficulty.BEGINNER)
                        .build()
        );
    }

//    @BatchMapping
//    public Callable<Map<FitnessClass, Difficulty>> difficulty(
//            List<FitnessClass> fitnessClasses,
//            GraphQLContext context) {
//        return () -> {
//            fitnessClasses.stream()
//                    .collect(Collectors.toUnmodifiableMap(
//                            Function.identity(),
//                            ignore -> Difficulty.BEGINNER
//                    ))
//        };
//    }

}
