// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.time.Instant;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ExampleSubsystem;

public class RobotContainer {
  // Utility classes
  // Static for Nick's happiness, (and probably sanity)

  /**
   * Subsystems declared here,
   * Should be static,
   * Addressed externally (from other java files) with RobotContainer.Subsystems.<subsystem name>
   */

  class Subsystems {

    // example robot subsystem
    static ExampleSubsystem example_subsystem;
  }

  /**
   * Bindings go here,
   * Generated and initialized by bindings.java
   * Should not be accessed by any other subsystem
   * Also make all variables static
   * Addressed externally (from other java files) with RobotContainer.Bindings.<binding name>
   */

  class Bindings {

    // example robot command
    static Command increment_the_incrementor;
  }

  /**
   * The state of the robot should be here,
   * I.E 
   * boolean isArmUp
   * boolean isCurrentlyDriving
   * 
   * access in a static way from every subsystem
   * each subsystem gets it's own subclass
   * 
   * This makes it easier to access, and I don't think we should be using suppliers like we did last year
   * Subsystems should update their respective data here every update cycle
   * Make all variables static for easy access
   * Address externally (from other java files) with RobotContainer.State.<variable>
  */
  public class State {

    // example robot state
    public static abstract class ExampleSubsystemState {
      public boolean is_example_subsystem_initialized;
      public int the_incrementor;
      public Instant current_time;
    }
    // also an example of ovveridable static variables for a subsystem
    public static class ExampleSubsystemState1 extends ExampleSubsystemState{
      public static boolean is_example_subsystem_initialized;
      public static int the_incrementor;
      public static Instant current_time;
    }
  }

  /**
   * Controller storage class
   */

  class Controllers {
    static CommandXboxController driver_controller;
  }

  static Subsystems subsystems;
  static Bindings bindings;
  static State state;
  static Constants constants;

  public RobotContainer() {
    
    {
      subsystems = new Subsystems();
      bindings = new Bindings();
      state = new State();
      constants = new Constants();
    }

    // Subsystem init goes here, set them statically
    {
      // Duplicatable subsystems should be initialized with a constructor that takes a Constants class and a State class
      Subsystems.example_subsystem = new ExampleSubsystem(new Constants.ExampleSubsystemConstants1(), new State.ExampleSubsystemState1());
    }

    // Controller init
    {
      Controllers.driver_controller = new CommandXboxController(0);
    }

    // Bindings init 
    { 
      // bindings init
      bindings = BindingsInitializer.initializeBindings(RobotContainer.subsystems, RobotContainer.bindings);

      // actually bind the bindings
      Controllers.driver_controller.a().onTrue(Bindings.increment_the_incrementor);

    }
  }

  // screw configureBindings we don't need it where we're going
  // private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
