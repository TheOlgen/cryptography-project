package pg.cyber.cyber;

import java.io.File;

public class Payload {
    private File file;
    private String password;
    private AlgorithmAES algorithm;




    public AlgorithmAES getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(AlgorithmAES algorithm) {
        this.algorithm = algorithm;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
