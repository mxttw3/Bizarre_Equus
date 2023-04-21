package Models;
import Controllers.*;
import Utils.ReadUtilities;

import java.time.LocalDate;

import javax.swing.text.Utilities;

public class Camels extends Animals implements interact {
    private String race;

    public Camels(String name, int raceNumber, String color, LocalDate birth, String hair, String eyeColor,
            boolean gender, int speed, int endurance, int agility, boolean isMine, int price, String race) {
        super(name, raceNumber, color, birth, hair, eyeColor, gender, speed, endurance, agility, isMine, price);
        this.race = race;
    }

    @Override
    public void viewAscii() {
        System.out.print("""            
            //
          _oo\\
         (__/ \\  _  _
            \\  \\/ \\/ \\
            (         )\\
             \\_______/  \\
              [[] [[]
              [[] [[]""");
    };

    @Override
    public void eat() {
        
        ReadUtilities.ReadIntMM("""
        What do you want to feed your camel?
        1.Hay
        2.Carrots
        3.Apples
        """, 1, 3);
        viewAscii();
        System.out.println("Your camel is eating");

    }

    @Override
    public void play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }

    @Override
    public void patpat() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patpat'");
    }
    
}
