package com.calipso.xmleditor;

import javax.swing.*;
import java.util.Enumeration;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: 03-oct-2003
 * Time: 12:25:38
 * To change this template use Options | File Templates.
 */

public class XmlEditorSubPanelValidator {

  /**
   * Valida las entradas de un subpanel.
   * @param subPanel
   * @param definition
   * @return
   */
  public static String validateFrom(XmlEditorSubPanel subPanel, XmlEditorTreeDefinitionNode definition) {
    String elementWrong = null;
    Enumeration enumeration = definition.getItemsKeys().elements();
    for(int i = 0 ; i < subPanel.getInputComponents().size() ; i++) {
      XmlEditorTreeNodeItemDefinition item = (XmlEditorTreeNodeItemDefinition) definition.getItems().get(enumeration.nextElement().toString());
      if(!item.isOptional()) {
        if(!isValid(subPanel.getInputComponents().elementAt(i))) {
          elementWrong = item.getName();
          break;
        }
      }
    }
    return elementWrong;
  }

  public static boolean isValid(Object object) {
    if(object instanceof JTextField) {
      if(((JTextField)object).getText().equals("")) {
        return false;
      }
    }
    return true;
  }
}
