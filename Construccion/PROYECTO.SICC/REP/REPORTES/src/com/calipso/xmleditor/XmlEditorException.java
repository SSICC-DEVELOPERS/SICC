package com.calipso.xmleditor;

/**
 * Created by IntelliJ IDEA.
 * User: jbassino
 * Date: 01/07/2004
 * Time: 14:09:05
 * To change this template use Options | File Templates.
 */
public class XmlEditorException extends Exception{
  public XmlEditorException(String s) {
    super(s);
  }

  public XmlEditorException(Exception e) {
    super(e);
  }

  public XmlEditorException(String s, Exception e){
    super(s,e);
  }
}
