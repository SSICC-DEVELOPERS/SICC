package com.calipso.xmleditor;

import java.awt.Dimension;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: 14-oct-2003
 * Time: 17:58:23
 * To change this template use Options | File Templates.
 */

public class StartUP {
  public static void main(String [] args) {
    XmlEditorUI editorUI = new XmlEditorUI("", args);
    editorUI.setSize(new Dimension(800, 575));
    editorUI.show();
  }
}
