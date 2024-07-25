package com.java_case_study_2;

import java.util.ArrayList;

public class House {
//        Room Room= new Room();
	   private ArrayList<Room> rooms;

	    public House() {
	        this.rooms = new ArrayList<>();
	    }

	    public void addRoom(Room room) {
	        rooms.add(room);
	    }

//	    public void turnOnDeviceInRoom(String Roomtype, String deviceName) {
//	        for (Room room : rooms) {
//	            if (Roomtype.equals(room.getRoomtype())) {
//	                room.turnOnDevice(deviceName);
//	                break;
//	            }
//	        }
//	    }

//	    public void turnOffDeviceInRoom(String Roomtype, String deviceName) {
//	        for (Room room : rooms) {
//	            if (Roomtype.equals(room.getRoomtype())) {
//	                room.turnOffDevice(deviceName);
//	                break;
//	            }
//	        }
//	    }
	    
	    public void turnOffDeviceInRoom(String roomName, String deviceName) {
	        Room room = findRoomByName(roomName);

	        if (room != null) {
	            Device device = findDeviceByName(room.getDevices(), deviceName);

	            if (device != null) {
	                device.turnOff();
	                System.out.println("Device Successfully turned off in " + roomName);
	            } else {
	                System.out.println("Device not found in the room.");
	            }
	        } else {
	            System.out.println("Room not found.");
	        }
	    }
	     
	    public void turnOnDeviceInRoom(String roomName, String deviceName) {
	        Room room = findRoomByName(roomName);
	        if (room != null) {
	            Device device = findDeviceByName(room.getDevices(), deviceName);
	            if (device != null) {
	                device.turnOn();
	            } else {
	                System.out.println("Device not found in the room.");
	            }
	        } else {
	            System.out.println("Room not found.");
	        }
	    }

	    public Room findRoomByName(String roomName) {
	        for (Room room : rooms) {
	            if (room.getRoomtype().equals(roomName)) {
	                return room;
	            }
	        }
	        return null;
	    }

	    public Device findDeviceByName(ArrayList<Device> devices, String deviceName) {
	        for (Device device : devices) {
	            if (device.getName().equals(deviceName)) {
	                return device;
	            }
	        }
	        return null;
	    }
	    
	    public void displayHomeStatus() {
	        System.out.println("Home Status:");
	        for (Room room : rooms) {
	            room.displayRoomStatus();
	        }
	    }
	    
	    
	    public void displayRooms() {
	        System.out.println("===== Rooms List =====");
	        for (Room room : rooms) {
	            System.out.println(room.getRoomtype());
	        }
	        System.out.println("=======================");
	    }
	    
	    

		public void displayDevicesInRoom(String roomToDisplay) {
			// TODO Auto-generated method stub
			Room room = findRoomByName(roomToDisplay);

	        if (room != null) {
	            System.out.println("Devices in the room " + room.getRoomtype());

	            ArrayList<Device> devicesList = room.getDevices();

	            if (devicesList.isEmpty()) {
	                System.out.println("No devices in the room.");
	            } else {
	                for (Device device : devicesList) {
	                    System.out.println("Device Name: " + device.getName());
	                    System.out.println("Status: " + (device.getStatus() ? "ON" : "OFF"));
	                    // Add more information about the device as needed
	                    System.out.println();
	                }
	            }
	        } else {
	            System.out.println("Room not found.");
	        }
		}
		
		public void displayDevice(String roomToDisplay) {
			Room room = findRoomByName(roomToDisplay);
			if (room != null) {
	            System.out.println("Devices in the room " + room.getRoomtype());

	            ArrayList<Device> devicesList = room.getDevices();

	            if (devicesList.isEmpty()) {
	                System.out.println("No devices in the room.");
	            } else {
	            	// Assuming Device class has a method getName() to retrieve the device name
	            	for (Device device : devicesList) {
	            	    System.out.printf("| %-20s |\n", "Device Name: " + device.getName());
	            	}

	            }
	        } else {
	            System.out.println("Room not found.");
	        }
		}

}
