package machine;

import java.util.Scanner;

public class CoffeeMachineGo {
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550;

    CoffeeTypes espresso = CoffeeTypes.ESPRESSO;
    CoffeeTypes latte = CoffeeTypes.LATTE;
    CoffeeTypes cappuccino = CoffeeTypes.CAPPUCCINO;

    public Scanner scanner = new Scanner(System.in);

    public void printText() {
        System.out.println("\nThe coffee machine has: ");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
    }

    public void action() {
       do {
           System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
           String action = scanner.next();
           switch (action) {
               case "buy":
                   buy();
                   break;
               case "fill":
                   fill();
                   break;
               case "take":
                   take();
                   break;
               case "remaining":
                   printText();
                   break;
               case "exit":
                   System.exit(0);
                   break;
           }
       } while (true);
    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String action2 = scanner.next();
        switch (action2) {
            case "1":
               espresso();
                break;
            case "2":
                latte();
                break;
            case "3":
                cappuccino();
                break;
            case "back":
                action();
                break;
        }
    }

    public void fill() {
        System.out.println("\nWrite how many ml of water do you want to add:");
        water += Integer.parseInt(scanner.next());
        System.out.println("Write how many ml of milk do you want to add:");
        milk += Integer.parseInt(scanner.next());
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += Integer.parseInt(scanner.next());
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += Integer.parseInt(scanner.next());
    }

    public void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public boolean checkResources(int newWater, int newmilk, int newBeans) {
        boolean output;
        if (water - newWater < 0) {
            System.out.println("Sorry, not enough water!");
            output = false;
        } else if (milk - newmilk < 0) {
            System.out.println("Sorry, not enough milk!");
            output = false;
        } else if (beans - newBeans < 0) {
            System.out.println("Sorry, not enough coffee beans!");
            output = false;
        } else if (cups - 1 < 0) {
            System.out.println("Sorry, not enough cups!");
            output = false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            output = true;
        }
        return output;
    }

    public void latte() {
        boolean condition = checkResources(350, 75, 20);
        if (condition) {
            water -= 350;
            milk -= 75;
            beans -= 20;
            cups -= 1;
            money += 7;
        }
    }

    public void espresso() {
        boolean condition = checkResources(250, 0, 16);
        if (condition) {
            water -= 250;
            beans -= 16;
            cups -= 1;
            money += 4;
        }
    }

    public void cappuccino() {
        boolean condition = checkResources(200, 100, 12);
        if (condition) {
            water -= 200;
            milk-= 100;
            beans -= 12;
            cups -= 1;
            money += 6;
        }
    }
}