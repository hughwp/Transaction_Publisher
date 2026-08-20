package com.hughcode;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NamesRepo {
    private static final List<String> FIRST_NAMES = Arrays.asList(
            "James",
            "Mary",
            "Robert",
            "Patricia",
            "Michael",
            "Jennifer",
            "William",
            "Linda",
            "David",
            "Barbara",
            "Richard",
            "Susan",
            "Joseph",
            "Jessica",
            "Thomas",
            "Sarah",
            "Charles",
            "Karen",
            "Christopher",
            "Nancy"
    );

    private static final List<String> LAST_NAMES = Arrays.asList(
            "Smith",
            "Johnson",
            "Williams",
            "Brown",
            "Jones",
            "Garcia",
            "Miller",
            "Davis",
            "Rodriguez",
            "Martinez",
            "Hernandez",
            "Lopez",
            "Gonzalez",
            "Wilson",
            "Anderson",
            "Thomas",
            "Taylor",
            "Moore",
            "Jackson",
            "Martin"
    );

    private static final Random random = new Random();

    public static String getRandomFirstName() {
        return FIRST_NAMES.get(random.nextInt(FIRST_NAMES.size()));
    }

    public static String getRandomLastName() {
        return LAST_NAMES.get(random.nextInt(LAST_NAMES.size()));
    }

    public static String getRandomFullName() {
        return getRandomFirstName() + " " + getRandomLastName();
    }
}