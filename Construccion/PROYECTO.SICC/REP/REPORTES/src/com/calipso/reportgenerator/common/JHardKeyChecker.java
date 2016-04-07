package com.calipso.reportgenerator.common;

/**
 * Created by IntelliJ IDEA.
 * User: Breto
 * Date: 10/05/2004
 * Time: 09:29:36
 * To change this template use File | Settings | File Templates.
 */
public class JHardKeyChecker {

  public static native boolean initConection();
  public static native boolean checkKey();
  public static native void realiseHardKeyChecker();

  static {
    System.loadLibrary("JNACSys");
  }

  public static void init(){
  }

}
