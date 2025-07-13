package pg.cyber.cyber.crypt.decrypt;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;

public class CTRDecrypt extends Decrypt {

    @Override
    public void decrypt(File inputFile, String password) throws Exception {
        File outputFile = new File(inputFile.getParentFile(), inputFile.getName() + ".dec");
        var key = deriveKey(password);

        byte[] iv = new byte[16];

        try (FileInputStream fis = new FileInputStream(inputFile)) {
            if (fis.read(iv) != 16) {
                throw new IOException("Failed to read IV");
            }

            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));

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
