package frc.robot.subsystems;

import java.time.Instant;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ExampleSubsystemConstants;
import frc.robot.RobotContainer.State.ExampleSubsystemState;

public class ExampleSubsystem extends SubsystemBase{

    int some_data;
    static int some_other_data = 420;

    public ExampleSubsystem(ExampleSubsystemConstants constants) {
        //set non static variables
        this.some_data = 420;


        //you should set up some kind of default state for your robot state variables (if any) to make sure that they aren't null
        ExampleSubsystemState.is_example_subsystem_initialized = true;
        ExampleSubsystemState.the_incrementor = constants.starting_incrementor_value;
        ExampleSubsystemState.current_time = Instant.now();
    }

    public void periodic() {
        //update some data
        ExampleSubsystemState.current_time = Instant.now();
    }

    /**
     * command functions should be placed here
     */

    public void increment_the_incrementor() {
        ExampleSubsystemState.the_incrementor++;
    }
    
}
