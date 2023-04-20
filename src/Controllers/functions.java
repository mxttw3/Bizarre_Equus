package Controllers;
import Models.*;
import java.util.ArrayList;

import ENUMS.difficulty;
import Utils.*;

public class functions {
    ArrayList<Animals> animalList = new ArrayList<Animals>();    // |─


    public void createUser() {

        String name = ReadUtilities.readWord("""
                |─────────────|
                | 1.Bet       |
                |─────────────|
                """);
        String lasName = ReadUtilities.readWord("""
                |─────────────|
                | 1.Bet       |
                |─────────────|
                """);
        int age = ReadUtilities.ReadIntMM("""
                |─────────────|
                | 1.Bet       |
                |─────────────|
                """, 1, 110);
        // boolean gender = ReadUtilities.readWord("""
        //         |─────────────|
        //         | 1.Bet       |
        //         |─────────────|
        //         """);
        int difficulty = ReadUtilities.ReadIntMM("""
                |─────────────|
                | 1.Bet       |
                |─────────────|
                """, 1, 3);
        difficulty optionD;
        switch (difficulty) {
            case 1 -> optionD = difficulty.EASY_Peasy;
            case 2 -> optionD = difficulty.MEDIUM;
            case 3 -> optionD = difficulty.DEMON;
        }


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
        switch (option) {
            case 1 -> submenuBet();
            case 2 -> User.viewUserInfo();
            case 3 -> submenuShop();
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
