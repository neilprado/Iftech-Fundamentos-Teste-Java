package iftech.br.edu.ifpb.pistoSongs.exceptions;

public class IsNegativedException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IsNegativedException(String message) {
        super(message);
    }

    public IsNegativedException(String message, Throwable cause) {
        super(message, cause);
    }
}
