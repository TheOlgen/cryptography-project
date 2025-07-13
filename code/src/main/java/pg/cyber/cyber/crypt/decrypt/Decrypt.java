package pg.cyber.cyber.crypt.decrypt;

import pg.cyber.cyber.CryptApplication;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.spec.KeySpec;

public abstract class Decrypt {
    public abstract void decrypt(File inputFile, String password) throws Exception;

    protected SecretKeySpec deriveKey(String password) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), CryptApplication.SALT, 65536, 128);
        SecretKey tmp = factory.generateSecret(spec);
        return new SecretKeySpec(tmp.getEncoded(), "AES");
    }
}
