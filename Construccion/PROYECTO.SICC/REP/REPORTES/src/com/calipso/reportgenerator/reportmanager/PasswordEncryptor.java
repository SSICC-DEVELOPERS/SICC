package com.calipso.reportgenerator.reportmanager;

import java.security.MessageDigest;

/**
 * Encriptador
 */

public class PasswordEncryptor {

  /**
   * Devuelve el hash correspondiente a una contrasena dada.
   * @param password
   * @return
   */
  public static String getEncryptedPassword(String password) {
    StringBuffer buffer = new StringBuffer();
    try {
      byte [] encrypt = password.getBytes("UTF-8");
      MessageDigest md = MessageDigest.getInstance("SHA");
      md.update(encrypt);
      byte [] hashedPasswd = md.digest();
      for(int i = 0 ; i < hashedPasswd.length ; i++) {
        buffer.append(Byte.toString(hashedPasswd [i]));
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
    return buffer.toString();
  }
}
