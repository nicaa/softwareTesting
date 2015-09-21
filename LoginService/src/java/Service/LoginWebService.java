/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Database.DBConnect;
import MailSender.MailSender;
import PasswordGen.RandomPasswordGen;
import Validator.ValidateUser;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Nichlas
 */
@WebService(serviceName = "LoginWebService")
public class LoginWebService {
    DBConnect dBConnect = new DBConnect();
    ValidateUser validateUser = new ValidateUser();
    MailSender mailSender = new MailSender();
    RandomPasswordGen passwordGen = new RandomPasswordGen();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "Login")
    public boolean Login(String username, String password){

        return dBConnect.login(username, password);
    }
    
    @WebMethod(operationName = "PasswordGen")
    public String PasswordGen(){
        String password = String.valueOf(passwordGen.generatePswd(8,8,1,4,0));
        return password;
    }
    
    @WebMethod(operationName = "Registrate")
    public boolean Registrate(String username,String email, String password){

        return dBConnect.registration(username, email ,password);
    }
    
    @WebMethod(operationName = "ValUsername")
    public boolean ValidateUsername(String username){

        return validateUser.validateUsername(username);
    }
    
    @WebMethod(operationName = "ValPassword")
    public boolean ValidatePassword(String password){

        return validateUser.validatePassword(password);
    }
    
    @WebMethod(operationName = "ValEmail")
    public boolean ValidateEmail(String email){

        return validateUser.validateEmail(email);
    }
    
    @WebMethod(operationName = "SendPassword")
    public void SendPassword(String email, String newPassword){

         mailSender.forgotPasswordMail(email, newPassword);
    }
    
    @WebMethod(operationName = "WelcomeMail")
    public void WelcomeMail(String email){

         mailSender.welcomeMail(email);
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "CheckEmailExist")
    public Boolean CheckEmailExist(String email) {
    
        return dBConnect.chechIfEmailExist(email);
    }
    
    @WebMethod(operationName = "ChangePassword")
    public Boolean ChangePassword(String email, String newPassword) {
    
        return dBConnect.changePassword(email, newPassword);
    }
}
