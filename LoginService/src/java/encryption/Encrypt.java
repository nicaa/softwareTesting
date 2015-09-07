/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 * @author Nichlas
 */
public class Encrypt {

    public Encrypt() {

    }

    public String md5(String input) {
        String md5 = null;
        if (null == input) {
            return null;
        }
        try {
            //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");
            //Update input string in message digest
            digest.update(input.getBytes(), 0, input.length());
            //Converts message digest value in base 16 (hex) 
            md5 = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error in MD5 Encruption method");
            e.printStackTrace();
        }
        return md5;
    }
    
    public String getSalt() throws NoSuchAlgorithmException {
        
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
       
        String SaltString = new String(salt);
        return SaltString;
    }
}
