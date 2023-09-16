
package sys.componentes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class EncriptarPassword {
    
        public static String sha512(String cadena) {
        StringBuilder sb = new StringBuilder();

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(cadena.getBytes());
            byte[] mb = md.digest();

            for (int i = 0; i < mb.length; i++) {
                sb.append(Integer.toString((mb[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace(System.out);
        }
        return sb.toString();
    }
    
}
