package com.java_case_study_2;

import java.time.Duration;


public interface Device {
  void turnOn();
  void turnOff();
  boolean getStatus();
  Duration timeDuration();
  String getName();
}
