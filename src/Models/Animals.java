package Models;
import java.util.ArrayList;
import java.sql.Date;

public abstract class Animals {
    private static int recuento = 0; //TODO: Ver en ingles
    private final int legs = 4;
    private String name;
    private int raceNumber;
    private String Color;
    private Date Birth;
    private String hair;
    private String EyeColor;
    private boolean gender; // True: men False: women 
    private int speed;
    private int endurance;
    private int agility;
    private boolean isMine;
    private int price;

    
    public Animals(String name, int raceNumber, String color, Date birth, String hair, String eyeColor, boolean gender,
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

    public boolean isMine() {
        return isMine;
    }

    public String getName() {
        return name;
    }

    public void viewAnimalInfo(int type) {

        
        System.out.println("""            
            .''
  ._.-.___.' (`\\
 //(        ( `'
'/ )\\ ).__. )\s
' <' `\\ ._/'\\
   `   \\     \\""");
            System.out.println("Name: " + this.name + " Birth: " + this.Birth + " Speed: " + this.speed + " Endurance: " + this.endurance + " Agility: " + this.agility);       
    }

    

}
