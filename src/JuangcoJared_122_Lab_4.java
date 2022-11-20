import java.lang.Exception;
import java.util.Scanner;

class InvalidHrExcep extends Exception {
    private String message;

    public InvalidHrExcep() {
        super();
    }

    public InvalidHrExcep(String str) {
        this.message = str;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return getMessage();
    }
}

class InvalidMinExcep extends Exception {
    private String message;

    public InvalidMinExcep() {
        super();
    }

    public InvalidMinExcep(String str) {
        this.message = str;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return getMessage();
    }
}

class InvalidSecExcep extends Exception {
    private String message;

    public InvalidSecExcep() {
        super();
    }

    public InvalidSecExcep(String str) {
        this.message = str;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return getMessage();
    }
}

public class JuangcoJared_122_Lab_4 {
    private static Scanner console = new Scanner(System.in);

    public static int getHours() {
        System.out.print("Enter hours: ");
        int hr = console.nextInt();
        return hr;
    }

    public static int getMinutes() {
        System.out.print("Enter minutes: ");
        int min = console.nextInt();
        return min;

    }

    public static int getSeconds() {
        System.out.print("Enter seconds: ");
        int sec = console.nextInt();
        return sec;

    }

    public static void print24HourTime(int hr, int min, int sec, String str) {
        String hrString = "";
        String minString = "";
        String secString = "";

        if (str.toUpperCase().equals("AM")) {
            if (hr == 12) {
                hr = 0;
            }
            hrString = (hr < 10) ? String.format("0%d", hr) : String.format("%d", hr);
        } else if (str.toUpperCase().equals("PM")) {
            hrString = String.format("%d", hr + 12);
        }

        minString = (min <= 9) ? String.format("0%d", min) : String.format("%d", min);
        secString = (sec <= 9) ? String.format("0%d", sec) : String.format("%d", sec);

        String convertedTimeFormat = String.format("%s:%s:%s", hrString, minString, secString);
        System.out.print("\n\n");
        System.out.println("Time converted in 24 hour format: " + convertedTimeFormat);
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        int hr = 0;
        int min = 0;
        int sec = 0;
        String amPMChoice = "";
        boolean notOK;
        do {
            try {
                hr = getHours();
                if (hr <= 0 || hr > 12) {
                    throw new InvalidHrExcep("The value of hours must be between 0 and 12");
                } else {
                    notOK = false;
                }
            } catch (InvalidHrExcep e) {
                e.printStackTrace();
                notOK = true;
            }

        } while (notOK == true);

        do {
            try {
                min = getMinutes();
                if (min < 0 || min > 59) {
                    throw new InvalidMinExcep("The value of minutes must be between 0 and 60");
                } else {
                    notOK = false;
                }
            } catch (InvalidMinExcep e) {
                e.printStackTrace();
                notOK = true;
            }
        } while (notOK == true);

        do {
            try {
                sec = getSeconds();
                if (sec < 0 || sec > 59) {
                    throw new InvalidSecExcep("The value of minutes must be between 0 and 60");
                } else {
                    notOK = false;
                }
            } catch (InvalidSecExcep e) {
                e.printStackTrace();
                notOK = true;
            }
        } while (notOK == true);

        System.out.print("Enter AM or PM: ");
        amPMChoice = console.next();

        print24HourTime(hr, min, sec, amPMChoice);

    }
}
