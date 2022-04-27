package tk.propensi.medix.util;

public interface EncryptionService {

    String encrypt(String strToEncrypt, String secret, String salt);

}
