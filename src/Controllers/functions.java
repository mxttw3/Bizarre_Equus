package Controllers;
import Models.*;
import Generators.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



import ENUMS.difficulty;
import Utils.*;

public class functions {
    ArrayList<Animals> animalList = new ArrayList<Animals>();    // |─
    ArrayList<Animals> cincoObjetos = new ArrayList<Animals>();
    HorseGenerator Hgenerator = new HorseGenerator();
    CamelGenerator Cgenerator = new CamelGenerator();
    GreyhoundGenerator Ggenerator = new GreyhoundGenerator(); 
    WolfGenerator Wgenerator = new WolfGenerator();
    User currentUser = null;
    Random rand = new Random();

    // añadir animales creados al arraylist
    public void createUser() throws InterruptedException {
        
        Hgenerator.generateHorse(animalList);
        Cgenerator.generateCamel(animalList);
        Ggenerator.generateGreyhound(animalList);
        Wgenerator.generateWolf(animalList);

        System.out.println("Wellcome to Bizarre Races!!!!");
        Thread.sleep(2000);
        String name = ReadUtilities.readWord("""
                |───────────────────|
                | What's your name? |
                |───────────────────|
                """);
        String lastName = ReadUtilities.readWord("""
                |─────────────────────|
                | And your last name? |
                |─────────────────────|
                """);
        int age = ReadUtilities.ReadIntMM("""
                |──────────────────|
                | How old are you? |
                |──────────────────|
                """, 1, 110);
        int gender = ReadUtilities.ReadIntMM("""
                |────────────────────────|
                | You're a men o women   |
                | 1.Men                  |
                | 1.Women                |
                |────────────────────────|
                """, 1, 2);

        boolean Vgender = true;         
        if (gender == 1) {
            Vgender = true;
        }else{
            Vgender = false;
        }
        int Vdifficulty = ReadUtilities.ReadIntMM("""
                |────────────────────────────────|
                |  What difficulty you choose :) |
                | 1.Easy Peasy                   |
                | 1.Medium                       |
                | 1.Demon                        |
                |────────────────────────────────|
                """, 1, 3);

        difficulty optionD = difficulty.MEDIUM;
        switch (Vdifficulty) {
            case 1 -> optionD = difficulty.EASY_PEASY;
            case 2 -> optionD = difficulty.MEDIUM;
            case 3 -> optionD = difficulty.DEMON;
        }
        currentUser = new User(name, lastName, age, Vgender, optionD);
    }

    // MENU
    public void menu() {
        boolean bucle = true;

        do{
            int option = ReadUtilities.ReadIntMM("""
                    |──────────────|
                    | 1.Bet        |
                    | 2.User info  |
                    | 3.Shop       |
                    | 3.My animals |
                    | 4.Exit       |
                    |──────────────| 
                    """, 1, 5);

            switch (option) {
                case 1 -> submenuBet();
                case 2 -> currentUser.viewUserInfo();
                case 3 -> submenuShop();
                case 4 -> bucle = false;
            }
        }while(bucle);
    }

    // SUBMENU BET
    public void submenuBet() {
        int option = ReadUtilities.ReadIntMM("""
            |─────────────────|
            | 1.Put my animal |
            | 2.Start         |   
            | 3.Back          |
            |─────────────────|

                """, 1, 3);
        switch (option) {
            case 1 -> AnimalsForRace(false);
            case 2 -> AnimalsForRace(true);//TODO: bet menu
            case 3 -> menu();
        }
    }

