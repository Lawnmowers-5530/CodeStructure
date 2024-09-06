package frc.robot;


//standard ass constants file
//put constants here
public class Constants {

    // Example subsystem uses abstract class for multiple sets of constants
    // May be useful if you have multiple instances of one subsystem (like ultrasonic, or smth)
    public static abstract class ExampleSubsystemConstants {
        public String someString;
        public int someData;
        public int moreData;  
        public int startingIncrementorValue; 
    }

    public static class ExampleSubsystemConstants1 extends ExampleSubsystemConstants {
        public static String someString = "put real config here";
        public static int someData = 12;
        public static int moreData = 5530;
        public static int startingIncrementorValue = 69420;
    }

    // Otherwise just make a class with static variables
    public class StaticConstantsExample {
        public static int some_data;
        public static int more_data;
        public static String namesAreHard = "wow here the string is made of string";
    }
}
