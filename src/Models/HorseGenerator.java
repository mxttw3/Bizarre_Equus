package Models;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Random;
import Models.Horse;


public class HorseGenerator {
    private final Random rand = new Random();
    public ArrayList generateHorse(ArrayList animalList) {
        for (int i = 0; i < 30; i++) {
            
        
        String name = generateRandomName();
        int raceNumber = rand.nextInt(1000);
        String color = generateRandomColor();
        Date birth = generateRandomBirthDate();
        String hair = generateRandomHair();
        String eyeColor = generateRandomEyeColor();
        boolean gender = rand.nextBoolean();
        int speed = rand.nextInt(100) + 1;
        int endurance = rand.nextInt(100) + 1;
        int agility = rand.nextInt(100) + 1;
        boolean isMine = false;
        String race = null;
        int price = rand.nextInt(5000) + 1;
        Horse horseName = new Horse(name, raceNumber, color, birth, hair, eyeColor, gender, speed, endurance, agility, isMine, race, price);
        animalList.add(horseName);
        }
        return animalList;
    }

    private String generateRandomName() {
        String[] names = { "Thunderbolt", "Midnight", "Blaze", "Spirit", "Wildfire", "Majesty", "Stormy",
                "Comet", "Pegasus", "Dancer", "Freedom", "Knight", "Galaxy", "Phoenix",
                "Mystique", "Sundance", "Sable", "Bandit", "Willow", "Lucky", "Rainbow",
                "Whisper", "Apollo", "Jupiter", "Neptune", "Orion", "Titan", "Venus",
                "Amber", "Cinnamon", "Cocoa", "Dusty", "Ebony", "Ginger", "Honey",
                "Maple", "Pumpkin", "Saffron", "Sienna", "Tawny", "Topaz" };
        return names[rand.nextInt(names.length)];
    }

    private String generateRandomColor() {
        String[] colors = { "black", "brown", "white", "gray", "chestnut" };
        return colors[rand.nextInt(colors.length)];
    }

    private Date generateRandomBirthDate() {
        long maxDateMillis = System.currentTimeMillis();
        long minDateMillis = maxDateMillis - (365L * 24L * 60L * 60L * 1000L * 20L); // max age: 20 years
        long randomDateMillis = minDateMillis + (long) (rand.nextDouble() * (maxDateMillis - minDateMillis));
        return new Date(randomDateMillis);
    }

    private String generateRandomHair() {
        String[] hairTypes = { "short", "long", "mane" };
        return hairTypes[rand.nextInt(hairTypes.length)];
    }

    private String generateRandomEyeColor() {
        String[] eyeColors = { "brown", "blue", "green", "gray" };
        return eyeColors[rand.nextInt(eyeColors.length)];
    }
}
