package com.health.testfragments;

/**
 * Created by ankurchaudhary on 02-02-2017.
 */

public class Utilty {

    public static int sum(int... a) {
        int count=0;
        for(int i:a){
            count+=i;
        }
        return count;
    }

}
