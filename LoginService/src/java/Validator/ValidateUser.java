
package Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nichlas
 */
public class ValidateUser {

    private Pattern patternUsername;
    private Pattern patternPassword;
    private Pattern patternEmail;
    private Matcher matcher;
    
  /*  			#   Start of group
  (?=.*\d)		#   must contains one digit from 0-9
  (?=.*[a-z])		#   must contains one lowercase characters
  (?=.*[A-Z])		#   must contains one uppercase characters
  .                     #   match anything with previous condition checking
  {6,20}                #   length at least 6 characters and maximum of 20	
			#   End of group*/
   
    private static final String USERNAME_PATTERN = "^[a-z0-9A-Z]{6,12}$";
    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,30})";
    private static final String EMAIL_PATTERN =  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public ValidateUser() {
        patternUsername = Pattern.compile(USERNAME_PATTERN);
        patternPassword = Pattern.compile(PASSWORD_PATTERN);
        patternEmail = Pattern.compile(EMAIL_PATTERN);
        
    }

    public boolean validateUsername(final String username) {
        matcher = patternUsername.matcher(username);
        return matcher.matches();
    }
    public boolean validatePassword(final String password) {
        matcher = patternPassword.matcher(password);
        return matcher.matches();
    }
    public boolean validateEmail(final String email) {
        matcher = patternEmail.matcher(email);
        return matcher.matches();
    }
}
