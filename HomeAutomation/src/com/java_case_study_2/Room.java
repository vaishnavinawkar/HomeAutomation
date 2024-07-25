package com.java_case_study_2;

import java.util.ArrayList;

public class Room {
  private String Roomtype;
  private ArrayList<Device> devices;
  
  public Room(String roomtype, ArrayList<Device> devices) 
  {
		super();
		Roomtype = roomtype;
		this.devices = devices;
  }
  
  public String getRoomtype() {
	return Roomtype;
}

public void setRoomtype(String roomtype) {
	Roomtype = roomtype;
}

//public ArrayList<Device> getDevices() {
//	return devices;
//}
//
//public void setDevices(ArrayList<Device> devices) {
//	this.devices = devices;
//}
public ArrayList<Device> getDevices() {
    return devices;
}

public void addDevice(Device d) {
	  devices.add(d);
  }
  

//  public void turnOnDevice(String deviceName) {
//	  Device device = findDeviceByName(deviceName);
//      for (Device d: devices) {
//          if (d.getName().equals(deviceName)) {
//              d.turnOn();
//              break;
//          }
//      }
//  }

public void turnOnDevice(String deviceName) {
    Device device = findDeviceByName(deviceName);
    
    if (device != null) {
        device.turnOn();
        System.out.println(device.getName() + " turned on in " + Roomtype);
    } else {
        System.out.println("Device not found in " + Roomtype);
    }
}

  public void turnOffDevice(String deviceName) {
	  Device device = findDeviceByName(deviceName);
      for (Device d : devices) {
          if (d.getName().equals(deviceName)) {
              d.turnOff();
              break;
          }
      }
  }
  
  public void displayRoomStatus() {
      System.out.println("Room: " + Roomtype);
      for (Device device : devices) {
          System.out.println("   " + device.getName() + ": " + device.getStatus() +
                  " - Duration: " + device.timeDuration() + " seconds");
          // Add logic for displaying total time in the current state
      }

  }
 
  private Device findDeviceByName(String deviceName) {
      for (Device device : devices) {
          if (device.getName().equalsIgnoreCase(deviceName)) {
              return device;
          }
      }
      return null; // Device not found
  }
}
