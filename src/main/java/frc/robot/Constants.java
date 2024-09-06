package frc.robot;


//standard ass constants file
//put constants here
public class Constants {

    // Example subsystem uses abstract class for multiple sets of constants
    // May be useful if you have multiple instances of one subsystem (like ultrasonic, or smth)
    public abstract class ExampleSubsystemConstants {
        public String someString;
        public int someData;
        public int moreData;  
        public int startingIncrementorValue; 
    }

    public class ExampleSubsystemConstants1 extends ExampleSubsystemConstants {
        public String someString = "put real config here";
        public int someData = 12;
        public int moreData = 5530;
        public int startingIncrementorValue = 69420;
    }

    // Otherwise just make a class with static variables
    public class StaticConstantsExample {
        public static int some_data;
        public static int more_data;
        public static String namesAreHard = "wow here the string is made of string";
    }
}
