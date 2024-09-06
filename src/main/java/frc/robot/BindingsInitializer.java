package frc.robot;

import frc.robot.RobotContainer.Bindings;
import frc.robot.RobotContainer.Subsystems;

public class BindingsInitializer {
    static RobotContainer.Bindings initializeBindings(RobotContainer.Subsystems subsystems, RobotContainer.Bindings bindings) {
        // do binding init
        Bindings.increment_the_incrementor = Subsystems.example_subsystem.runOnce(Subsystems.example_subsystem::increment_the_incrementor);
        // end binding init

        // DO NOT LEAVE ANYTHING NULL
        return bindings;
    }
}
