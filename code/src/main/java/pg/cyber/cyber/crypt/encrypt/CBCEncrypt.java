package pg.cyber.cyber.crypt.encrypt;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

public class CBCEncrypt extends Encrypt {
    @Override
    public void encrypt(File input, String password)
        throws InvalidKeySpecException, NoSuchAlgorithmException, FileNotFoundException,
        InvalidAlgorithmParameterException, InvalidKeyException, NoSuchPaddingException {

        var key = genKey(password);

        File outputFile = new File(input.getParentFile(), input.getName() + ".enc");

        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));

        try (
            FileInputStream fis = new FileInputStream(input);
            FileOutputStream fos = new FileOutputStream(outputFile);
            CipherOutputStream cos = new CipherOutputStream(fos, cipher)
        ) {
            fos.write(iv);

            byte[] buffer = new byte[4096];
            int n;
            while ((n = fis.read(buffer)) != -1) {
                cos.write(buffer, 0, n);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
