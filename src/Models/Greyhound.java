package Models;
import Controllers.*;
import java.time.LocalDate;
import java.util.Random;

import Utils.ReadUtilities;

public class Greyhound extends Animals implements interact {

    public Greyhound(String name, int raceNumber, String color, LocalDate birth, String hair, String eyeColor,
            boolean gender, int speed, int endurance, int agility, boolean isMine, int price) {
        super(name, raceNumber, color, birth, hair, eyeColor, gender, speed, endurance, agility, isMine, price);
    }

    @Override
    public String getAscii(){
        return """            
            /)-_-(\\
             (o o)
     .-----__/\\o/
    /  __      /
\\__/\\ /  \\_\\ |/
     \\\\     ||
     //     ||
     |\\     |\\_""";
     
    };
    
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
    public void eat() {
        int numeroAleatorio = (int) (Math.random() * 6);
        switch (numeroAleatorio) {
            case 0:
                System.out.println("The greyhound is savoring its meal");
                break;
            case 1:
                System.out.println("The lanky canine is chowing down on kibble");
                break;
            case 2:
                System.out.println("The sleek doggo is enjoying a gourmet feast");
                break;
            case 3:
                System.out.println("The racing dog is fueling up on protein");
                break;
            case 4:
                System.out.println("The speedy hound is wolfing down some treats");
                break;
            case 5:
                System.out.println("The agile pup is happily snacking away");
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
    
}
