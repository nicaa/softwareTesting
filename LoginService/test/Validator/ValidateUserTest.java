/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

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
public class ValidateUserTest {

    public ValidateUserTest() {
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
     * Test of validateUsername method, of class ValidateUser.
     */
    @Test
    public void testValidateUsernameCase1() {
        System.out.println("validateUsername1 without number");
        String username = "PeterJohnson";
        ValidateUser instance = new ValidateUser();
        boolean expResult = true;
        boolean result = instance.validateUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testValidateUsernameCase2() {
        System.out.println("validateUsername2 with number");
        String username = "Peter23";
        ValidateUser instance = new ValidateUser();
        boolean expResult = true;
        boolean result = instance.validateUsername(username);
        assertEquals(expResult, result);

    }

    @Test
    public void testValidateUsernameCase3() {
        System.out.println("validateUsername3 username < 6 chars ");
        String username = "Jim";
        ValidateUser instance = new ValidateUser();
        boolean expResult = false;
        boolean result = instance.validateUsername(username);
        assertEquals(expResult, result);

    }

    @Test
    public void testValidateUsernameCase4() {
        System.out.println("validateUsername4 username > 12");
        String username = "HejJegHarEtLangtNavn";
        ValidateUser instance = new ValidateUser();
        boolean expResult = false;
        boolean result = instance.validateUsername(username);
        assertEquals(expResult, result);

    }

    @Test
    public void testValidateUsernameCase5() {
        System.out.println("validateUsername5 username with spaces");
        String username = "Jim Abe";
        ValidateUser instance = new ValidateUser();
        boolean expResult = false;
        boolean result = instance.validateUsername(username);
        assertEquals(expResult, result);

    }

    @Test
    public void testValidateUsernameCase6() {
        System.out.println("validateUsername6 username blank");
        String username = "";
        ValidateUser instance = new ValidateUser();
        boolean expResult = false;
        boolean result = instance.validateUsername(username);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidateUsernameCase7() {
        System.out.println("validateUsername7 username uppercase");
        String username = "BIGNAMEOP";
        ValidateUser instance = new ValidateUser();
        boolean expResult = true;
        boolean result = instance.validateUsername(username);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidateUsernameCase8() {
        System.out.println("validateUsername8 username Danish chars");
        String username = "ÆbleSpiser";
        ValidateUser instance = new ValidateUser();
        boolean expResult = false;
        boolean result = instance.validateUsername(username);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidateUsernameCase9() {
        System.out.println("validateUsername9 username special chars");
        String username = "Hejjeg@";
        ValidateUser instance = new ValidateUser();
        boolean expResult = false;
        boolean result = instance.validateUsername(username);
        assertEquals(expResult, result);
    }
    /*
     * Test of validatePassword method, of class ValidateUser.
     */

    @Test
    public void testValidatePassword1() {
        System.out.println("validatePassword1 only numbers");
        String password = "12345678";
        ValidateUser instance = new ValidateUser();
        boolean expResult = false;
        boolean result = instance.validatePassword(password);
        assertEquals(expResult, result);

    }

    @Test
    public void testValidatePassword2() {
        System.out.println("validatePassword2 only letters");
        String password = "entotrefire";
        ValidateUser instance = new ValidateUser();
        boolean expResult = false;
        boolean result = instance.validatePassword(password);
        assertEquals(expResult, result);

    }

    @Test
    public void testValidatePassword3() {
        System.out.println("validatePassword3 no capital letter");
        String password = "123hejmeddig";
        ValidateUser instance = new ValidateUser();
        boolean expResult = false;
        boolean result = instance.validatePassword(password);
        assertEquals(expResult, result);

    }

    @Test
    public void testValidatePassword4() {
        System.out.println("validatePassword4 password < 8 chars");
        String password = "N1hej";
        ValidateUser instance = new ValidateUser();
        boolean expResult = false;
        boolean result = instance.validatePassword(password);
        assertEquals(expResult, result);

    }

    @Test
    public void testValidatePassword5() {
        System.out.println("validatePassword5 password > 30 ");
        String password = "123Hejmeddigsssssssssssssssssss";
        ValidateUser instance = new ValidateUser();
        boolean expResult = false;
        boolean result = instance.validatePassword(password);
        assertEquals(expResult, result);

    }

    @Test
    public void testValidatePassword6() {
        System.out.println("validatePassword6 succes Password special chars");
        String password = "Hej123@nm";
        ValidateUser instance = new ValidateUser();
        boolean expResult = true;
        boolean result = instance.validatePassword(password);
        assertEquals(expResult, result);

    }

    @Test
    public void testValidatePassword7() {
        System.out.println("validatePassword7 succes Password no special chars");
        String password = "Hej123nm";
        ValidateUser instance = new ValidateUser();
        boolean expResult = true;
        boolean result = instance.validatePassword(password);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testValidatePassword8() {
        System.out.println("Password between 8 and 30 chars");
        String password = "ThisIsAPassword30";
        ValidateUser instance = new ValidateUser();
        boolean expResult = true;
        boolean result = instance.validatePassword(password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidatePasswordBoundary1() {
        String password = "Passwor8";
        ValidateUser instance = new ValidateUser();
        boolean expResult = true;
        boolean result = instance.validatePassword(password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidatePasswordBoundary2() {
        String password = "Passwooooooooooooooooooooord30";
        ValidateUser instance = new ValidateUser();
        boolean expResult = true;
        boolean result = instance.validatePassword(password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateEmail1() {
        System.out.println("validateEmail1 Empty Email");
        String email = "";
        ValidateUser instance = new ValidateUser();
        boolean expResult = false;
        boolean result = instance.validateEmail(email);
        assertEquals(expResult, result);

    }
    
     @Test
    public void testValidateEmail2() {
        System.out.println("validateEmail2 No @ No .");
        String email = "hej";
        ValidateUser instance = new ValidateUser();
        boolean expResult = false;
        boolean result = instance.validateEmail(email);
        assertEquals(expResult, result);

    }
     @Test
    public void testValidateEmail3() {
        System.out.println("validateEmail3 No @");
        String email = "hej.dk";
        ValidateUser instance = new ValidateUser();
        boolean expResult = false;
        boolean result = instance.validateEmail(email);
        assertEquals(expResult, result);

    }
     @Test
    public void testValidateEmail4() {
        System.out.println("validateEmail4 succes like nic@stud.kea.dk");
        String email = "nic@stud.kea.dk";
        ValidateUser instance = new ValidateUser();
        boolean expResult = true;
        boolean result = instance.validateEmail(email);
        assertEquals(expResult, result);

    }
    @Test
    public void testValidateEmail5() {
        System.out.println("validateEmail5 like nica@gmail");
        String email = "nica@gmail";
        ValidateUser instance = new ValidateUser();
        boolean expResult = false;
        boolean result = instance.validateEmail(email);
        assertEquals(expResult, result);

    }
    @Test
    public void testValidateEmail6() {
        System.out.println("validateEmail6 succes like Nica1408@gmail.com");
        String email = "Nica1408@gmail.com";
        ValidateUser instance = new ValidateUser();
        boolean expResult = true;
        boolean result = instance.validateEmail(email);
        assertEquals(expResult, result);

    }
     @Test
    public void testValidateEmail7() {
        System.out.println("validateEmail 7 like @gmail.com");
        String email = "@gmail.com";
        ValidateUser instance = new ValidateUser();
        boolean expResult = false;
        boolean result = instance.validateEmail(email);
        assertEquals(expResult, result);

    }
}
