import java.util.Scanner;

public class Ticketautomat {
    private static double priceSingle = 1.8;
    private static double priceDay = 3.4;
    private static double priceWeek = 21.0;
    private static double paid = 0;
    public static double sum = 0;
    public static int sold = 0;

    static Scanner keyboard = new Scanner(System.in);
    private static boolean check = true;

    public static void Welcome() {
        System.out.println("Hello, how can I help you today?");
        System.out.println("Buy Single Ticket [1]");
        System.out.println("Buy Day Ticket [2]");
        System.out.println("Buy Week Ticket [3]");
        int choose = keyboard.nextInt();

        if (choose == 1) {
            System.out.println("Single Ticket currently unavailable..");
            Pay(priceSingle, "Single Ticket");
        } else if (choose == 2) {
            System.out.println("Day Ticket currently unavailable..");
            Pay(priceDay, "Day Ticket");
        } else if (choose == 3) {
            System.out.println("Week Ticket currently unavailable..");
            Pay(priceWeek, "Week Ticket");
        } else if (choose == 9) {
            System.out.println("Insights currently unavailable..");
            Login();
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
