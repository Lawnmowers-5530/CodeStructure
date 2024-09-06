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
The code this year makes heavy use of static variables accessible with a global context, this has downsides with not being super clear about what subsystem touches what, but has upsides where you don't have to pass everything to your subsystems, and it marginally increases Nick's sanity
Please remember to initialize all your variables to a default value, null pointers will bite your ass.
Try not to have static variables that can change stuff in real life i.e
```java
public class DriveTrain extends SubsystemBase {
    static Motor motor1 = new Motor(); // <-- when this happens is very unclear and may have lead to the black hole of death (crashing) after subsystem init
                        // We got destroyed by this when our swerve subsystem killed everything after it and crashed.
                        // Please just do init in class init.
    Motor motor2;
    
    public DriveTrain() {
        motor2 = new Motor(); // <-- do it here, like a normal programmer
    }
}
```
