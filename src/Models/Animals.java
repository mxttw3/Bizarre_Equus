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
    
    public boolean isMine() {
        return isMine;
    }

    

}
