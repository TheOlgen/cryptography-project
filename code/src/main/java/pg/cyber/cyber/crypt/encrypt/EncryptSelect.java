package pg.cyber.cyber.crypt.encrypt;

import pg.cyber.cyber.Payload;

import java.util.Objects;

public class EncryptSelect {

    public boolean encrypt(Payload payload) {
        var encrypt = payload.getAlgorithm().getEncrypt();
        try {
            Objects.requireNonNull(encrypt).encrypt(payload.getFile(), payload.getPassword());
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