    public void AnimalsForRace(boolean Vanials) {
        //TODO: poner animales en la carrera
        if (Vanials) {
            int n = animalList.size();
            for (int i = 0; i < 5; i++) {
                int randomIndex = (int) (Math.random() * n);
                cincoObjetos.add(animalList.get(randomIndex));
            }
            
            // Imprime los 5 objetos aleatorios
            System.out.println("Los 5 objetos aleatorios son:");
            for (Animals objeto : cincoObjetos) {
                objeto.viewAscii();
            }
            
            StartRace();
            cincoObjetos.clear();
        }else{
            int n = animalList.size();
            for (int i = 0; i < 4; i++) {
                int randomIndex = (int) (Math.random() * n);
                cincoObjetos.add(animalList.get(randomIndex));
            }
            
            // Imprime los 5 objetos aleatorios
            System.out.println("Los 5 objetos aleatorios son:");
            for (Animals objeto : cincoObjetos) {
                System.out.println(objeto);
            }
            

            //TODO: Cojer caballo de tu lista
            cincoObjetos.add(listAnimals(true, false));
            StartRace();
            cincoObjetos.clear();
        }
    }

    public void StartRace() {
        //TODO: EmpezarCarrera
        Animals[][] RaceBoard = new Animals[5][8];
        int[] VectorSkills = new int[5]; // Vector con las skills del animal
        int[] RandomSkills= new int[5]; // crea un vector de longitud 5


        for (int i = 0; i < cincoObjetos.size(); i++) {
            RaceBoard[i][0] = cincoObjetos.get(i);
        };


        //Calcular las skills de los animales
        for (int i = 0; i < cincoObjetos.size(); i++) {
            VectorSkills[i] = ((cincoObjetos.get(i).getSpeed() * 40) + (cincoObjetos.get(i).getAgility() * 30) + (cincoObjetos.get(i).getEndurance()* 30))/100;
        };

        do{
            int max = 0, MaxPosition = 0, Vcolumn = 0;
            // Crear probabilidad de pasar a la siguiente casilla del tablero
            for (int i = 0; i < cincoObjetos.size(); i++) {
                do{
                    RandomSkills[i] = (int)(Math.random() * VectorSkills[i]);
                    System.out.println(VectorSkills[i]);
                }while(RandomSkills[i] == 0);
            };

            // Buscar numero ganador para moverlo
            for (int i = 0; i < RandomSkills.length; i++) {
                if (RandomSkills[i] > max) {
                    max = RandomSkills[i];
                    MaxPosition = i;
                }
            }

            // Mover el animal ganador
            for (int fila = 0; fila < RaceBoard.length; fila++) {
                for (int columna = 0; columna < RaceBoard[fila].length; columna++) {

                    if (RaceBoard[fila][columna] == cincoObjetos.get(MaxPosition)) {                            
                        Vcolumn = columna;
                        break; // Terminar la búsqueda una vez que se ha encontrado el objeto.
                    }
                }
            }

            Vcolumn = Vcolumn + 1;
            RaceBoard[MaxPosition][Vcolumn] = cincoObjetos.get(MaxPosition);
            RaceBoard[MaxPosition][Vcolumn - 1] = null;

            for(int i = 0; i < RaceBoard.length; i++) {
                for(int j = 0; j < RaceBoard[i].length; j++) {
                    if (RaceBoard[i][j] == null) {
                        System.out.print("             ");
                    }else{
                    RaceBoard[i][j].viewAscii();}
                }
                System.out.println();
            }
        }while (true);
    }

    // SUBMENU SHOP
    public void submenuShop() {
        int option = ReadUtilities.ReadIntMM("""
            |─────────|
            | 1.Buy   |
            | 2.Sell  |
            | 3.Breed |
            | 4.Back  |
            |─────────|
                """, 1, 4);
        switch (option) {
            case 1 -> buy();
            case 2 -> sell();
            case 3 -> breeder();
            case 4 -> menu();
        }
    }

    // Buy animal
    public void buy() {
        System.out.println("Welcome to the shop!!");
        System.out.println("Here you have a list of our available animals:");
        Animals selected = listAnimals(false, true);
        if (selected.getPrice() <= currentUser.getMoney()) {
            currentUser.setMoney(currentUser.getMoney() - selected.getPrice());
            selected.setMine(true);
            System.out.println("You have bought " + selected.getName());
        } else {
            System.out.println("You dont have enought money");
        }
    }
    public void sell(){
        System.out.println("Welcome to the shop!!");
        System.out.println("Here you have a list of your animals:");
        Animals selected = listAnimals(true, true);
            currentUser.setMoney(currentUser.getMoney() + selected.getPrice());
            selected.setMine(false);
            System.out.println("You have sold " + selected.getName()); 
    };


