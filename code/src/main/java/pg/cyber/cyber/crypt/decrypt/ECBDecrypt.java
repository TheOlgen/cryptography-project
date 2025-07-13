package pg.cyber.cyber.crypt.decrypt;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

import java.io.*;

public class ECBDecrypt extends Decrypt {
    @Override
    public void decrypt(File inputFile, String password) throws Exception {
        File outputFile = new File(inputFile.getParentFile(), inputFile.getName() + ".dec");
        var key = deriveKey(password);


        try (FileInputStream fis = new FileInputStream(inputFile)) {


            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);

            try (
                CipherInputStream cis = new CipherInputStream(fis, cipher);
                FileOutputStream fos = new FileOutputStream(outputFile)
            ) {
                byte[] buffer = new byte[4096];
                int n;
                while ((n = cis.read(buffer)) != -1) {
                    fos.write(buffer, 0, n);
                }
            }
        }
    }

}
