package com.arhibale.service.utill;

public class RandomNumberOrString {
    public static String randomString() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        return words[randomNumber(words.length)];
    }

    public static int randomNumber(int i) {
        return (int) (Math.random() * i);
    }
}
