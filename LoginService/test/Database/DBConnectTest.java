/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nichlas
 */
public class DBConnectTest {
    
    public DBConnectTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registration method, of class DBConnect.
     */
    @Test
    public void testRegistration() {
        System.out.println("registration");
        String username = "666";
        String password = "123";
        DBConnect instance = new DBConnect();
        boolean expResult = false;
        boolean result = instance.registration(username, password);
        assertEquals(expResult, result); 
    }

    /**
     * Test of login method, of class DBConnect.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "123";
        String password = "123";
        DBConnect instance = new DBConnect();
        boolean expResult = true;
        boolean result = instance.login(username, password);
        assertEquals(expResult, result);    
    }

    /**
     * Test of chechIfUserExist method, of class DBConnect.
     */
    @Test
    public void testChechIfUserExist() {
        //Returns false if user do not exist in database and true if a user with the same name is found. 
        System.out.println("chechIfUserExist");
        String username = "123435"; 
        DBConnect instance = new DBConnect();
        boolean expResult = false;
        boolean result = instance.chechIfUserExist(username);
        assertEquals(expResult, result);
        
    }

}
