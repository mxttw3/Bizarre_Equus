package Utils;

import java.util.Scanner;

public final class ReadUtilities {
    private static Scanner read = new Scanner(System.in);
    // Colors
    final static String ANSI_RED = "\u001B[31m";
    final static String ANSI_RESET = "\u001B[0m";

    /**
     * Constructor privat que NO permet crear objectes de la classe Utilities
     */
    private ReadUtilities(){};

    /**
     * Read INT from console
     * @param message output message in console
     * @param min minimum number accepted
     * @param max maximum number accepted
     * @return INT number
     */
    public static int ReadIntMM(String message, int min, int max){
        int num = 0;
        boolean loop  = false;

        while(!loop){
            System.out.println(message);
            if(read.hasNextInt()){
                num = read.nextInt();
                if(num >= min && num <= max) {
                    loop = true;
                }else{
                    System.out.println("The number has to be inside " + ANSI_RED + min + ANSI_RESET + " & " + ANSI_RED + max + ANSI_RESET);                }
            }else{
                System.out.println("You have to introduce a number!!");
            }
            read.nextLine();
        }
        return num;
    }

    /**
     * Read INT from console
     * @param message output message in console
     * @return INT number
     */
    public static int ReadInt(String message){
        int num = 0;
        boolean loop  = false;

        while(!loop){
            System.out.println(message);
            if(read.hasNextInt()){
                num = read.nextInt();
                loop = true;
            }else{
                System.out.println("You have to introduce a number!!");
            }
            read.nextLine();
        }
        return num;
    }

    /**
     * Read FLOAT from console
     * @param message output message in console
     * @param min minimum number accepted
     * @param max maximum number accepted
     * @return FLOAT number
     */
    public static float ReadFloatMM(String message, float min, float max) {
        float num = 0;
        boolean loop  = false;

        while(!loop){
            System.out.println(message);
            boolean correctValue = read.hasNextFloat();
            if(correctValue){
                num = read.nextFloat();
                if(num >= min && num <= max) {
                    loop = true;
                }else{
                    System.out.println("The number has to be inside " + ANSI_RED + min + ANSI_RESET + " & " + ANSI_RED + max + ANSI_RESET);
                }
            }else{
                System.out.println("You have to introduce a number!!");
            }
            read.nextLine();
        }
        return num;
    }

    /**
     * Read FLOAT from console
     * @param message output message in console
     * @return FLOAT number
     */
    public static float ReadFloat(String message) {
        float num = 0;
        boolean loop  = false;

        while(!loop){
            System.out.println(message);
            boolean correctValue = read.hasNextFloat();
            if(correctValue){
                num = read.nextFloat();
                loop = true;
            }else{
                System.out.println("You have to introduce a number!!");
            }
            read.nextLine();
        }
        return num;
    }

    /**
     * Mètode per a read una frase amb espais
     * @param missatge
     * @return
     */
    public static String readFrase(String missatge){
        System.out.println(missatge);
        return read.nextLine();
    }

    /**
     * Mètode per a read una paraula sense espais
     * @param missatge
     * @return
     */
    public static String readParaula(String missatge){
        String paraula;
        System.out.println(missatge);
        paraula = read.next();
        read.nextLine();

        return paraula;
    }
 
}
