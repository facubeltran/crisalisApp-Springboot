package group.crisalis.exception.custom;

public class UnauthorizedException extends RuntimeException{
    private static final String DESCRIPTION = "credentianls invalid (401)";

    public UnauthorizedException(String detail){
        super(DESCRIPTION + ". "+detail);
    }

}
