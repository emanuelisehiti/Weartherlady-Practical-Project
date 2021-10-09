package validation;

public class UserValidation {
    public boolean isValidate(String userInput){
        if (userInput.matches("[a-zA-Z]+")){
            return true;
        }
        return false;
    }
}
