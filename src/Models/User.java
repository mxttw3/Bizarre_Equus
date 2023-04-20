package Models;
import ENUMS.*;

public class User {
    private String name;
    private String lastName;
    private int age;
    private int money;

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }   

    private boolean gender;
    private difficulty Vdifficulty;


    public User(String name, String lastName, int age, boolean gender, difficulty vdifficulty) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        Vdifficulty = vdifficulty;
        moneyMaker();
    }

    public void moneyMaker() {
        if (this.Vdifficulty == difficulty.EASY_PEASY) {
            this.money = 300;
        } else if (this.Vdifficulty == difficulty.MEDIUM) {
            this.money = 200;
        } else if (this.Vdifficulty == difficulty.DEMON) {
            this.money = 100;
        }
    }

    public void viewUserInfo() {
        if (this.gender == true) {
            System.out.println("""
                men
            """);
            System.out.println("Name: " + this.name + " " + this.lastName + " Age: " + this.age + " Money: " + this.money);       
        }else{
            System.out.println("""
                women
            """);
            System.out.println("Name: " + this.name + " " + this.lastName + " Age: " + this.age + " Money: " + this.money);
        }
    }


}

//               _,,,_
//             .'     `'.
//            /     ____ \
//           |    .'_  _\/
//           /    ) a  a|
//          /    (    > |
//         (      ) ._  /
//         )    _/-.__.'`\
//        (  .-'`-.   \__ )
//         `/      `-./  `.
//          |    \      \  \
//    jgs   |     \   \  \  \
//          |\     `. /  /   \