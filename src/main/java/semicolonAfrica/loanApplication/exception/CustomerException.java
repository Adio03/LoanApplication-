package semicolonAfrica.loanApplication.exception;

public class CustomerException extends Throwable{
    public CustomerException(String message){
        super(message);
    }
    public CustomerException(Throwable throwable){
        super(throwable);
    }


}
