package Models;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import Controllers.functions;
import Utils.*;
import Models.*;

public class Horse extends Animals implements interact {
    private String race;

    public Horse(String name, int raceNumber, String color, LocalDate birth, String hair, String eyeColor, boolean gender,
            int speed, int endurance, int agility, boolean isMine, String race, int price) {
        super(name, raceNumber, color, birth, hair, eyeColor, gender, speed, endurance, agility, isMine, price);
        this.race = race;
    }

    @Override
    public void eat() {
        
        ReadUtilities.ReadIntMM("""
        What do you want to feed your horse?
        1.Hay
        2.Carrots
        3.Apples
        """, 1, 3);
        viewAscii();
        System.out.println("Your horse is eating");

    }

    @Override
    public void viewAscii() {
        System.out.print("""
                            .''
                  ._.-.___.' (`\\
                 //(        ( `'
                '/ )\\ ).__. )\s
                ' <' `\\ ._/'\\
                   `   \\     \\""");
    };


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
        viewAscii();
        System.out.println("You pat your horse");
    }



    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
    
}
