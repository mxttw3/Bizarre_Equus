package Models;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;

import Models.*;

public class Horse extends Animals implements interact {
    private String race;

    public Horse(String name, int raceNumber, String color, LocalDate birth, String hair, String eyeColor, boolean gender,
            int speed, int endurance, int agility, boolean isMine, String race, int price) {
        super(name, raceNumber, color, birth, hair, eyeColor, gender, speed, endurance, agility, isMine, price);
        this.race = race;
    }

    @Override
    public String eat() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eat'");
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

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
    
}
