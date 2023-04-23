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
    public String getAscii(){
        return """  
                            .''
                  ._.-.___.' (`\\
                 //(        ( `'
                '/ )\\ ).__. )\s
                ' <' `\\ ._/'\\
                   `   \\     \\
        """;
     
    };

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
    public void eat() {
        int numeroAleatorio = (int) (Math.random() * 6);
        
        switch (numeroAleatorio) {
            case 0:
                System.out.println("The horse is munching on hay");
                break;
            case 1:
                System.out.println("The equine is enjoying a feast");
                break;
            case 2:
                System.out.println("The mare is grazing on grass");
                break;
            case 3:
                System.out.println("The stallion is snacking on some oats");
                break;
            case 4:
                System.out.println("The pony is chowing down on some carrots");
                break;
            case 5:
                System.out.println("The colt is nibbling on some hay");
                break;
            default:
                break;
        }
        
    }

    @Override
    public void play() {
        int numeroAleatorio = (int) (Math.random() * 6);

        switch (numeroAleatorio) {
            case 0:
                System.out.println("My animal friend is having a great time playing!");
                break;
            case 1:
                System.out.println("My furry buddy is wagging its tail with joy!");
                break;
            case 2:
                System.out.println("My scaly pal is exploring its surroundings and having fun!");
                break;
            case 3:
                System.out.println("My feathered companion is singing and chirping happily!");
                break;
            case 4:
                System.out.println("My playful friend is jumping and running around with excitement!");
                break;
            case 5:
                System.out.println("My cuddly buddy is snuggling and enjoying our time together!");
                break;
            default:
                break;
        }
        
    }

    @Override
    public void patpat() {
        int numeroAleatorio = (int) (Math.random() * 6);

        switch (numeroAleatorio) {
            case 0:
                System.out.println("My sweetie is purring and snuggling up to me!");
                break;
            case 1:
                System.out.println("My furry pal is enjoying belly rubs and ear scratches!");
                break;
            case 2:
                System.out.println("My scaly buddy is basking in the warmth of my hand!");
                break;
            case 3:
                System.out.println("My feathered friend is nuzzling into my palm and cooing softly!");
                break;
            case 4:
                System.out.println("My affectionate companion is leaning into my touch and wagging its tail!");
                break;
            case 5:
                System.out.println("My cuddly buddy is cuddling up to me and melting my heart!");
                break;
            default:
                break;
        }
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
    
}