    // Breeder where if you pay 500$ you can breed an animal that has 60% of being a
    // shit 30% of being normal 10% of being gigachad
    public void breeder(){
        int option=ReadUtilities.ReadIntMM("""
    |─────────────────────────────────────────|
    |   Welcome!                              |
    |   What type of animal do you wana get?  |
    |   1.Normal 500$                         |
    |   2.Super Animal 1000$                  |
    |   3.Back                                |
    |─────────────────────────────────────────|
        """, 1, 3);
        switch (option) {
            case 1 -> { if (currentUser.getMoney()>500){
                currentUser.setMoney(currentUser.getMoney()-500);
                String[] type = {"Wolf","Horse","Greyhound","Camels"};
                String animtoGen=type[rand.nextInt(type.length)];
                if (animtoGen=="Wolf"){
                    Wgenerator.generateWolf(animalList);
                }else if (animtoGen=="Horse") {
                    Hgenerator.generateHorse(animalList);
                }else if (animtoGen=="Greyhound") {
                    Ggenerator.generateGreyhound(animalList);
                }else if (animtoGen=="Camels") {
                    Cgenerator.generateCamel(animalList);
                }
                    int numeroAleatorio = rand.nextInt(10);
                    int last = animalList.size()-1;
                    animalList.get(last).setMine(true);
                    if(numeroAleatorio > 0 && numeroAleatorio < 6){
                        int skillsAleatorio = rand.nextInt(30);
                        animalList.get(last).setSpeed(skillsAleatorio);

                        skillsAleatorio = rand.nextInt(30);
                        animalList.get(last).setEndurance(skillsAleatorio);

                        skillsAleatorio = rand.nextInt(30);
                        animalList.get(last).setAgility(skillsAleatorio);
                    }else if(numeroAleatorio > 5 && numeroAleatorio < 9) {
                        int skillsAleatorio = rand.nextInt(30)+30;
                        animalList.get(last).setSpeed(skillsAleatorio);

                        skillsAleatorio = rand.nextInt(30)+30;
                        animalList.get(last).setEndurance(skillsAleatorio);

                        skillsAleatorio = rand.nextInt(30)+30;
                        animalList.get(last).setAgility(skillsAleatorio);
                    }else {
                        int skillsAleatorio = rand.nextInt(41)+60;
                        animalList.get(last).setSpeed(skillsAleatorio);

                        skillsAleatorio = rand.nextInt(41)+60;
                        animalList.get(last).setEndurance(skillsAleatorio);

                        skillsAleatorio = rand.nextInt(41)+60;
                        animalList.get(last).setAgility(skillsAleatorio);
                    }
                    // pocho 6 numeros = 1-30
                    // medio 3 numeros = 30-60
                    // gigachad 1 numero = 60-100
                    

            }else {
                System.out.println("You dont have enought money");
            } 
            }
            case 2 -> { if (currentUser.getMoney()>1000){
                currentUser.setMoney(currentUser.getMoney()-1000);
                String[] type = {"Wolf","Horse","Greyhound","Camels"};
                String animtoGen=type[rand.nextInt(type.length)];
                if (animtoGen=="Wolf"){
                    Wgenerator.generateWolf(animalList);
                }else if (animtoGen=="Horse") {
                    Hgenerator.generateHorse(animalList);
                }else if (animtoGen=="Greyhound") {
                    Ggenerator.generateGreyhound(animalList);
                }else if (animtoGen=="Camels") {
                    Cgenerator.generateCamel(animalList);
                }
                    int numeroAleatorio = rand.nextInt(10);
                    int last = animalList.size()-1;
                    animalList.get(last).setMine(true);
                    if(numeroAleatorio > 0 && numeroAleatorio < 6){
                        int skillsAleatorio = rand.nextInt(41)+60;
                        animalList.get(last).setSpeed(skillsAleatorio);

                        skillsAleatorio = rand.nextInt(41)+60;
                        animalList.get(last).setEndurance(skillsAleatorio);

                        skillsAleatorio = rand.nextInt(41)+60;
                        animalList.get(last).setAgility(skillsAleatorio);
                    }else if(numeroAleatorio > 5 && numeroAleatorio < 9) {
                        int skillsAleatorio = rand.nextInt(30)+30;
                        animalList.get(last).setSpeed(skillsAleatorio);

                        skillsAleatorio = rand.nextInt(30)+30;
                        animalList.get(last).setEndurance(skillsAleatorio);

                        skillsAleatorio = rand.nextInt(30)+30;
                        animalList.get(last).setAgility(skillsAleatorio);
                    }else {
                        int skillsAleatorio = rand.nextInt(30);
                        animalList.get(last).setSpeed(skillsAleatorio);

                        skillsAleatorio = rand.nextInt(30);
                        animalList.get(last).setEndurance(skillsAleatorio);

                        skillsAleatorio = rand.nextInt(30);
                        animalList.get(last).setAgility(skillsAleatorio);
                    }
                    animalList.get(last).setPrice((animalList.get(last).getSpeed() + animalList.get(last).getEndurance() + animalList.get(last).getAgility())*8);
            }else {
                System.out.println("You dont have enought money");
            } 
            }
            case 3 -> submenuShop();
        }

    }

