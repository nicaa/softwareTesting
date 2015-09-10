/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Validator.ValidateUser;

/**
 *
 * @author Nichlas
 */
public class MainTest {
    public static void main(String[] args) {

        DBConnect connect = new DBConnect();
        //Registration Complete with hash and salt!
        //connect.registration("TestU12" , "TestP");
        //user exist test complete!
        //System.out.println(connect.chechIfUserExist("tesu1"));
        //Login Complete!
        System.out.println(connect.login("Nicaa1", "123"));
        //System.out.println(connect.registration("Nicaa1", "123"));
        //System.out.println(connect.getData());
       // ValidateUser username = new ValidateUser();
        //System.out.println(username.validateUsername("wsss"));
        //System.out.println(username.validatePassword("s14aSt"));
        //System.out.println(username.validatePassword("wss21sdS"));
        
    }
}
