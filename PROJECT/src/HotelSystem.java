/*
djfjsjgsfjkj
*/
import java.io.*;
import java.util.Scanner;

public class HotelSystem {

    //GLOBAL CONSTANTS
    static final int ACCOUNT_ID_INDEX = 0;
    static final int ACCOUNT_FIRSTNAME_INDEX = 1;
    static final int ACCOUNT_LASTNAME_INDEX = 2;
    static final int ACCOUNT_PIN_INDEX = 3;
    static final int ACCOUNT_ELEMENT_COUNT = 4;
    static final int RES_ROOM = 0;
    static final int RES_DATE = 1;
    static final int RES_FNAME = 2;
    static final int RES_LNAME = 3;
    static final int RES_EMPL_ID = 4;
    static final int RESERVATION_ELEMENT_COUNT = 5;

    public static void main(String[] args){

        //CONSTANTS
        final String ACCOUNT_FILE = "account.txt";
        final String RESERVATION_FILE = "reservation.txt";

        //Variables
        int userID;
        boolean isAdmin = false;
        String [][] roomData, accountData;

        //TESTING (delete later)
        accountData = readAccounts(ACCOUNT_FILE);
        roomData = readRoomInfo(RESERVATION_FILE);

        for(int i = 0; i < accountData.length; i++){
            for(int j = 0; j < accountData[i].length; j++){
                System.out.print(accountData[i][j] + " ");
            }
            System.out.println();
        }
        for(int i = 0; i < roomData.length; i++){
         for(int j = 0; j < roomData[i].length; j++){
                System.out.print(roomData[i][j] + " ");
            }
            System.out.println();
        }
        //END TESTING

    }

    /*
    Programmer: Ryan Mehrian
    Method: readAccounts
    -----
    Parameters:
    String filepath - The filepath of the account file.    
    -----
    Returns:
    String[][] data - 2D array that holds all account info.
    -----
    Description: This method reads in all employee account data from the file, and
    then returns it as a 2D array. Each row of the array is a separate employee, and each
    column contains that employee's info (ID, First Name, Last name, Pin)
     */
    public static String[][] readAccounts(String filepath) {

        //Declarations
        int numOfLines = 0;
        String[][] data;
        BufferedReader file;

        try {

            //COUNT NUM OF LINES
            for(file = new BufferedReader(new FileReader(filepath)); file.readLine() != null; ++numOfLines) {
                //ALL THE COUNTING IS DONE IN THE HEADER, NO BODY REQUIRED!
            }

            //INIT DATA[][] and reset BufferedReader to top of file.
            data = new String[numOfLines][ACCOUNT_ELEMENT_COUNT];
            file.close();
            file = new BufferedReader(new FileReader(filepath));

            //Read File, Fill out Data
            for(int i = 0; i < data.length; ++i) {
                data[i] = file.readLine().split(",");
            }
            file.close();

        }
        catch (IOException e) {
            System.out.println(e + "\nUH OH! YOU CAN'T READ THE ACCOUNT ID FILE!");
            data = null;
        }

        return data;
    }

    /*
    Programmer:Ryan Mehrian
    Method: readRoomInfo
    -----
    Parameters:
    String filepath - The filepath of the reservations file.
    -----
    Returns:
    String[][] data - 2D array that holds all reservation and room info.
    -----
    Description: this method reads in all reservation and room info from the file, and
    then returns it as a 2D array. Each row of the array is a separate reservation, and each column
    is a piece of info about that reservation (Room Number, Check-In Date, Check-Out Date, Guest Name)
    */
    public static String[][] readRoomInfo(String filepath) {

        //Declarations
        int numOfLines = 0;
        String[][] data;
        BufferedReader file;

        try {

            //COUNT NUM OF LINES
            for(file = new BufferedReader(new FileReader(filepath)); file.readLine() != null; ++numOfLines) {
                //ALL THE COUNTING IS DONE IN THE HEADER, NO BODY REQUIRED!
            }

            //INIT DATA[][] and reset BufferedReader to top of file.
            data = new String[numOfLines][RESERVATION_ELEMENT_COUNT];
            file.close();
            file = new BufferedReader(new FileReader(filepath));

            //Read File, Fill out Data
            for(int i = 0; i < data.length; ++i) {
                data[i] = file.readLine().split(",");
            }
            file.close();

        }
        catch (IOException e) {
            System.out.println(e + "\nUH OH! YOU CAN'T READ THE RESERVATIONS FILE!");
            data = null;
        }

        return data;
    }

