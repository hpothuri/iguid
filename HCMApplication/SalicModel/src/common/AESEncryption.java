package common;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import javax.xml.bind.DatatypeConverter;

/**
 * This example program shows how AES encryption and decryption can be done in Java.
 * Please note that secret key and encrypted text is unreadable binary and hence
 * in the following program we display it in hexadecimal format of the underlying bytes.
 * @author Jayson
 */

public class AESEncryption {



  /**
   * 1. Generate a plain text for encryption
   * 2. Get a secret key (printed in hexadecimal form). In actual use this must
   * by encrypted and kept safe. The same key is required for decryption.
   */

  private static final String ENCRYPT_KEY_PASSWORD = "39363244453246343846333346453130";

  public static void main(String[] args) throws Exception {

      String plainText = "1234";

      String cipherText = encryptText(plainText);

      String decryptedText = decryptText(cipherText);

       

      System.out.println("Original Text:" + plainText);

      System.out.println("Encrypted Text:"+cipherText);

      System.out.println("Descrypted Text:"+decryptedText);

       

  }

   

  /**

   * gets the AES encryption key. In your actual programs, this should be safely

   * stored.

   * @return

   * @throws Exception

   */

  public static SecretKey getSecretEncryptionKey() throws Exception{      
      byte[] key = (ENCRYPT_KEY_PASSWORD).getBytes("UTF-8");
      MessageDigest sha = MessageDigest.getInstance("SHA-1");
      key = sha.digest(key);
      key = Arrays.copyOf(key, 16); // use only first 128 bit

      SecretKey secKey = new SecretKeySpec(key, "AES");
      return secKey;
  }

   

  /**

   * Encrypts plainText in AES using the secret key

   * @param plainText

   * @param secKey

   * @return

   * @throws Exception

   */

  public static String encryptText(String plainText) {

      // AES defaults to AES/ECB/PKCS5Padding in Java 7
        try {
            SecretKey secKey = getSecretEncryptionKey();

            Cipher aesCipher = Cipher.getInstance("AES");

            aesCipher.init(Cipher.ENCRYPT_MODE, secKey);

            byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
            String cipherText = bytesToHex(byteCipherText);

            return cipherText;
        } catch (IllegalBlockSizeException ibse) {
            ibse.printStackTrace();
        } catch (InvalidKeyException ike) {
            ike.printStackTrace();
        } catch (NoSuchPaddingException nspe) {
            nspe.printStackTrace();
        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        } catch (BadPaddingException bpe) {
            bpe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

  }

   

  /**

   * Decrypts encrypted byte array using the key used for encryption.

   * @param byteCipherText

   * @param secKey

   * @return

   * @throws Exception

   */

  public static String decryptText(String cipherText) {
      
      try {
            byte[] byteCipherText = hexStringToByteArray(cipherText);

            SecretKey secKey = getSecretEncryptionKey();
            // AES defaults to AES/ECB/PKCS5Padding in Java 7

            Cipher aesCipher = Cipher.getInstance("AES");

            aesCipher.init(Cipher.DECRYPT_MODE, secKey);

            byte[] bytePlainText = aesCipher.doFinal(byteCipherText);

            return new String(bytePlainText);
        } catch (IllegalBlockSizeException ibse) {
            ibse.printStackTrace();
        } catch (InvalidKeyException ike) {
            ike.printStackTrace();
        } catch (NoSuchPaddingException nspe) {
            nspe.printStackTrace();
        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        } catch (BadPaddingException bpe) {
            bpe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
  }

   

  /**

   * Convert a binary byte array into readable hex form

   * @param hash

   * @return

   */

  private static String  bytesToHex(byte[] hash) {

      return DatatypeConverter.printHexBinary(hash);

  }
  
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

}
