package Models;
import Controllers.*;
import Utils.ReadUtilities;

import java.lang.foreign.Addressable;
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
    public String getAscii(){
        return """
            //
          _oo\\
         (__/ \\  _  _
            \\  \\/ \\/ \\
            (         )\\
             \\_______/  \\
              [[] [[]
              [[] [[]""";
    }
    @Override
    public void eat() {
        int numeroAleatorio = (int) (Math.random() * 6);
        switch (numeroAleatorio) {
            case 0:
                System.out.println("The camel is eating");
                break;
            case 1:
                System.out.println("The humpbacked mammal is dining al fresco");
                break;
            case 2:
                System.out.println("The desert dweller is snacking in style");
                break;
            case 3:
                System.out.println("The ship of the desert is enjoying a sand-wich");
                break;
            case 4:
                System.out.println("The dromedary is having a desert buffet");
                break;
            case 5:
                System.out.println("The one-humped wonder is indulging in a snack attack");
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
