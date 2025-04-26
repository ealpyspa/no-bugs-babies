package org.example.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomData {
    public static String randomString() {
        return "test " + RandomStringUtils.randomAlphabetic(10);
    }
}
