package csci2010.morganprogram4;

/**
 *CSCI 2010 Programming Assignment 4
 * @author Jon-Michael Morgan
 * This exception runs when a player is not found
 */
public class NoSuchPlayerException extends Exception{
    public NoSuchPlayerException()
    {
        super("Player does not exist.");
    }
    public NoSuchPlayerException(String message)
    {
        super(message);
    }
}
