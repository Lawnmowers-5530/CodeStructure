package frc.robot.subsystems;

import java.time.Instant;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ExampleSubsystemConstants;
import frc.robot.RobotContainer.State.ExampleSubsystemState;

public class ExampleSubsystem extends SubsystemBase{

    ExampleSubsystemConstants constants;
    ExampleSubsystemState state;

    // Try not to have static variables here, they should either be in constants or in the state class
    int someData;

    public ExampleSubsystem(ExampleSubsystemConstants constants, ExampleSubsystemState state) {
        //set non static variables
        this.someData = 420;


        //you should set up some kind of default state for your robot state variables (if any) to make sure that they aren't null
        state.is_example_subsystem_initialized = true;
        state.the_incrementor = constants.startingIncrementorValue;
        state.current_time = Instant.now();
    }

    public void periodic() {
        //update some data
        state.current_time = Instant.now();
    }

    /**
     * command functions should be placed here
     */

    public void increment_the_incrementor() {
        state.the_incrementor++;
    }
    
}
