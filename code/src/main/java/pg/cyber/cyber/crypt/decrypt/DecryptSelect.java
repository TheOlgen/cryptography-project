package pg.cyber.cyber.crypt.decrypt;

import pg.cyber.cyber.Payload;

public class DecryptSelect {

    public boolean decrypt(Payload payload) {
        var decrypt = payload.getAlgorithm().getDecrypt();
        try {
            decrypt.decrypt(payload.getFile(), payload.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