    // owned animal selector
    public Animals listAnimals (boolean mine, boolean showPrice) {
        Scanner leer = new Scanner(System.in);
        Animals selected=null;
        do{
        System.out.println("Select an animal from the list using its ID");
        for (Animals animal : animalList) {
            if(mine){
            if (animal.isMine()) {

                animal.viewAnimalInfo(animal.getClass().getName(), showPrice);
                System.out.println("ID:"+ animalList.indexOf(animal));
            }
            }else{
                if (!animal.isMine()) {
                    animal.viewAnimalInfo(animal.getClass().getName(), showPrice);
                    System.out.println("ID:"+ animalList.indexOf(animal));
                }
            } 
        }
        selected=animalList.get(ReadUtilities.ReadIntMM(null, 0 , animalList.size()));
        return selected;
    }while(selected==null);
    }


    // public String listAnimals (boolean mine, boolean showPrice) {
    //     Scanner leer = new Scanner(System.in);
    //     int numAnimals = 0;
    //     String selected=null;
    //     do{
    //     System.out.println("Select an animal from the list");
    //     for (Animals animal : animalList) {
    //         if(mine){
    //         if (animal.isMine()) {
    //             animal.viewAnimalInfo(1, showPrice);
    //         }
    //         }else{
    //             if (!animal.isMine()) {
    //                 animal.viewAnimalInfo(1, showPrice);
    //             }
    //         } 
    //     }
        
    //     selected = leer.next();
    //     for (Animals animal : animalList) {
    //         if(mine){
    //         if (animal.getName().equals(selected) && animal.isMine()) {
    //             return selected;
    //         }
    //         }else{
    //             if (animal.getName().equals(selected) && !animal.isMine()) {
    //                 return selected;
    //             }
    //         }
    //     }
    //     System.out.println("Animal not found with this name");
    //     }while(selected!=null);
    //     return null;
    // }
 

    

}

// System.out.println("""            
//     .  ,
//     |\\/|
//     bd "n.
//    /   _,"n.___.,--x.
//   '\\             Y
//    ~~   \\       L   7|
//          H l--'~\\\\ (||
//          H l     H |`'    -Row (Rowan Crawford)
//          H [     H [
//     ____//,]____//,]___""");
