package Models;

import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;

public abstract class Animals {
    private static int recuento = 0; // TODO: Ver en ingles
    private final int legs = 4;
    private String name;
    private int raceNumber;
    private String Color;
    private LocalDate Birth;
    private String hair;
    private String EyeColor;
    private boolean gender; // True: men False: women
    private int speed;
    private int endurance;
    private int agility;
    private boolean isMine;
    private int price;

    public Animals(String name, int raceNumber, String color, LocalDate birth, String hair, String eyeColor,
            boolean gender,
            int speed, int endurance, int agility, boolean isMine, int price) {
        this.name = name;
        this.raceNumber = raceNumber;
        Color = color;
        Birth = birth;
        this.hair = hair;
        EyeColor = eyeColor;
        this.gender = gender;
        this.speed = speed;
        this.endurance = endurance;
        this.agility = agility;
        this.isMine = isMine;
        this.price = price;
    }

    public void setMine(boolean isMine) {
        this.isMine = isMine;
    }

    public boolean isMine() {
        return isMine;
    }

    public String getName() {
        return name;
    }

    public void viewAscii() {
        System.out.println("-- ANIMAL --");
    }

    public void viewAnimalInfo(String type, boolean showPrice, boolean buy) {
        if(type == "Models.Horse"){
        System.out.println("""
                            .''
                  ._.-.___.' (`\\
                 //(        ( `'
                '/ )\\ ).__. )\s
                ' <' `\\ ._/'\\
                   `   \\     \\""");
        
    }else if (type=="Models.Greyhound"){
        System.out.println("""            
            /)-_-(\\
             (o o)
     .-----__/\\o/
    /  __      /
\\__/\\ /  \\_\\ |/
     \\\\     ||
     //     ||
     |\\     |\\""");
    }else if (type=="Models.Camels") {
        System.out.println("""            
            //
          _oo\\
         (__/ \\  _  _
            \\  \\/ \\/ \\
            (         )\\
             \\_______/  \\
              [[] [[]
              [[] [[]""");
    }else if (type=="Models.Wolf") {
            System.out.println("""            
                                  /^._
                    ,___,--~~~~--' /'~
                    `~--~\\ )___,)/'
                        (/\\\\_  (/\\\\_""");
    }
    System.out.print("Name: " + this.name + " Birth: " + this.Birth + " Speed: " + this.speed + " Endurance: "
                + this.endurance + " Agility: " + this.agility);
        if (showPrice && buy) {
            System.out.println(" Price: " + this.price);
        }else if (showPrice && !buy) {
            System.out.println(" Price: " + this.price/2);
    }
}

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getAgility() {
        return agility;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setBirth(LocalDate birth) {
        Birth = birth;
    }

    public void eat() {
        
    }

}
