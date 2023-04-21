package Models;

import java.time.LocalDate;

public class Greyhound extends Animals implements interact {

    public Greyhound(String name, int raceNumber, String color, LocalDate birth, String hair, String eyeColor,
            boolean gender, int speed, int endurance, int agility, boolean isMine, int price) {
        super(name, raceNumber, color, birth, hair, eyeColor, gender, speed, endurance, agility, isMine, price);
        //TODO Auto-generated constructor stub
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
    
}