    /*
    Programmer: Ryan Mehrian
    Method: writeFile
    -----
    Parameters:
    String reservationPath - The filepath of the reservations file.
    String accountPath - The filepath of the account file.
    String[][] reservationData - 2D array that holds all reservation and room info, prepared to be written.
    String[][] accountData - 2D array that holds all account info, prepared to be written.
    -----
    Returns:
    void
    -----
    Description: This method writes all data back to the files.
    */
    public static void writeFile(String reservationPath, String accountPath, String[][] reservationData, String[][] accountData) {
        //Declarations
        BufferedWriter file;

        //Logging out Message
        System.out.println("SAVING DATA...");

        //Write Reservations
        try {
            file = new BufferedWriter(new FileWriter(reservationPath));

            for(int i = 0; i < reservationData.length; i++){
                for(int j = 0; j < RESERVATION_ELEMENT_COUNT; j++){
                    file.write(reservationData[i][j] + ',');
                }
                file.write("\n");
            }
            file.close();
        }
        catch(IOException e){
            System.out.println(e);
        }

        //Write Account Data
        try {
            file = new BufferedWriter(new FileWriter(reservationPath));

            for(int i = 0; i < reservationData.length; i++){
                for(int j = 0; j < RESERVATION_ELEMENT_COUNT; j++){
                    file.write(reservationData[i][j] + ',');
                }
                file.write("\n");
            }
            file.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
        //Write Reservations
        try {
            file = new BufferedWriter(new FileWriter(accountPath));

            for(int i = 0; i < accountData.length; i++){
                for(int j = 0; j < ACCOUNT_ELEMENT_COUNT; j++){
                    file.write(accountData[i][j] + ',');
                }
                file.write("\n");
            }
            file.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
        /*
    Mansour Abdelsalam
    Method: searchByName
    -----
    Parameters:
    String[][] roomData - 2d array containing room information
    -----
    Returns:
    void
    -----
    Description: Asks user for a first name and last name and then prints out each reservation made under that client name, with room number and date information.
    */
    public static void searchByName(String[][] roomData){
        Scanner scan = new Scanner(System.in);

        String first_name = "";
        String last_name = "";

        System.out.println("Enter the client's information.");
        System.out.print("First name: ");
        first_name = scan.nextLine();
        System.out.print("Last name: ");
        last_name = scan.nextLine();

        for (int i = 0; i<roomData.length; i++){
            if(((roomData[i][ACCOUNT_FIRSTNAME_INDEX].toLowerCase()).equals(first_name.toLowerCase())) && ((roomData[i][RES_LNAME].toLowerCase()).equals(last_name.toLowerCase()))){
              System.out.println("Room #: "+roomData[i][RES_ROOM]);
              System.out.println("Date reserved: "+roomData[i][RES_DATE]);
              System.out.println(); //blank line
            }
        }
    }

    /*
    Mansour Abdelsalam
    Method: searchAvailableByDate
    -----
    Parameters:
    String[][] roomData - 2d array containing room information
    -----
    Returns:
    void
    -----
    Description: Asks user for a date in MM/DD/YYYY format (will ask user to reenter if invalid format given) and then print out each available room on that day.
    Will check if inputted date is between 1 to 31, and month is between 1 to 12.
    */
    public static void searchAvailableByDate(String[][] roomData){
        Scanner scan = new Scanner(System.in);

        boolean valid_date = false;
        boolean room_found = false;
        int month = 0;
        int day = 0;
        int year = 0;
        String date = "";

        System.out.println("Enter the date to check.");
        do{
            System.out.print("Month: ");
            month = scan.nextInt();
            System.out.print("Day: ");
            day = scan.nextInt();
            System.out.print("Year: ");
            year = scan.nextInt();

            if (((month <= 12) && (month >= 1)) && ((day <= 31) && (day >= 1))){
                date += ""+month+"/"+day+"/"+year;
                valid_date = true;
            } else {
                System.out.println("Invalid date entered.");
                System.out.println(); //blank line
                System.out.println("Reenter date:");
            }
        } while(!valid_date);

        if(valid_date){
            System.out.println(); //blank line
            System.out.println("Available rooms on "+date+":");

            for(int i = 0; i<roomData.length; i++){
                if(!roomData[i][RES_DATE].equals(date)){
                    room_found = true;
                    System.out.println("Room #: "+roomData[i][RES_ROOM]);
                }
            }
            if(!room_found){
                System.out.println("No rooms available on this date.");
                System.out.println(); //blank line
            }
        }
    }

    /*
    Mansour Abdelsalam
    Method: searchReservationByDate
    -----
    Parameters:
    String[][] roomData - 2d array containing room information
    -----
    Returns:
    void
    -----
    Description: Asks user for a date in MM/DD/YYYY format (will ask user to reenter if invalid format given) and then print out each reservation on that day, with room number and client information.
    */
    public static void searchReservationByDate(String[][] roomData){
        Scanner scan = new Scanner(System.in);

        boolean valid_date = false;
        boolean room_found = false;
        int month = 0;
        int day = 0;
        int year = 0;
        String date = "";

        System.out.println("Enter the date to check.");
        do{
            System.out.print("Month: ");
            month = scan.nextInt();
            System.out.print("Day: ");
            day = scan.nextInt();
            System.out.print("Year: ");
            year = scan.nextInt();

            if (((month <= 12) && (month >= 1)) && ((day <= 31) && (day >= 1))){
                date += ""+month+"/"+day+"/"+year;
                valid_date = true;
            } else {
                System.out.println("Invalid date entered.");
                System.out.println(); //blank line
                System.out.println("Reenter date:");
            }
        } while(!valid_date);

        if(valid_date){
            System.out.println(); //blank line
            System.out.println("Rooms reserved on "+date+":");

            for(int i = 0; i<roomData.length; i++){
                if(roomData[i][RES_DATE].equals(date)){
                    room_found = true;
                    System.out.println("Room #: "+roomData[i][RES_ROOM]);
                    System.out.println("Customer name: "+roomData[i][RES_FNAME]+" "+roomData[i][RES_LNAME]);
                    System.out.println(); //blank line
                }
            }
            if(!room_found){
                System.out.println("No rooms are reserved on this date.");
                System.out.println(); //blank line
            }
        }
    }
}


