package com.my.graphql.learn.mygraphql.model.fitness;

import lombok.Builder;

import java.util.UUID;

@Builder
public class FitnessClass {
    UUID id;
    Coach coach;
    String startsAt;
    String endsAt;
    Difficulty difficulty;
}
