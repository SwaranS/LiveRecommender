package com.recommender.extractor;

import java.io.IOException;

/**
 * Created by swara on 11/01/2017.
 */
public class Main {

    public static void main(String[] args) {
        KeywordsExtractor ks = new KeywordsExtractor();
        try {
            ks.guessFromString("input");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
