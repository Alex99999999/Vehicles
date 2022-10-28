package com.vehicles.generator.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GeneratorUtils {
    public static int getRandomInt(int startInclusive, int endExclusive) {
        return new Random().nextInt(startInclusive, endExclusive);
    }
}
