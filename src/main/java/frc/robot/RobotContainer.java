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

  public class Subsystems {

    // example robot subsystem
    static ExampleSubsystem example_subsystem;
  }

  /**
   * Bindings go here,
   * Generated and initialized by bindings.java
   * Also make all variables static
   * Addressed externally (from other java files) with RobotContainer.Bindings.<binding name>
   */

  public class Bindings {

    // example robot command
    static Command increment_the_incrementor;
  }

  /**
   * The state of the robot should be here,
   * I.E 
   * boolean isArmUp
   * boolean isCurrentlyDriving
   * 
   * each subsystem gets it's own subclass
   * 
   * This makes it easier to access, and I don't think we should be using suppliers like we did last year
   * Subsystems should update their respective data here every update cycle
   * Make all variables static for easy access
   * Address externally (from other java files) with RobotContainer.State.<variable>
  */
  public class State {

    // example robot state
    public class ExampleSubsystemState {
      public static boolean is_example_subsystem_initialized;
      public static int the_incrementor;
      public static Instant current_time;
    }
  }

  /**
   * Controller storage class
   */

  public class Controllers {
    static CommandXboxController driver_controller;
  
  }

  static Subsystems subsystems;
  static Bindings bindings;
  static State state;

  public RobotContainer() {

    // Subsystem init goes here, set them statically
    {
      Subsystems.example_subsystem = new ExampleSubsystem();
    }

    // Init bindings
    {
      // controller init
      Controllers.driver_controller = new CommandXboxController(0);
      
      // bindings init
      BindingsInitializer.initializeBindings();

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
