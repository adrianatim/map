package view;

import controller.Controller;
import entities.Animal;
import entities.Fish;
import entities.Turtle;

import java.util.Scanner;

public class View {

    private final Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public static void printMenu() {
        System.out.println("---------------Menu---------------");
        System.out.println("0. Exit");
        System.out.println("1. Add a fish");
        System.out.println("2. Add a turtle");
        System.out.println("3. Remove a fish");
        System.out.println("4. Remove a turtle");
        System.out.println("5. Show the animals");
        System.out.println("6. Show the animal older than a given number");
    }


    public void viewAddFish() {

        String name;

        int id, age;
        Scanner myObject = new Scanner(System.in);
        System.out.println("Give the id:");
        id = Integer.parseInt(myObject.nextLine());
        System.out.println(id);
        System.out.println("Give the age:");
        age = Integer.parseInt(myObject.nextLine());
        System.out.println("Give the name:");
        name = myObject.nextLine();

        Animal a = new Fish(id, age, name);

        try {
            controller.controllerAddAnimal(a);
        } catch (Exception e) {
            System.err.println(e.getMessage());

        }

    }

    public void viewAddTurtle() {

        String name;

        int id, age;
        Scanner myObject = new Scanner(System.in);
        System.out.println("Give the id:");
        id = Integer.parseInt(myObject.nextLine());
        System.out.println(id);
        System.out.println("Give the age:");
        age = Integer.parseInt(myObject.nextLine());
        System.out.println("Give the name:");
        name = myObject.nextLine();

        Animal a = new Turtle(id, age, name);

        try {
            controller.controllerAddAnimal(a);
        } catch (Exception e) {
            System.err.println(e.getMessage());

        }
    }

    public void viewRemoveAnimal() {
        int id;
        Scanner myObject = new Scanner(System.in);
        System.out.println("Give the id:");
        id = Integer.parseInt(myObject.nextLine());

        try {
            this.controller.controllerRemoveAnimal(id);
        } catch (Exception e) {
            System.err.println(e.getMessage());

        }
    }

    public void viewShowOlderAnimals() {
        int age;
        Scanner myObject = new Scanner(System.in);
        System.out.println("Give the age:");
        age = Integer.parseInt(myObject.nextLine());
        Animal[] animals = this.controller.controllerGetAll();
        for (int i = 0; i < this.controller.controllerGetSize(); i++) {
            if (animals[i].getAge() > age) {
                System.out.println(animals[i]);
            }
        }

    }

    public void showAllAnimals() {
        Animal[] animals = this.controller.controllerGetAll();
        for (int i = 0; i < this.controller.controllerGetSize(); i++) {
            System.out.println(animals[i]);
        }
    }

    public void run() {
        int input;
        View.printMenu();

        Scanner myObject = new Scanner(System.in);
        System.out.println("\nGive the command:");
        input = Integer.parseInt(myObject.nextLine());

        while (input != 0) {

            switch (input) {
                case 1:
                    viewAddFish();
                    break;
                case 2:
                    viewAddTurtle();
                    break;
                case 3:
                    viewRemoveAnimal();
                    break;
                case 4:
                    viewRemoveAnimal();
                    break;
                case 5:
                    showAllAnimals();
                    break;
                case 6:
                    viewShowOlderAnimals();
                    break;

            }
            System.out.println("\nGive the command:");
            input = Integer.parseInt(myObject.nextLine());

        }
    }

}
