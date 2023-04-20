package Controllers;
import Models.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


import ENUMS.difficulty;
import Utils.*;

public class functions {
    ArrayList<Animals> animalList = new ArrayList<Animals>();    // |─
    Horse juan = new Horse("juan",0,"black",null,"brown","green",true,1,5,10,true,"Tuabuela",100);

    Horse juan2 = new Horse("juan2",0,"black",null,"brown","green",false,1,5,10,false,"Tuabuela",100);
    User currentUser = null;

    // añadir animales creados al arraylist
    public void createUser() throws InterruptedException {
        animalList.addAll(Arrays.asList(juan, juan2));
        HorseGenerator Hgenerator = new HorseGenerator();
        Hgenerator.generateHorse(animalList);

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
            case 1 -> menu();
            case 2 -> menu();//TODO: bet menu
            case 3 -> menu();
        }
    }

    public void AnimalsForRace() {
        //TODO: poner animales en la carrera
        
    }

    public void StartRace() {
        //TODO: EmpezarCarrera
        

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
                Animals animal1= listAnimals(true, false);
                Animals animal2= listAnimals(true, false);
            }else {
                System.out.println("You dont have enought money");
            } 
            }
            case 2 -> { if (currentUser.getMoney()>1000){
                currentUser.setMoney(currentUser.getMoney()-1000);
            }else {
                System.out.println("You dont have enought money");
            } 
            }
            case 3 -> submenuShop();
        }
        // TODO: Breed animals
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
                animal.viewAnimalInfo(1, showPrice);
                System.out.println("ID:"+ animalList.indexOf(animal));
            }
            }else{
                if (!animal.isMine()) {
                    animal.viewAnimalInfo(1, showPrice);
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