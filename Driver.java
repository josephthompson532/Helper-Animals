package com.example.awtExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    // Creating a monkey arraylist to hold monkeys.
    public static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    public static void main(String[] args) {

        // Instantiating an instance of the Scanner Class
        Scanner scanner = new Scanner(System.in);

        initializeDogList();
        initializeMonkeyList();

        // create a boolean 'add' to be the switch for ending the while-loop
        boolean add=true;

        // begin the while loop using add as the condition.
        while(add) {
            // Showing the initial menu
            displayMenu();
            // getting input from the user
            String input = scanner.next();
            // using a switch statement to implement input validation as well as organize method paths.
            switch(input) {

                // calling the corresponding function for each individual path
                // passing the scanner object into the methods so that I can use it in the methods themselves.
                case "1":
                    intakeNewDog(scanner);
                    break;
                case "2":
                    intakeNewMonkey(scanner);
                    break;
                case "3":
                    reserveAnimal(scanner);
                    break;
                // For each of the 3 printAnimals methods, the only difference is the default
                // string I am passing to them.
                case "4":
                    printAnimals(scanner,"Dog");
                    break;
                case "5":
                    printAnimals(scanner,"Monkey");
                    break;
                case "6":
                    printAnimals(scanner,"Available");
                    break;
                // when the user wants to quit, they enter "q" and add is then set to false
                // this will end the while-loop
                case "q":
                    add=false;
                    break;
                // if the user enters input that does not match any of the cases, they will be
                // given a message clarifying proper input and sent back to the beginning of the while-loop
                default:
                    System.out.println("Your input must be a number between 1 and 6 inclusive or the letter \"q\"");
                    break;
            }

        }

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
	// For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
	// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.

    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", false, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Gibbles","Squirrel monkey", "M","14","566", "05-12-2019","United States", "Phase 2", true, "nope", 43, 45, 22);
        Monkey monkey2 = new Monkey("Carl","Squirrel monkey", "M","14","566", "05-12-2019","United States", "in service", false, "nope", 43, 45, 22);
        Monkey monkey3 = new Monkey("Marco","Squirrel monkey", "M","14","566", "05-12-2019","United States", "in service", false, "nope", 43, 45, 22);

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);

    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.print("What is the dog's name? ");
        scanner.nextLine();
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Print a messaging asking the user for each piece of input needed to instantiate a new Dog class.
        // Then use scanner to save that input to a variable.
        System.out.print("What is the dog's breed? ");
        String breed = scanner.nextLine();
        System.out.print("What is the dog's gender? ");
        String gender = scanner.nextLine();
        System.out.print("What is the dog's age? ");
        String age = scanner.nextLine();
        System.out.print("What is the dog's weight? ");
        String weight = scanner.nextLine();
        System.out.print("What is the dog's acquisition date? ");
        String acquisitionDate = scanner.nextLine();
        System.out.print("What is the dog's acquisition country? ");
        String acquisitionCountry = scanner.nextLine();
        System.out.print("What is the dog's training status? ");
        String trainingStatus = scanner.nextLine();
        System.out.print("What is the dog's reserved status? ");
        // parse the boolean value from the scanner.
        String reservedString = scanner.nextLine();
        // validate that input can be parsed into a boolean using a while loop.
        while (!(reservedString.equalsIgnoreCase("true") || reservedString.equalsIgnoreCase("false"))) {
            System.out.println("Acceptable values for \"reserved\" are true or false");
            reservedString = scanner.nextLine();
        }
        boolean reserved = Boolean.parseBoolean(reservedString);
        System.out.print("What is the dog's in service country?");
        String inService = scanner.nextLine();

        // Use the input gathered to instantiate a new Dog Object
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inService);
        // Add the new Dog object to the dogList.
        dogList.add(newDog);
        // Add the code to instantiate a new dog and add it to the appropriate list
    }


        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
            System.out.print("What is the monkey's name? ");
            scanner.nextLine();
            String name = scanner.nextLine();
            for(Monkey monkey: monkeyList) {
                if(monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis Monkey is already in our system\n\n");
                    return; //returns to menu
                }
            }

            // Print a messaging asking the user for each piece of input needed to instantiate a new Dog class.
            // Then use scanner to save that input to a variable.
            System.out.print("What is the Monkey's species? ");
            String species = scanner.nextLine();
            // Creating a list with all of the acceptable monkey species names
            ArrayList<String> validSpecies = new ArrayList<>(Arrays.asList("capuchin","guenon","macaque","marmoset","squirrel monkey","tamarin"));
            // using a while-loop and the ArrayList.contains method to validate the input species
            while (!(validSpecies.contains(species.toLowerCase()))) {
                System.out.println("That is not a valid species. Try again.");
                species = scanner.nextLine();
            }
            System.out.print("What is the monkey's gender? ");
            String gender = scanner.nextLine();
            System.out.print("What is the monkey's age? ");
            String age = scanner.nextLine();
            System.out.print("What is the monkey's weight? ");
            String weight = scanner.nextLine();
            System.out.print("What is the monkey's acquisition date? ");
            String acquisitionDate = scanner.nextLine();
            System.out.print("What is the monkey's acquisition country? ");
            String acquisitionCountry = scanner.nextLine();
            System.out.print("What is the monkey's training status? ");
            String trainingStatus = scanner.nextLine();
            System.out.print("What is the monkey's reserved status? ");
            // parse the boolean value from the scanner.
            String reservedString = scanner.nextLine();
            // validate that input can be parsed into a boolean using a while loop.
            while (!(reservedString.equalsIgnoreCase("true") || reservedString.equalsIgnoreCase("false"))) {
                System.out.println("Acceptable values for \"reserved\" are true or false. Try again.");
                reservedString = scanner.nextLine();
            }
            boolean reserved = Boolean.parseBoolean(reservedString);
            System.out.print("What is the monkey's in service country? ");
            String inService = scanner.nextLine();

            // Get the monkey's tailLength as an int, while validating input.
            System.out.print("What is the monkey's tailLength? ");
            // Initializing the tailLength variable in the proper scope and initializing to zero.
            int tailLength = 0;
            // starting a while-loop
            while (true) {
                // using a try and catch block to validate input
                try {
                    tailLength = scanner.nextInt();
                    // break if the input is an int
                    break;
                }
                // catch if the input is anything other than an int with an InputMismatchException
                catch (InputMismatchException e) {
                    System.out.print("Input must be an integer. Please enter an integer.");
                    scanner.nextLine();
                }
            }

            // doing the same as for tailLength but for the monkey's height
            System.out.print("What is the Monkey's height? ");
            int height = 0;
            while (true) {
                try {
                    height = scanner.nextInt();
                    break;
                }
                catch (InputMismatchException e) {
                    System.out.print("Input must be an integer. Please enter an integer.");
                    scanner.nextLine();
                }
            }

            // doing the same as for tailLength but for the monkey's bodyLength
            System.out.print("What is the Monkey's bodyLength? ");
            int bodyLength = 0;
            while (true) {
                try {
                    bodyLength = scanner.nextInt();
                    break;
                }
                catch (InputMismatchException e) {
                    System.out.print("Input must be an integer. Please enter an integer.");
                    scanner.nextLine();
                }
            }


            // Use the input gathered to instantiate a new Dog Objevt
            Monkey newMonkey = new Monkey(name, species, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inService, tailLength, height, bodyLength);
            // Add the new Dog object to the dogList.
            monkeyList.add(newMonkey);
        }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {

            // gather initial input about the type of animal and the name of the animal the user would
            // like to reserve
            System.out.println("What is the type of animal you would like to reserve");
            scanner.nextLine();
            String animalType = scanner.nextLine();
            System.out.println("What is the animal's name that you would like to reserve");
            String animalName = scanner.nextLine();

            // Begin handling the various cases

            // Check if the animalType is a Dog
            if(animalType.equalsIgnoreCase("Dog")) {
                // loop through the dog list
                for(Dog dog : dogList) {
                    // check if each dog is the dog requested
                    if (dog.getName().equalsIgnoreCase(animalName)) {
                        // if the dog is the one requested by the user, check if the dog is already reserved
                        if (Boolean.TRUE.equals(dog.getReserved())) {
                            // If the dog is already reserved, let the user know. Tell them to press enter
                            // to continue
                            System.out.println("This animal is already reserved. Press Enter to continue");
                            //add a scanner.nextLine() so that the user must press enter to circle back to
                            // the beginning of the while-loop.
                            scanner.nextLine();
                            //return so that the method ends and no other print statements are triggered.
                            return;
                        // if the dog is not reserved, set reserved to true.
                        } else {
                            // set reserved to true
                            dog.setReserved(true);
                            //Tell them to press enter to continue.
                            System.out.println("We have reserved this dog for you. Press Enter to continue");
                            scanner.nextLine();
                            //return so that the method ends and no other print statements are triggered.
                            return;
                        }
                    }
                }
                // if none of the dogs in the list match with the input name, let the user know.
                System.out.println("Sorry, but we don't have a dog with that name here. \nPress Enter to continue");
                scanner.nextLine();
                return;
            // Check if the animalType is a Dog
            } else if (animalType.equalsIgnoreCase("Monkey")) {
                // loop through the monkey list
                for(Monkey monkey : monkeyList) {
                    // check if each monkey is the monkey requested
                    if (monkey.getName().equalsIgnoreCase(animalName)) {
                        // if the monkey is the one requested by the user, check if the monkey is already reserved
                        if (Boolean.TRUE.equals(monkey.getReserved())) {
                            // If the dog is already reserved, let the user know.
                            System.out.println("This animal is already reserved. Press Enter to continue");
                            scanner.nextLine();
                            // return so no further print statements are triggered.
                            return;
                        // if the monkey is not reserved, set reserved to true.
                        } else {
                            // set monkey to reserved
                            monkey.setReserved(true);
                            // let the user know the monkey is reserved.
                            System.out.println("We have reserved this monkey for you. Press Enter to continue");
                            scanner.nextLine();
                            // return so no further print statements are triggered.
                            return;
                        }
                    }
                }
                // if none of the monkeys in the list match with the input name, let the user know.
                System.out.println("Sorry, but we don't have a monkey with that name here. Press Enter to continue");
                scanner.nextLine();
                return;
            }
        }

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
        // Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
	    // Remember that you only have to fully implement ONE of these lists.
	    // The other lists can have a print statement saying "This option needs to be implemented".
	    // To score "exemplary" you must correctly implement the "available" list.

        public static void printAnimals(Scanner scanner, String listType) {

            // NOTE: The instructions in this file vs the specification documents were incongruous. I was unsure
            // how you wanted the Dog and Monkey cases structured. However, it shouldn't matter for this submission
            // because I completed the "Available" option.

            // if the listType parameter is "Dog", loop through the dogs list and print out dog details
            if(listType.equalsIgnoreCase("Dog")) {
                for(Dog dog : dogList) {
                    System.out.println("Name: " + dog.getName());
                    System.out.println("status: " + dog.getTrainingStatus());
                    System.out.println("acquisition country: " + dog.getAcquisitionLocation());
                    System.out.println("reserved: " + dog.getReserved());
                    System.out.println();
                }
                System.out.print("Press enter to continue");
                // add scanner lines so the method is not immediately exited. Otherwise the displayMenu
                // will show too soon,
                scanner.nextLine();
                scanner.nextLine();
            }

            // if the listType parameter is "Monkey", loop through the monkey list and print out monkey details
            if(listType.equalsIgnoreCase("Monkey")) {
                for(Monkey monkey : monkeyList) {
                    System.out.println("Name: " + monkey.getName());
                    System.out.println("status: " + monkey.getTrainingStatus());
                    System.out.println("acquisition country: " + monkey.getAcquisitionLocation());
                    System.out.println("reserved: " + monkey.getReserved());
                    System.out.println();
                }
                System.out.print("Press enter to continue");
                // add scanner lines so the method is not immediately exited. Otherwise the displayMenu
                // will show too soon,
                scanner.nextLine();
                scanner.nextLine();
            }


            if(listType.equalsIgnoreCase("Available")) {
                // create an arraylist of the dogList and monkeyList
                ArrayList<ArrayList<? extends RescueAnimal>> listOfLists = new ArrayList<ArrayList<? extends RescueAnimal>>() {{add(dogList);add(monkeyList);}};

                // loop over the ArrayList of ArrayLists
                // Use generics so that each arraylist must extend from RescueAnimal
                for(ArrayList<? extends RescueAnimal> animalList : listOfLists) {
                    // Loop through each RescueAnimal in each Arraylist.
                    for( RescueAnimal animal : animalList) {
                        // Check if each animal in each arraylist is "in service" and not reserved
                        if (animal.getTrainingStatus().equalsIgnoreCase("in service") && !(Boolean.TRUE.equals(animal.getReserved()))) {
                            // if "in service" and not reserved, print details of that animal
                            System.out.println("Name: " + animal.getName());
                            System.out.println("status: " + animal.getTrainingStatus());
                            System.out.println("acquisition country: " + animal.getAcquisitionLocation());
                            System.out.println("reserved: " + animal.getReserved());
                            System.out.println();
                        }
                    }
                }
                System.out.print("Press enter twice to continue");
                // add scanner lines so the method is not immediately exited. Otherwise the displayMenu
                // will show too soon,
                scanner.nextLine();
                scanner.nextLine();

            }



        }
}

