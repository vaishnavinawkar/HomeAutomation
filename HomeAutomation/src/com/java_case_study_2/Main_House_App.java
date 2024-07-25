package com.java_case_study_2;



import java.util.ArrayList;
import java.util.Scanner;

public class Main_House_App {
    public static void main(String[] args) {
        // Creating the home automation app
        House app = new House();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
        	System.out.println("|============================== Home Automation Menu ==============================|");
            System.out.println("| 1. Create Room                       | 2. Add Device to Room                     |");
            System.out.println("| 3. Turn On Device                    | 4. Show House Status                      |");
            System.out.println("| 5. Display Rooms                     | 6. Display Devices in Room                |");
            System.out.println("| 7. Turn Off Device                   | 0. Exit                                   |");
            System.out.println("|==================================================================================|");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createRoom(app, scanner);
                    break;
                case 2:
                    addDeviceToRoom(app,scanner);
                    break;
                case 3:
                   turnOnDevice(app,scanner);
                    break;
                case 4:
                    app.displayHomeStatus();
                    break;
                case 5:
                    app.displayRooms();
                    break;
                case 6:
                    System.out.print("Enter the name of the room to display devices: ");
                    String roomToDisplay = scanner.next();
                    app.displayDevicesInRoom(roomToDisplay);
                    break;
                case 7:
                	turnOffDevice(app,scanner);
                	break;
                case 0:
                    System.out.println("Exiting Home Automation App. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        } while (choice != 0);

        scanner.close();
    }
    
    
    //create room method
    private static void createRoom(House app, Scanner scanner) {
    	int choice;
    	do{
    		System.out.println("+============================+");
	        System.out.println("|          Room list         |");
	        System.out.println("+----------+-----------------+");
	        System.out.println("|  Option  |   Room          |");
	        System.out.println("+----------+-----------------+");
	        System.out.println("|   1      |   Kitchen       |");
	        System.out.println("|   2      |   BedRoom       |");
	        System.out.println("|   3      |   Living Area   |");
	        System.out.println("|   4      |   Dining Area   |");
	        System.out.println("|   5      |   WashRoom      |");
	        System.out.println("|   6      |   Corridors     |");
	        System.out.println("|   7      |   Exit          |");
	        System.out.println("+----------+-----------------+");
    		System.out.print("Enter the type of the room: ");
            String roomType = scanner.next();
            Room room = new Room(roomType, new ArrayList<Device>());
            app.addRoom(room);
            System.out.println("Room created successfully: " + roomType);

//            addDeviceToRoom(app,scanner);
            
            System.out.println("\n");
            System.out.println("Do you want to create another Room");
            System.out.println("If yes the press 1 otherwise press 0");
            choice = scanner.nextInt();
    	}while(choice == 1);
        
    }
    
    //add device to room method

    private static void addDeviceToRoom(House app, Scanner scanner) {
    	int exit;
    	do {
    		System.out.println("|============= Device List ==============|");
        	System.out.println("|  Option  |            Device           |");
        	System.out.println("|----------|-----------------------------|");
        	System.out.println("|    1     |   Television                |");
        	System.out.println("|    2     |   AC                        |");
        	System.out.println("|    3     |   Showers                   |");
        	System.out.println("|    4     |   Lights                    |");
        	System.out.println("|    5     |   Exit                      |");
        	System.out.println("|========================================|");


        System.out.print("Enter your choice: ");
        int deviceChoice = scanner.nextInt();

        System.out.print("Enter the name of the room to add the device: ");
        String roomName = scanner.next();
        Room room = app.findRoomByName(roomName);

        if (room != null) {
            Device device = null;
            switch (deviceChoice) {
                case 1:
                    device = new TV();
                    break;
                case 2:
                    device = new AC();
                    break;
                case 3:
                    device = new Showers();
                    break;
                case 4:
                    device = new Lights();
                    break;
                case 5:
                	System.out.println("No device added");
                    return; 
                default:
                    System.out.println("Invalid choice. No device added.");
                    return;
            }

            room.addDevice(device);
            System.out.println(device.getName() + " added successfully to room: " + roomName);
        } else {
            System.out.println("Room not found.");
        }
        System.out.println("\n");
        System.out.println("Do you want to add another Device to "+ roomName);
        System.out.println("If yes the press 1 otherwise press 0");
        exit= scanner.nextInt();
        
    	}while(exit == 1);
    }
    
    //turnonDevice method
    private static void turnOnDevice(House app, Scanner scanner) {
    	int exit;
    	do {
    		
    		        System.out.println("+============================+");
    		        System.out.println("|          Room list         |");
    		        System.out.println("+----------+-----------------+");
    		        System.out.println("|  Option  |   Room          |");
    		        System.out.println("+----------+-----------------+");
    		        System.out.println("|   1      |   Kitchen       |");
    		        System.out.println("|   2      |   BedRoom       |");
    		        System.out.println("|   3      |   Living Area   |");
    		        System.out.println("|   4      |   Dining Area   |");
    		        System.out.println("|   5      |   WashRoom      |");
    		        System.out.println("|   6      |   Corridors     |");
    		        System.out.println("|   7      |   Exit          |");
    		        System.out.println("+----------+-----------------+");
    		   

        System.out.print("Enter the name of the room: ");
        String roomName = scanner.next();
        Room room = app.findRoomByName(roomName);

        if (room != null) {
            int deviceChoice;

            do {


  System.out.println("|============= Device List ==============|");
  System.out.println("|  Option  |            Device           |");
  System.out.println("|----------|-----------------------------|");
  System.out.println("|    1     |   Turn on Television        |");
  System.out.println("|    2     |   Turn on AC                |");
  System.out.println("|    3     |   Turn on Showers           |");
  System.out.println("|    4     |   Turn on Lights            |");
  System.out.println("|    5     |   Exit                      |");
  System.out.println("|========================================|");
                System.out.print("Enter your choice: ");
                deviceChoice = scanner.nextInt();

                switch (deviceChoice) {
                    case 1:
                        room.turnOnDevice("TV");
                        break;
                    case 2:
                        room.turnOnDevice("AC");
                        break;
                    case 3:
                        room.turnOnDevice("Showers");
                        break;
                    case 4:
                        room.turnOnDevice("Lights");
                        break;
                    case 5:
                        return; // Exit the device menu
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } while (deviceChoice != 0);

            System.out.println("All devices that present in "+ roomName +" is turned ON ");
        } else {
            System.out.println("Room not found.");
        }
        System.out.println("\n");
        System.out.println("Do you want to turn on  another Device");
        System.out.println("If yes the press 1 otherwise press 0");
        exit= scanner.nextInt();
    	}while(exit==1);
    } 
    
    //Method to turn off device
    private static void turnOffDevice(House app, Scanner scanner) {
    	int exit;
    	do {
    		System.out.println("+============================+");
	        System.out.println("|          Room list         |");
	        System.out.println("+----------+-----------------+");
	        System.out.println("|  Option  |   Room          |");
	        System.out.println("+----------+-----------------+");
	        System.out.println("|   1      |   Kitchen       |");
	        System.out.println("|   2      |   BedRoom       |");
	        System.out.println("|   3      |   Living Area   |");
	        System.out.println("|   4      |   Dining Area   |");
	        System.out.println("|   5      |   WashRoom      |");
	        System.out.println("|   6      |   Corridors     |");
	        System.out.println("|   7      |   Exit          |");
	        System.out.println("+----------+-----------------+");

        System.out.print("Enter the name of the room: ");
        String roomName = scanner.next();
        Room room = app.findRoomByName(roomName);

        if (room != null) {
            int deviceChoice;

            do {
            	System.out.println("|============= Device List ==============|");
            	System.out.println("|  Option  |            Device           |");
            	System.out.println("|----------|-----------------------------|");
            	System.out.println("|    1     |   Turn off Television        |");
            	System.out.println("|    2     |   Turn off AC                |");
            	System.out.println("|    3     |   Turn off Showers           |");
            	System.out.println("|    4     |   Turn off Lights            |");
            	System.out.println("|    5     |   Exit                      |");
            	System.out.println("|========================================|");


                System.out.print("Enter your choice: ");
                deviceChoice = scanner.nextInt();

                switch (deviceChoice) {
                    case 1:
                    	 room.turnOffDevice("TV");
                        break;
                    case 2:
                        room.turnOffDevice("AC");
                        break;
                    case 3:
                        room.turnOffDevice("Showers");
                        break;
                    case 4:
                        room.turnOffDevice("Lights");
                        break;
                    case 5:
                        return; // Exit the device menu
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } while (deviceChoice != 0);

            System.out.println("Device Successfully turned off in "+ roomName);
        } else {
            System.out.println("Room not found.");
        }
        System.out.println("\n");
        System.out.println("Do you want to turn on  another Device");
        System.out.println("If yes the press 1 otherwise press 0");
        exit= scanner.nextInt();
    	}while(exit==1);
    } 
 
}

