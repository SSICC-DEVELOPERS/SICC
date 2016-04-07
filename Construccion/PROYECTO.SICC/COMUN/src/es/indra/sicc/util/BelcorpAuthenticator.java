package es.indra.sicc.util;

import java.net.*;


public class BelcorpAuthenticator extends Authenticator {
   private String usr;
   private char[] password;

   public BelcorpAuthenticator() {
   }

   public BelcorpAuthenticator(String usr, String pass) {
      this.usr = usr;
      this.password = pass.toCharArray();
   }

   protected PasswordAuthentication getPasswordAuthentication() {
      return new PasswordAuthentication(this.usr, this.password);
   }
}
