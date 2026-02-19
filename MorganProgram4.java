package csci2010.morganprogram4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *CSCI 2010 Programming Assignment 4
 * @author Jon-Michael Morgan
 * This program will open a CSV file containing tennis player information and allow
 * the user to search by name or country and display oldest and youngest players
 */
public class MorganProgram4 {

    public static void main(String[] args) throws FileNotFoundException, NoSuchPlayerException{
        Scanner keyboard = new Scanner(System.in);
        String fileName = "womenSinglesDraw.txt";
        Player[] players = new Player[128];
        loadPlayers(fileName, players);
        System.out.println("Loading players from file");
        while (true)
        {
            System.out.println("");
            displayMenu();
            System.out.println("Enter choice: ");
            int choice = keyboard.nextInt();
            keyboard.nextLine();
            switch (choice)
            {
                case 1:
                    System.out.println("Please enter the player's name: ");
                    String name = keyboard.nextLine();
                    System.out.println("");
                    try
                    {
                        System.out.println(findPlayerByName(players, name));
                    }
                    catch (NoSuchPlayerException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Please enter the country: ");
                    String country = keyboard.nextLine();
                    System.out.println("");
                    try
                    {
                        Player[] countryPlayers = findPlayersByCountry(players, country);
                        for (int i = 0; i < countryPlayers.length; i++)
                        {
                            System.out.println(countryPlayers[i].getName());
                        }
                    }
                    catch (NoSuchPlayerException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("");
                    try
                    {
                        System.out.println(findYoungestPlayer(players));
                    }
                    catch (NoSuchPlayerException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("");
                    try
                    {
                        System.out.println(findOldestPlayer(players));
                    }
                    catch (NoSuchPlayerException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("");
                    System.out.println("Program exiting.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("");
                    System.out.println("Invalid Choice");
                    break;
            }
        }
        
    }
    
    //stores a new player object in the array for each line of the file
    public static void loadPlayers(String fileName, Player[] players) throws FileNotFoundException
    {
        Scanner inputStream = new Scanner(new File(fileName));        
        int i = 0;
        while (inputStream.hasNextLine())
        {            
            String line = inputStream.nextLine();
            String[] data = line.split(",");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            int rank = Integer.parseInt(data[2]);
            String country = data[3];
            players[i] = new Player(name, age, rank, country);
            i++;
        }
        inputStream.close();
    }
    
    //displays a menu with options for the user to choose from
    public static void displayMenu()
    {
        System.out.println("Choose one of the following options:");
        System.out.println("1. Find a player by name");
        System.out.println("2. Find all players by country");
        System.out.println("3. Find the youngest player");
        System.out.println("4. Find the oldest player");
        System.out.println("5. Exit");
    }
    
    //takes an array of Player and a String for name and returns the first player 
    //with that name
    public static String findPlayerByName(Player[] players, String name) throws NoSuchPlayerException
    {
        for (int i = 0; i < players.length; i++)
        {
            if(name.equalsIgnoreCase(players[i].getName()))
                return players[i].toString();
        }
        throw new NoSuchPlayerException("There is no player named " + name);
    }
    
    //finds all players within list from the same country
    public static Player[] findPlayersByCountry(Player[] players, String country)
                                                throws NoSuchPlayerException
    {
        int count = 0;
        Player [] totalPlayers;
        //counts total amount of players from country
        for (int i = 0; i < players.length; i++)
        {
            if (players[i].getCountry().equalsIgnoreCase(country))
            {
                count++;
            }
        }
        //if no players from entered country
        if (count == 0)
            throw new NoSuchPlayerException("There are no players from " + country);
        //assigns players to new array
        int index = 0;
        totalPlayers = new Player[count];
        for (int i = 0; i < players.length; i++)
        {
            if (players[i].getCountry().equalsIgnoreCase(country))
            {
                totalPlayers[index++] = players[i];
            }
        }
        return totalPlayers;
    }
    
    //returns youngest player
    public static String findYoungestPlayer(Player[] players) throws NoSuchPlayerException
    {
        Player youngest = players[0];
        for (int i = 1; i < players.length; i++)
        {
            if (players[i].getAge() < youngest.getAge())
            {
                youngest = players[i];
            }
        }
        if (players == null)
            throw new NoSuchPlayerException("No players");
        return youngest.toString();
    }
    
    //returns oldest player
    public static String findOldestPlayer(Player[] players) throws NoSuchPlayerException
    {
        Player oldest = players[0];
        for (int i = 1; i < players.length; i++)
        {
            if (players[i].getAge() > oldest.getAge())
            {
                oldest = players[i];
            }
        }
        if (oldest == null)
            throw new NoSuchPlayerException("No players");
        return oldest.toString();
    }
}
