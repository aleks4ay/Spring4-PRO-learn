package ua.aleks4ay.jdbc;

import org.jasypt.util.text.StrongTextEncryptor;

public class Decryptor {

    public static void main(String[] args) {
        String pass = "root..";
        System.out.println("pass = " + pass);

        String passEncrypted = encryptString(pass);
        System.out.println("passEncrypted = " + passEncrypted);

        String passDecrypted1 = decryptString(passEncrypted);
        System.out.println("passDecrypted1 = " + passDecrypted1);
    }

    private static final String JASYPT_PWD = "$2a$12$beX8PPMlJKNyeSWM4GZ7U.3pzaWsHE8rs3tIU5Be3tEPzS66/jgjW";

    static String encryptString(String string) {
        StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
        textEncryptor.setPassword(JASYPT_PWD);
        return textEncryptor.encrypt(textEncryptor.encrypt(string));
    }

    static String decryptString(String string) {
        StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
        textEncryptor.setPassword(JASYPT_PWD);
        return textEncryptor.decrypt(textEncryptor.decrypt(string));
    }
}
