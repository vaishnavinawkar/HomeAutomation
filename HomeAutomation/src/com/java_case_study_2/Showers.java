package com.java_case_study_2;

import java.time.Duration;

public class Showers implements Device {
	private boolean status;
    private long startTime;
    private long endTime;

    public Showers() {
        this.status = false;
        this.startTime = 0;
        this.endTime = 0;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
    
    @Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Showers";
	}

    @Override
    public void turnOn() {
        if (!status) {
            status = true;
            startTime = System.currentTimeMillis();
            System.out.println("Shower is turned On!!");
        }
    }

    @Override
    public void turnOff() {
        if (status) {
            status = false;
            endTime = System.currentTimeMillis();
            System.out.println("Shower is Turned Off!!");
        }
    }

    @Override
    public Duration timeDuration() {
    	if(startTime != 0 && endTime == 0) {
    		return Duration.ofMillis(System.currentTimeMillis()- startTime);
    	}
    	else if (startTime != 0 && endTime != 0) {
            return Duration.ofMillis(endTime - startTime);
        } else {
            System.out.println("Shower is not turned on or turned off yet.");
            return null;
        }
    }
	
}
