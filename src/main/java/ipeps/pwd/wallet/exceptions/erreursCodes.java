package ipeps.pwd.wallet.exceptions;

public enum erreursCodes {
    EMPLOYEE_NOT_FOUND(4000),
    EMPLOYEE_NOT_VALID(4001),
    SALARY_NOT_FOUND(5000),
    SALARY_NOT_VALID(5001);
    private int code;

    erreursCodes(int code) {
        this.code = code;
    }
    public  int getCode(){
        return code;
    }
}
