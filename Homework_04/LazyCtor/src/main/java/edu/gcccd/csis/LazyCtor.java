package edu.gcccd.csis;

import java.util.*;
import java.lang.*;

public class LazyCtor {
    // K sets the max amount of instants
    private static final int K = 30;

    // Counts instances of LazyCtor
    private static int instanceCounter = 0;


    // instance variables
    private final int id;

    // only constructor is private
    private LazyCtor(final int id) {
        this.id = id;
        LazyCtor.instanceCounter++;
    }

    public static int getNumOfInstancesAllowed() {
        return LazyCtor.K;
    }

    public static int getNumOfInstancesCreated() {
        return LazyCtor.instanceCounter;
    }

    // Gets an instance of lazyCtor
    public static LazyCtor getInstance() {
        if (instanceCounter < K) // If less than the maximum instances of LazyCtor are created
            {return (new LazyCtor(instanceCounter));} // Return a new instance of lazyCtor
        else
            {return null;} // If at max instances allowed, return a Null

    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("I'm the LazyCtor Object, with the id: %d", id);
    }

    @Override
    protected void finalize() throws Throwable{
        instanceCounter--;
    }


}

