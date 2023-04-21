package Generators;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Random;
import Models.Horse;

public class HorseGenerator {
    private final Random rand = new Random();

    public ArrayList generateHorse(ArrayList animalList) {
        for (int i = 0; i < 30; i++) {

            String name = generateRandomName();
            int raceNumber = 0;
            String color = generateRandomColor();
            LocalDate birth = generateRandomBirthDate();
            String hair = generateRandomHair();
            String eyeColor = generateRandomEyeColor();
            boolean gender = rand.nextBoolean();
            int speed = rand.nextInt(100) + 1;
            int endurance = rand.nextInt(100) + 1;
            int agility = rand.nextInt(100) + 1;
            boolean isMine = false;
            String race = generateRandomRace();
            int price = generatePrice(speed, endurance, agility);
            Horse horseName = new Horse(name, raceNumber, color, birth, hair, eyeColor, gender, speed, endurance,
                    agility, isMine, race, price);
            animalList.add(horseName);
        }
        return animalList;
    }

    private int generatePrice(int speed, int endurance, int agility) {
        int price = (speed + endurance + agility) * 8;
        return price;
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
        String[] colors = { "black", "brown", "white", "gray" };
        return colors[rand.nextInt(colors.length)];
    }

    private LocalDate generateRandomBirthDate() {
        final int EDAD_MAXIMA = 20;
        LocalDate fechaActual = LocalDate.now();
        Random rand = new Random();
        int edadAleatoria = rand.nextInt(EDAD_MAXIMA + 1);
        int diaAleatorio = rand.nextInt(28) + 1; // máximo 28 días para simplificar
        int mesAleatorio = rand.nextInt(12) + 1; // 12 meses en un año
        int anioAleatorio = fechaActual.getYear() - edadAleatoria;
        LocalDate fechaNacimientoAleatoria = LocalDate.of(anioAleatorio, mesAleatorio, diaAleatorio);
        return fechaNacimientoAleatoria;
    }

    private String generateRandomHair() {
        String[] hairTypes = { "short", "long", "mane" };
        return hairTypes[rand.nextInt(hairTypes.length)];
    }

    private String generateRandomEyeColor() {
        String[] eyeColors = { "brown", "blue", "green", "gray" };
        return eyeColors[rand.nextInt(eyeColors.length)];
    }

    private String generateRandomRace() {
        String[] races = { "Thoroughbred", "Quarter Horse", "Arabian", "Paint Horse", "Appaloosa", "Warmblood",
                "Morgan", "Mustang", "Andalusian", "Friesian", "Haflinger", "Tennessee Walking Horse", };
        return races[rand.nextInt(races.length)];
    }

}
