/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Database.DBConnect;
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
    
    @WebMethod(operationName = "Registrate")
    public boolean Registrate(String username, String password){

        return dBConnect.registration(username, password);
    }
}
