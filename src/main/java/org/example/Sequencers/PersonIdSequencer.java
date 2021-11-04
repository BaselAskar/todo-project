package org.example.Sequencers;

public class PersonIdSequencer {
    private static int currentPersonId;

    public static int nextPersonId(){ return ++currentPersonId;}

    public static int getCurrentPersonId(){ return currentPersonId;};

    public static void setCurrentPersonId(int id){ currentPersonId = id;}
}
