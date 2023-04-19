package Controllers;
import Models.*;
import java.util.ArrayList;

import Utils.*;

public class functions {
    ArrayList<Animals> animalList = new ArrayList<Animals>();    // |─

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
            case 1 -> functions.submenuBet();
            case 2 -> user.viewUserInfo();
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
    public void breeder(){
        int option=ReadUtilities.ReadIntMM("""
        Welcome!
        What type of animal do you wana get?
        1.Normal 500$
        2.Super Animal 100$
        3.Back
        """, 1, 3);
        switch (option) {
            case 1 -> ;
            case 2 -> ;
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
