package pg.cyber.cyber;

import pg.cyber.cyber.crypt.decrypt.CBCDecrypt;
import pg.cyber.cyber.crypt.decrypt.CTRDecrypt;
import pg.cyber.cyber.crypt.decrypt.Decrypt;
import pg.cyber.cyber.crypt.decrypt.ECBDecrypt;
import pg.cyber.cyber.crypt.encrypt.CBCEncrypt;
import pg.cyber.cyber.crypt.encrypt.CTREncrypt;
import pg.cyber.cyber.crypt.encrypt.ECBEncrypt;
import pg.cyber.cyber.crypt.encrypt.Encrypt;

public enum AlgorithmAES {
    CTR,
    ECB,
    CBC;
    public Encrypt getEncrypt() {
        return switch (this) {
            case CTR ->  new CTREncrypt();
            case ECB -> new ECBEncrypt();
            case CBC -> new CBCEncrypt();
        };
    }
    public Decrypt getDecrypt() {
        return switch (this) {
            case CTR ->  new CTRDecrypt();
            case ECB -> new ECBDecrypt();
            case CBC -> new CBCDecrypt();
        };
    }
}
