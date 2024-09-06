# Basic code structure refrence for the Greenhills Lawnmowers (5530)

# Programmers Please Read!

## Style Guide

### Naming Conventions
- Class / File names: ```PascalCase```
- Variable names: ```camelCase```
    - Static variables, Class variables, Normal variables, etc.
    - Be aware this also applies to constants, we decided to do this because vscode makes it obvious with color highlighting that constants are constants anyway
- Function names: ```camelCase```

### Code structure

#### Subsystem creation and init
The code this year makes heavy use of static variables accessible with a global context, this has downsides with not being super clear about what subsystem touches what, but has upsides where you don't have to pass everything to your subsystems, and it marginally increases Nick's sanity
Please remember to initialize all your variables to a default value, null pointers will bite your ass.
Try not to have static variables that can change stuff in real life i.e
```java
public class DriveTrain extends SubsystemBase {
    static Motor motor1 = new Motor(); // <-- when this happens is very unclear and may have lead to the black hole of death (crashing) after subsystem init
                        // We got destroyed by this when our swerve subsystem killed everything after it and crashed.
                        // Please just do init in class init.
    Motor motor2 = new Motor(); // This also has the same problem of when the hell does it run
    Motor motor3;

    public DriveTrain() {
        motor3 = new Motor(); // <-- do it here, like a normal programmer
    }
}
```

#### Multiple sets of constants / sets of state
See the [Constants](src/main/java/frc/robot/Constants.java) file for how to have multiple sets of constants, and the [RobotContainer](src/main/java/frc/robot/RobotContainer.java) and [ExampleSubsystem](src/main/java/frc/robot/subsystems/ExampleSubsystem.java) file for how to specify and use multiple sets of constants or state
If you only have one set of constants or state, it's probably better to just use a subclass with static variables in their respective classes

#### Dependency injection
Very very fancy term, a lot of people think it's some incredibly hard programming pattern, but, it's literally just passing the data you use into whatever is using it
Like in the [ExampleSubsystem](src/main/java/frc/robot/subsystems/ExampleSubsystem.java) file
```java
public class ExampleSubsystem {
    //                      Literally dependency injection                                          
    public ExampleSubsystem(ExampleSubsystemConstants constants, ExampleSubsystemState state) {
        // ...
    }
    // ...
}
```
It just helps make it clearer for other people what your code touches and doesn't touch
In special cases like constants it makes it simpler to not do this, but otherwise, do it as much as possible
Static variables are nice, but it is harder to tell what does what where

#### Curly braces
You may notice several sets of seemingly useless curly braces
Like in [RobotContainer](src/main/java/frc/robot/RobotContainer.java)
```java
    // Init static variables
    {                                   // <-- Here
      subsystems = new Subsystems();
      bindings = new Bindings();
      state = new State();
      constants = new Constants();
    }

    // Subsystem init goes here, set them statically
    {                                   // <-- And here
      // Duplicatable subsystems should be initialized with a constructor that takes a Constants class and a State class
      Subsystems.example_subsystem = new ExampleSubsystem(new Constants.ExampleSubsystemConstants1(), new State.ExampleSubsystemState1());
    }
    // ...
```
These, functionally, are kinda pointless, but they do provide some nice grouping of code.
Notice how there are comments showing what the block of code together does, it just helps with understanding, and splitting up functions that could get VERY long into more digestable blocks of what does what
You do not have to do this, but it's nice

#### Command binding
Do all the command binding and creation inside the [BindingsInitializer](src/main/java/frc/robot/BindingsInitializer.java) java file. Last year it was also in a seperate file, because it gets very long, we just renamed it from CommandCombinator to something that makes more sense.

## Git structure
Our git structure is branch based, with one branch for each feature. If you don't know how to use git, just ask

### Merging branches into main
If you think a feature is competition ready and have tested it, ask another person to review we want at least 2 people to understand and be able to work with the feature in case it breaks
Create a pull request on github and ask somebody to review it
After review has gone through, you can merge.