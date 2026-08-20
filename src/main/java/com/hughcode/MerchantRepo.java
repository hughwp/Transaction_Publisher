package com.hughcode;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MerchantRepo {
    private static final List<String> MERCHANTS = Arrays.asList(
            "Tesco",
            "Sainsbury's",
            "Waitrose",
            "Asda",
            "Morrisons",
            "Marks & Spencer",
            "John Lewis",
            "Boots",
            "Argos",
            "Next",
            "Zara",
            "H&M",
            "ASOS",
            "Amazon",
            "eBay",
            "Currys",
            "PC World",
            "Halfords",
            "Sports Direct",
            "Selfridges"
    );

    private static final Random random = new Random();

    public static String getRandomMerchant() {
        return MERCHANTS.get(random.nextInt(MERCHANTS.size()));
    }
}