package com.calipso.reportgenerator.common;

import es.indra.mare.common.info.InfoException;

import java.util.Date;
import java.util.Vector;
import java.util.Collection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.calipso.reportgenerator.common.LanguageTraslator;

/**
 * Esta clase se encarga de controlar las propiedades de la versión. Demo, liberada, etc.
 */
public class  VersionProperties {
  public static String versionNumber = "0.5.2";
  public static String ClientName = "";



  private static int maxNumberDefinition =1000;
  private static int maxNumberRecords = 1000000000;

  private static String expirationDate = "20090701";
  private static int maxNumberViews = 1000000000;

  /*private static int maxNumberDefinition = 100000000;
  private static int maxNumberRecords = 1000000000;
  //private static String expirationDate="29991231";
  private static int maxNumberViews = 100000000;*/



  private static boolean protect = false;// Proteccion de llave física*/
  // Coleccion de los ids de los programas conocidos que no requieren validacion
  private static Collection knownProgramIds;

  public static Collection getKnownProgramIds() {
    if(knownProgramIds==null){
      knownProgramIds = fillKnownProgramIds();
    }
    return knownProgramIds;
  }

  private static Collection fillKnownProgramIds() {
    Collection result = new Vector();
    result.add("CalipsoBilling");
    return result;
  }

  public static boolean getDateValid() throws InfoException {
    Date now = new Date();
    try{
      Date expiration;
      DateFormat dateFormat;
      dateFormat = new SimpleDateFormat("yyyyMMdd");
      expiration = dateFormat.parse(getExpirationDate());
      if (now.after(expiration)){
        return false;
      }else{
        return true;
      }
    }catch(Exception e){
      throw new InfoException(LanguageTraslator.traslate("246"),e);
    }
  }

  private static String getExpirationDate() {
    return expirationDate;
  }

  public static int getMaxNumberDefinition() {
    return maxNumberDefinition;
  }

  public static int getMaxNumberRecords() {
    return maxNumberRecords;
  }

  public static int getMaxNumberViews() {
    return maxNumberViews;
  }

  public static boolean isProtected() {
    return protect;
  }

  public static boolean keyProtected(){
    if (isProtected()){
   //   JHardKeyChecker.init();
      JHardKeyChecker.initConection();
    }
    return isProtected();
  }

  public static boolean checkKey(){
    return JHardKeyChecker.checkKey();
  }

  public static void realiseApplication(){
    if (isProtected()){
      JHardKeyChecker.realiseHardKeyChecker();
    }
  }
}
