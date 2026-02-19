package csci2010.morganprogram4;

/**
 *CSCI 2010 Programming Assignment 4
 * @author Jon-Michael Morgan
 * This class contains attributes for the players
 */
public class Player {
    private String name;
    private int age;
    private int rank;
    private String country;
    
    //constructor
    public Player(String name, int age, int rank, String country)
    {
        this.name = name;
        this.age = age;
        this.rank = rank;
        this.country = country;
    }
    
    //mutators
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public void setRank(int rank)
    {
        this.rank = rank;
    }
    public void setCountry(String country)
    {
        this.country = country;
    }
    
    //accessors
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public int getRank()
    {
        return rank;
    }
    public String getCountry()
    {
        return country;
    }
    
    //returns a string containing player information
    public String toString()
    {
        return "Name: " + name + "\nAge: " + age + 
                "\nRank: " + rank + "\nCountry: " + country;
    }
}
