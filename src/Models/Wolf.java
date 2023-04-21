package Models;

import java.time.LocalDate;

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
            if(option==2) {
                System.out.println("Are you dumb? Why would you do that");
                System.out.println("GAME OVER");
                System.exit(0);
            }else {
                System.out.println("Your wolf is eating");
            }
            
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
