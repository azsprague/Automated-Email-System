package email;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * System executable. Contains the main() method.
 * 
 * @author Aidan Sprague
 * @version 2020.12.20
 */
public class Runner {
    
    private static Scanner inScanner;
    
    /**
     * Main method to run the program.
     * @param args  Command line arguments; in this program, either 0 or 1 arguments
     *              are acceptable.
     */
    public static void main(String[] args) {
        inScanner = new Scanner(System.in);
        if (args.length == 0) {
            System.out.println("No input file detected; Starting manual mode.\n");
            manualMode();
        }
        else if (args.length == 1) {
            System.out.println("Input file <" + args[0] + "> detected; Starting file mode.");
            fileMode(args[0]);
        }
        else {
            System.err.println("Invocation: Email [scriptfile]");
        }
        inScanner.close();
    }
    
    /**
     * Collects user input from the command line to send a message.
     */
    private static void manualMode() {
        System.out.print("Enter Message Header:\n> ");
        String header = inScanner.nextLine();
        
        System.out.print("Enter Message Body:\n> ");
        String body = inScanner.nextLine();
        
        System.out.print("Enter Your Email:\n> ");
        String from = inScanner.nextLine();
        
        System.out.print("Enter Your Email Password:\n> ");
        char[] temp = System.console().readPassword();
        String pass = new String(temp);
        
        System.out.print("Enter Recipients (Separated by Spaces):\n> ");
        String temp2 = inScanner.nextLine();
        String[] recipients = temp2.split("\\s+");
            
        System.out.print("Enter Time for Reminder (24h Time, format HH:MM:SS):\n> ");
        String time = inScanner.nextLine();
        
        Data data = new Data(header, body, from, pass, recipients, time);
        Sender.send(data);
    }
    
    /**
     * Parses a given file containing the necessary fields, then sends the
     * message when desired.
     */
    private static void fileMode(String file) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(new File(file)));
            
            String header = reader.readLine();
            String body = reader.readLine();
            String email = reader.readLine();
            String pass = reader.readLine();
            String temp = reader.readLine();
            String[] recipients = temp.split("\\s+");
            String time = reader.readLine();
            
            Data data = new Data(header, body, email, pass, recipients, time);
            Sender.send(data);
        }
        catch (IOException e) {e.printStackTrace();}
    }
}
