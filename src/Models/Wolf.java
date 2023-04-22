package Models;

import java.time.LocalDate;

import Controllers.*;
import Utils.ReadUtilities;

public class Wolf extends Animals implements interact {
    private String race;

    public Wolf(String name, int raceNumber, String color, LocalDate birth, String hair, String eyeColor,
            boolean gender, int speed, int endurance, int agility, boolean isMine, int price, String race) {
        super(name, raceNumber, color, birth, hair, eyeColor, gender, speed, endurance, agility, isMine, price);
        this.race = race;
    }

    @Override
    public void viewAscii() {
        System.out.print("""

                              /^._
                ,___,--~~~~--' /'~
                `~--~\\ )___,)/'
                    (/\\\\_  (/\\\\_
                    """);
    };

    @Override
    public void eat() {
        int option = ReadUtilities.ReadIntMM("""
                What do you want to feed your Wolf?
                1.Meat
                2.Your hand
                """, 1, 2);
        viewAscii();
        if (option == 2) {
            System.out.println("Are you dumb? Why would you do that");
            System.out.println("GAME OVER");
            System.exit(0);
        } else {
            System.out.println("Your wolf is eating");
        }

    }

    @Override
    public void play() {
        System.out.println("You cant play with a wolf. Do you want to die?");
    }

    @Override
    public void patpat() {
        functions m = new functions();
        int opcion = ReadUtilities.ReadIntMM("""
                    Where do you want to pat your wofl?
                    1.Head
                    2.Back
                    3.Belly
                    4. Go back
                """, 1, 4);
                viewAscii();
        switch (opcion) {
            case 1, 2, 3 -> {

                System.out.println("Are you stupid why would you try to pay a wolf?");
                System.out.println("GAME OVER");
                System.exit(0);
            }
            case 4 -> {
                System.out.println("You are smart by not trying to pat a wolf");
                m.menu();
            }
        }
    }
}
