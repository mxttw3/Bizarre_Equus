package Generators;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Random;
import Models.*;

public class CamelGenerator {

    private Random rand = new Random();

    public ArrayList generateCamel(ArrayList animalList) {
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
            Camels camel = new Camels(name, raceNumber, color, birth, hair, eyeColor, gender, speed, endurance,
                    agility, isMine, price, race);
            animalList.add(camel);
        }
        return animalList;
    }

    private int generatePrice(int speed, int endurance, int agility) {
        int price = (speed + endurance + agility) * 8;
        return price;
    }

    private String generateRandomName() {
        String[] names = {"Amir", "Zara", "Aswan", "Sahara", "Abdullah", "Zahara", "Arabian", "Nefertiti", 
            "Cairo", "Sahar", "Horus", "Osiris", "Sphinx", "Bastet", "Anubis", "Ramses", 
            "Kamal", "Layla", "Ali", "Fatima", "Jasmine", "Mustafa", "Nadir", "Noor", 
            "Omar", "Hassan", "Amina", "Salim", "Samar", "Sana", "Sultan", "Yasmin"};
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
        String[] races = {"Dromedary", "Bactrian", "Arabian Camel", "Nubian Camel", "Somali Camel", 
            "Gobi Camel", "Mongolian Camel", "Indian Camel", "Chinese Camel", "Wild Bactrian Camel", 
            "South American Camel", "Australian Feral Camel"};
        return races[rand.nextInt(races.length)];
    }
    

}

