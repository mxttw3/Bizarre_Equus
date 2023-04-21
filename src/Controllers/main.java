package Controllers;
import java.util.ArrayList;
import Models.*;

public class main {
    public static void main(String[] args) throws Exception {
        Animals hola = new Camels(null, 0, null, null, null, null, false, 0, 0, 0, false, 0, null);
        ArrayList<Animals> animals = new ArrayList<Animals>();
        animals.add(hola);
        hola.viewAscii();
                System.out.println("""
                            .''
                  ._.-.___.' (`\\
                 //(        ( `'
                '/ )\\ ).__. )\s
                ' <' `\\ ._/'\\
                   `   \\     \\""");
                   System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────");                           
        functions m = new functions();
        m.createUser();
        m.menu();

    }
}
