package ipeps.pwd.wallet.exceptions;

import lombok.Getter;

public class entityNotFoundException extends RuntimeException{
    @Getter
    private  erreursCodes erreursCodes;


    public entityNotFoundException(String message, erreursCodes erreursCodes) {
        super(message);
        this.erreursCodes = erreursCodes;
    }

    public entityNotFoundException(String message, Throwable cause, erreursCodes erreursCodes) {
        super(message, cause);
        this.erreursCodes = erreursCodes;
    }

    public entityNotFoundException(Throwable cause, erreursCodes erreursCodes) {
        super(cause);
        this.erreursCodes = erreursCodes;
    }

    public entityNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace, erreursCodes erreursCodes) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.erreursCodes = erreursCodes;
    }
}
