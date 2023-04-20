package Controllers;
import Models.*;
import java.util.ArrayList;

import ENUMS.difficulty;
import Utils.*;

public class functions {
    ArrayList<Animals> animalList = new ArrayList<Animals>();    // |─
    ArrayList<User> userList = new ArrayList<User>();    // |─


    public void createUser() throws InterruptedException {

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

        User user = new User(name, lastName, age, Vgender, optionD);
        userList.add(user);
        userList.
    }


    // MENU
    public void menu() {
        int option = ReadUtilities.ReadIntMM("""
                |─────────────|
                | 1.Bet       |
                | 2.User info |
                | 3.Shop      |
                | 4.Exit      |
                |─────────────|
                """, 1, 5);

        User user = userList;
        switch (option) {
            case 1 -> functions.submenuBet();
            case 2 -> .viewUserInfo();
            case 3 -> functions.submenuShop();
            case 4 -> System.exit(0);
        }
    }

    // SUBMENU BET
    public void submenuBet() {
        int option = ReadUtilities.ReadIntMM("""
            |───────────────|
            |1.Put my animal|
            |2.Start        |   
            |3.Back         |
            |───────────────|

                """, 1, 3);
        switch (option) {
            case 1 -> ;
            case 2 -> ;//TODO: bet menu
            case 3 -> menu();
        }
    }

    // SUBMENU SHOP
    public void submenuShop() {
        int option = ReadUtilities.ReadIntMM("""
                1.Buy
                2.Sell
                3.Breed
                4.Back
                """, 1, 4);
        switch (option) {
            case 1 -> buy();
            case 2 -> ; //TODO: Sell menu
            case 3 -> breeder();
            case 4 -> menu();
        }
    }

    // Buy animal
    public void buy() {
       //TODO: Buy menu
    }



    // Breeder where if you pay 500$ you can breed an animal that has 60% of being a
    // shit 30% of being normal 10% of being gigachad
    public void breeder(User user){
        int option=ReadUtilities.ReadIntMM("""
        Welcome!
        What type of animal do you wana get?
        1.Normal 500$
        2.Super Animal 1000$
        3.Back
        """, 1, 3);
        switch (option) {
            case 1 -> { if (user.getMoney()>500){

            }else {
                System.out.println("You dont have enought money");
            } 
        };
            case 2 -> { if (user.getMoney()>1000){

            }else {
                System.out.println("You dont have enought money");
            } 
        };
            case 3 -> submenuShop();
        }
        // TODO: Breed animals
    }

    // owned animal selector
    public void ownedAnimals () {
        int numAnimals = 0;
        for (Animals animal : animalList) {
            if (animal.isMine()) {
                numAnimals++;
            }
        }
        System.out.println("Number of animals that are mine: " + numAnimals);
    }


    

}
