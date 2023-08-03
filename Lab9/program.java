import java.util.Scanner;
public class program {
    public class InvalidTimeException extends Exception{
        InvalidTimeException() {}
        InvalidTimeException(String message){
            super(message);
        }
    }
    public int ConvertTimeToSeconds(String timeString) throws InvalidTimeException {
        String[] parts = timeString.split(":",3);
        if (timeString.length() != 8){
            throw new InvalidTimeException("Invalid Time has been provided. ");
        }
        int hours,minutes,seconds;
        try {
            hours = Integer.parseInt(parts[0]);
            minutes = Integer.parseInt(parts[1]);
            seconds = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new InvalidTimeException("Invalid time format has been entered, please enter numerical values. ");
        }

        if (hours < 0 || hours > 23) {
            throw new InvalidTimeException("Hours must be between 0 and 23: " + hours);
        }

        if (minutes < 0 || minutes > 59) {
            throw new InvalidTimeException("Minutes must be between 0 and 59: " + minutes);
        }

        if (seconds < 0 || seconds > 59) {
            throw new InvalidTimeException("Seconds must be between 0 and 59: " + seconds);
        }
        return (hours * 60 * 60) + (minutes * 60) + seconds;
    }
}
