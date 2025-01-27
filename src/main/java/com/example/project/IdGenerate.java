package com.example.project;

public class IdGenerate{ //This class contains statics variable and methods, you do not initalize an object to use it.
    
    // intializes to 99
    private static String currentId = "99";
    // empty consturcturer
    public IdGenerate(){

    }

    // returns the current id
    public static String getCurrentId(){
        return currentId;
    }

    // resets the id amount to 99
    public static void reset(){
        currentId = "99";
    }

    // creates next i
    public static void generateID(){
        //uses parse int in order to change the string id to an int
       int id = Integer.parseInt(currentId);
       //updates the int
       id++;
       //change the int back into a string
       currentId = Integer.toString(id);
    }
}