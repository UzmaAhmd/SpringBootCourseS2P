package org.example;

//this is an example of tightly coupled system where to call the function start of car,
//

public class Client {
    public static void main(String[] args)
    {
        Traveller traveller=new Traveller();
        traveller.startJourney();
    }

}
