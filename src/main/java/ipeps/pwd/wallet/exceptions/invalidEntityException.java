package ipeps.pwd.wallet.exceptions;

import lombok.Getter;

import java.util.List;

public class invalidEntityException extends RuntimeException{
    @Getter
    private erreursCodes erreursCodes;
    @Getter
    private List<String>errors;

    public invalidEntityException(erreursCodes erreursCodes) {
        this.erreursCodes = erreursCodes;
    }

    public invalidEntityException(String message, erreursCodes erreursCodes) {
        super(message);
        this.erreursCodes = erreursCodes;
    }

    public invalidEntityException(String message, Throwable cause, erreursCodes erreursCodes) {
        super(message, cause);
        this.erreursCodes = erreursCodes;
    }

    public invalidEntityException(Throwable cause, erreursCodes erreursCodes) {
        super(cause);
        this.erreursCodes = erreursCodes;
    }

    public invalidEntityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, erreursCodes erreursCodes) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.erreursCodes = erreursCodes;
    }

    public invalidEntityException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
        this.erreursCodes = erreursCodes;
    }

    public invalidEntityException(String message, erreursCodes employeeNotValid, List<String> errors) {
    }
}
