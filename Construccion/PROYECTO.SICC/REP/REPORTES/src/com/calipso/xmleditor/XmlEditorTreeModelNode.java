package com.calipso.xmleditor;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.*;
import java.util.Vector;
import java.util.Enumeration;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: 01-oct-2003
 * Time: 17:13:07
 * To change this template use Options | File Templates.
 */

public class XmlEditorTreeModelNode extends DefaultMutableTreeNode {

  private Vector attributes;
  private Vector attributeNames;

  public XmlEditorTreeModelNode(String name) {
    super(name);
  }

  /**
   * Agrega los atributos a un Nodo en base a los datos de un panel.
   * @param subPanel
   */
  public void addAttributesFrom(XmlEditorSubPanel subPanel) {
    attributeNames = subPanel.getElements();
    Enumeration enumeration = subPanel.getInputComponents().elements();
    for(int i = 0 ; enumeration.hasMoreElements() ; i++) {
      Object object = enumeration.nextElement();
      if(object instanceof  JTextField) {
        getAttributes().add(((JTextField)object).getText());
      } else {
        JComboBox comboBox = (JComboBox) object;
        getAttributes().add(comboBox.getSelectedItem().toString());
      }
    }
  }

  /**
   * Actualiza un nodo en base los valores de un SubPanel
   * @param subPanel
   */
  public void updateAttributesFrom(XmlEditorSubPanel subPanel) {
    Enumeration enumeration = subPanel.getInputComponents().elements();
    for(int i = 0 ; enumeration.hasMoreElements() ; i++) {
      Object object = enumeration.nextElement();
      if(getAttributes().size()>i){
        getAttributes().remove(i);
        if(object instanceof JTextField) {
          getAttributes().add(i, ((JTextField)object).getText());
        } else if(object instanceof JComboBox) {
          JComboBox comboBox = (JComboBox) object;
          Object [] objects =comboBox.getSelectedObjects();
          getAttributes().add(i, objects [0]);
        }
      }
    }
  }

  public void addAttributesFrom(Vector attrNames, Vector attributes) {
    this.attributeNames = attrNames;
    this.attributes = attributes;
  }

  public Vector getAttributeNames() {
    return attributeNames;
  }

  public Vector getAttributes() {
    if(attributes == null) {
      attributes = new Vector();
    }
    return attributes;
  }

  public String getId() {
    Vector attributeNames = getAttributeNames();
    if(attributeNames!=null && !attributeNames.isEmpty()){
      int pos = attributeNames.indexOf("Id");
      if(pos >= 0){
        return getAttributes().elementAt(pos).toString();
      }else if(attributeNames.indexOf("Name")>=0){
        return getAttributes().elementAt(attributeNames.indexOf("Name")).toString();
      }else{
        return getAttributes().elementAt(0).toString();
      }
    }
    return null;
  }

  public String getAttribute(String attributeName) {
    int index = getAttributeNames().indexOf(attributeName);
    if(index>=0){
      return getAttributes().elementAt(index).toString();
    }else{
      return "";
    }
  }

}
