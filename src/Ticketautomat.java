import java.util.Scanner;

import javax.crypto.KeyAgreement;

public class Ticketautomat {
    private static double priceSingle = 1.8;
    private static double priceDay = 3.4;
    private static double priceWeek = 21.0;
    private static double priceMonth = 80.0;
    private static double priceYear = 850.0;
    private static double priceAddon1 = 2.6;
    private static double priceAddon2 = 3.2;
    private static double priceAddon3 = 3.8;
    private static double priceBike = 2.7;
    private static double paid = 0;
    public static double sum = 0;
    public static int sold = 0;

    static Scanner keyboard = new Scanner(System.in);
    private static boolean check = true;

    public static void Welcome() {
        System.out.println("Hallo, wie kann ich dir helfen?");
        System.out.println("Einzelkarte kaufen [1]");
        System.out.println("Tageskarte kaufen [2]");
        System.out.println("Wochenkarte kaufen [3]");
        System.out.println("Monatskarte kaufen [4]");
        System.out.println("Jahreskarte kaufen [5]");
        System.out.println("Zusatzkarte kaufen [6]");
        int choose = keyboard.nextInt();

        if (choose == 1) {
            Pay(priceSingle, "Einzelkarte");
        } else if (choose == 2) {
            Pay(priceDay, "Tageskarte");
        } else if (choose == 3) {
            Pay(priceWeek, "Wochenkarte");
        } else if (choose == 4) {
            Pay(priceMonth, "Monatskarte");
        } else if (choose == 5) {
            Pay(priceYear, "Jahreskarte");
        } else if (choose == 6) {
            Addon();
        } else if (choose == 9) {
            Login();
        }
    }

    public static void Addon() {
        clearScreen();
        System.out.println("Welche Zusatzkarte benötigst du?");
        System.out.println("Erweiterungskarte 1 [1]");
        System.out.println("Erweiterungskarte 2 [2]");
        System.out.println("Erweiterungskarte 3 [3]");
        System.out.println("Fahrradkarte [4]");
        int chooseAddon = keyboard.nextInt();

        if (chooseAddon == 1) {
            Pay(priceAddon1, "Erweiterungskarte 1");
        } else if (chooseAddon == 2) {
            Pay(priceAddon2, "Erweiterungskarte 2");
        } else if (chooseAddon == 3) {
            Pay(priceAddon3, "Erweiterungskarte 3");
        } else if (chooseAddon == 4) {
            Pay(priceBike, "Fahrradkarte");
        }
    }

    public static void Pay(double x, String y) {
        System.out.println("The Ticket '" + y + "' costs: " + x + "€");
        
        while (paid < x) {
            double dif = x - paid;
            System.out.println("Please pay " + dif + "€ to get your ticket.");
            double pay = keyboard.nextDouble();
            paid += pay;
            sum += pay;
        }

        System.out.println("Do you want to print your ticket? [Y/N]");
        String printCheck = keyboard.next();
        //System.out.println("Printing ticket..");

        if (printCheck.equals("Y") || printCheck.equals("y")) {
            System.out.print("\n\n\n");
            System.out.println("####################");
            System.out.println("# " + y);
            System.out.println("# Valid on: Today");
            System.out.println("####################");
            System.out.print("\n\n\n");
        } else {
            System.out.print("\n\n\n");
            System.out.println("Alright, you can access your ticket via our App.");
            System.out.print("\n\n\n");
        }

        if (paid > x) {
            double ticketChange = paid - x;
            System.out.println("Your change: " + ticketChange + "€");
            sum -= ticketChange;
        }

        paid = 0;
        sold += 1;

        promptEnterKey();
    }

    public static void Login() {
        System.out.println("Enter the password:");
        String pwd = keyboard.next();

        if (pwd.equals("adminaccess2021")) {
            Insights();
        } else {
            System.out.println("Wrong password!");
        }
    }

    public static void Insights() {
        System.out.print("\n\n\n");
        System.out.println("Tickets sold: " + sold);
        System.out.println("Money made: " + sum + "€");
        System.out.print("\n\n\n");

        System.out.println("Press \"0\" to quit the program");
        System.out.println("Press any other number to close the panel");
        int leave = keyboard.nextInt();
        if (leave == 0) {
            System.out.println("Quitting shop..");
            System.exit(0);
        }
        promptEnterKey();
    }

    public static void main(String[] args) {
        while (check == true) {
            clearScreen();
            Welcome();
        }
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    public static void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
