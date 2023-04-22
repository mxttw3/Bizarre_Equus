package Models;
import Controllers.*;
import java.time.LocalDate;
import java.util.Random;

import Utils.ReadUtilities;

public class Greyhound extends Animals implements interact {

    public Greyhound(String name, int raceNumber, String color, LocalDate birth, String hair, String eyeColor,
            boolean gender, int speed, int endurance, int agility, boolean isMine, int price) {
        super(name, raceNumber, color, birth, hair, eyeColor, gender, speed, endurance, agility, isMine, price);
    }

    @Override
    public void eat() {
        
        ReadUtilities.ReadIntMM("""
        What do you want to feed your dog?
        1.Meat
        2.Carrots
        3.Apples
        """, 1, 3);
        viewAscii();
        System.out.println("Your dog is eating");

    }

    @Override
    public void play() throws InterruptedException {
        do {
        Random rand = new Random();
        functions m = new functions();
        int opcion = ReadUtilities.ReadIntMM("""
        Do you want to throw the ball?
        1.Yes
        2.No    
        """, 1, 2);
        viewAscii();
        if (opcion == 2){
            m.myAnimals();
        }else {
            System.out.println(" Is going to catch the ball...");
            int time = rand.nextInt(4000)+1000;
            Thread.sleep(time);
            System.out.println("He returned with the ball");
        }
    }while(1==1);
    }

    
    @Override
    public void patpat() {
        functions m = new functions();
        int opcion = ReadUtilities.ReadIntMM("""
        Where do you want to pat your dog?
        1.Head
        2.Back
        3.Belly
        4.go back
        """, 1, 4);
        viewAscii();
        switch (opcion) {
            case 1,2-> System.out.println("He is happy");
            case 3 -> System.out.println("He loves when you pat his belly");
            case 4 -> m.myAnimals();
        }
    }


    @Override
    public void viewAscii() {
        System.out.print("""            
            /)-_-(\\
             (o o)
     .-----__/\\o/
    /  __      /
\\__/\\ /  \\_\\ |/
     \\\\     ||
     //     ||
     |\\     |\\""");
    };


    
}
