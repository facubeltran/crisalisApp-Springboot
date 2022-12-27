package group.crisalis.exception.custom;

public class NotFoundException extends RuntimeException {
    private static final String DESCRIPTION = "Not Found (404)";

    public NotFoundException(String detail){
        super(DESCRIPTION + ". "+detail);
    }
}
