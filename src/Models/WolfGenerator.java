package Models;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Random;
import Models.Horse;

public class WolfGenerator {
    private Random rand = new Random();

    public ArrayList generateWolf(ArrayList animalList) {
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
            int price = generatePrice(speed, endurance, agility);
            String race = generateRandomRace();
            Wolf wolfs = new Wolf(name, raceNumber, color, birth, hair, eyeColor, gender, speed, endurance,
                    agility, isMine, price, race);
            animalList.add(wolfs);
        }
        return animalList;
    }

    private int generatePrice(int speed, int endurance, int agility) {
        int price = (speed + endurance + agility) * 8;
        return price;
    }

    private String generateRandomName() {
        String[] names = {"Luna", "Shadow", "Wolf", "Thunder", "Midnight", "Storm", "Spirit", "Fang", 
            "Blaze", "Echo", "Raven", "Hunter", "Nova", "Mystic", "Sable", "Soul", 
            "Scar", "Rogue", "Ash", "River", "Rune", "Tundra", "Talon", "Winter", 
            "Zephyr", "Zeus", "Vixen", "Orion", "Nyx", "Koda", "Jax", "Ivy"};
        return names[rand.nextInt(names.length)];
    }
    
    

    private String generateRandomColor() {
        String[] colors = { "beige", "brown", "black", "gray", "white" };
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
        String[] races = {"North American Gray Wolf", "Alaskan Gray Wolf", "Canadian Gray Wolf", 
            "Rocky Mountain Gray Wolf", "Mexican Gray Wolf", "Arizona and New Mexico Gray Wolf", 
            "Texas Gray Wolf", "Wisconsin Gray Wolf", "Vancouver Island Gray Wolf", 
            "Iberian Wolf", "Eastern Siberian Wolf", "Indian Wolf", "Ethiopian Wolf", 
            "Arabian Wolf", "Tibetan Wolf", "Hokkaido Wolf", "Alpine Wolf"};
        return races[rand.nextInt(races.length)];
    }
    

    

}
