package demoproject;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author BEL
 */
public class Encrypt {

    public static String encrypt(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] code = md.digest(str.getBytes());

            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, code);

            // Convert message digest into hex value 
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit 
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText 
            return hashtext;
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

}
