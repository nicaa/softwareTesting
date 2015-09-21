/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import MailSender.MailSender;
import PasswordGen.RandomPasswordGen;
import Validator.ValidateUser;

/**
 *
 * @author Nichlas
 */
public class MainTest {
    public static void main(String[] args) {

        DBConnect connect = new DBConnect();
        MailSender mailSender = new MailSender();
        RandomPasswordGen passwordGen = new RandomPasswordGen();
        //mailSender.sendMail("nica1408@gmail.com");
        //Registration Complete with hash and salt!
       // System.out.println(connect.registration("niica1234" ,"Nica1408@Gmail.com", "Testsdada1"));
        //user exist test complete!
        //System.out.println(connect.chechIfUserExist("tesu1"));
        //Login Complete!
        //System.out.println(connect.login("Imran", "123hej"));
        //System.out.println(connect.registration("123" ,"Email@email.com" , "123"));
        //System.out.println(connect.getData());
       // ValidateUser username = new ValidateUser();
        //System.out.println(username.validateUsername("wsss"));
        //System.out.println(username.validatePassword("s14aSt"));
        //System.out.println(username.validatePassword("wss21sdS"));
        //System.out.println(username.validateEmail("Nica1408gmail.com"));
        String password = String.valueOf(passwordGen.generatePswd(6,6,1,3,0));
        System.out.println(connect.chechIfEmailExist("Nica1408@gmail.com"));
        connect.changePassword("Email@email.com", "12");
    }
}
