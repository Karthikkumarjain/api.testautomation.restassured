package utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;

public class SecretsEncryptDecrypt {

    private StringEncryptor decryptor = decryptor();

    private StringEncryptor decryptor() {

        StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
        decryptor.setProvider(new BouncyCastleProvider());
        //     decryptor.setPassword("karthikkumarjain");
        decryptor.setAlgorithm("PBEWITHSHA256AND256BITAES-CBC-BC");
        return decryptor;
    }

    public String stringDecrypt(String encryptedString) {
        return this.decryptor.decrypt(encryptedString);

    }


    public String stringEncrypt(String encryptedString) {
        return this.decryptor.encrypt(encryptedString);

    }

    @Test
    void testMethod() {

        //To encrypt--> ENC(String)
        //To decrypt-->Pass the string and can set password in env variables.


        String hey = "Ll+1r9kQ4XQSdWs7Sd+d3XmgSkwGR/ZBSRiBPZZwdQY=";


        System.out.println(stringDecrypt(hey));
    }
}
