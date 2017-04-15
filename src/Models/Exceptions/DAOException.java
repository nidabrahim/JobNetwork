package Models.Exceptions;



public class DAOException extends Exception{
    public DAOException(String message) {
        super(message);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}
