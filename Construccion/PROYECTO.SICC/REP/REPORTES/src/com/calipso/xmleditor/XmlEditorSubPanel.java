package com.calipso.xmleditor;

import org.exolab.castor.xml.schema.Facet;
import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.util.HashMap;
import java.util.Vector;
import java.util.Enumeration;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.text.DecimalFormat;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: 02-oct-2003
 * Time: 14:03:08
 * To change this template use Options | File Templates.
 */

public class XmlEditorSubPanel extends JPanel  {

  private Vector cboBoxDefaults;
  private Vector elements;
  private Vector inputComponents;

  /**
   * Crea un nuevo SubPanel con las claves y elementos pasados por parametros.
   * @param keys
   * @param elements
   * @throws XmlEditorException
   */
  public XmlEditorSubPanel(Vector keys, HashMap elements) throws XmlEditorException{
    this.elements = keys;
    cboBoxDefaults = new Vector();
    initialize(keys, elements);
  }

  public XmlEditorSubPanel(Vector keys) {
    this.elements = keys;
    initialize(keys);
  }

  /**
   * Inicializa el panel, con las claves dadas.
    * @param keys
   */
  private void initialize(Vector keys) {
    GridBagLayout bagLayout = new GridBagLayout();
    setLayout(bagLayout);
    GridBagConstraints constraints = new GridBagConstraints();
    fillFrom(keys, bagLayout, constraints);
  }

  private void initialize(Vector keys, HashMap elements) throws XmlEditorException{
    GridBagLayout bagLayout = new GridBagLayout();
    setLayout(bagLayout);
    GridBagConstraints constraints = new GridBagConstraints();
    fillFrom(keys, elements, bagLayout, constraints);
  }

  /**
   * Completa el panel (GridBagLayout) con los valores que tiene creando los labels y valores en base a sus atributos.
   * @param keys
   * @param bagLayout
   * @param constraints
   */
  private void fillFrom(Vector keys, GridBagLayout bagLayout,GridBagConstraints constraints) {
    int yPosition1 = 0;
    int yPosition2 = 0;
    Enumeration enumeration = keys.elements();
    while(enumeration.hasMoreElements()) {
      Component component = new JLabel(enumeration.nextElement().toString());
      add(component);
      constraints.weightx = 5;
      constraints.gridx = 0;
      constraints.gridy = yPosition1++;
      constraints.anchor = GridBagConstraints.SOUTHWEST;
      constraints.fill = GridBagConstraints.BOTH;
      bagLayout.setConstraints(component, constraints);

      component = new JTextField();
      ((JTextField)component).setAutoscrolls(true);
      getInputComponents().add(component);
      add(component);
      constraints.weightx = 5;
      constraints.gridx = 1;
      constraints.gridy = yPosition2++;
      constraints.anchor = GridBagConstraints.NORTHEAST;
      constraints.fill = GridBagConstraints.BOTH;
      bagLayout.setConstraints(component, constraints);
    }
  }

  private void fillFrom(Vector keys, HashMap elements, GridBagLayout bagLayout,GridBagConstraints constraints) throws XmlEditorException{
    Enumeration enum = keys.elements();
    int yPosition1 = 0;
    int yPosition2 = 0;
    while(enum.hasMoreElements()) {
      XmlEditorTreeNodeItemDefinition itemDefinition = (XmlEditorTreeNodeItemDefinition) elements.get(enum.nextElement().toString());
      if(itemDefinition != null) {
        Component component = getLabel(itemDefinition);
        add(component);
        constraints.weightx = 5;
        constraints.gridx = 0;
        constraints.gridy = yPosition1++;
        constraints.anchor = GridBagConstraints.SOUTHWEST;
        constraints.fill = GridBagConstraints.BOTH;
        bagLayout.setConstraints(component, constraints);

        component = getInputObject(itemDefinition);
        getInputComponents().add(component);
        add(component);
        constraints.weightx = 5;
        constraints.gridx = 1;
        constraints.gridy = yPosition2++;
        constraints.anchor = GridBagConstraints.NORTHEAST;
        constraints.fill = GridBagConstraints.BOTH;
        bagLayout.setConstraints(component, constraints);
      }
    }
  }

  private JLabel getLabel(XmlEditorTreeNodeItemDefinition itemDefinition) {
    JLabel label;
    if(itemDefinition.isOptional()) {
      label = new JLabel("   " + itemDefinition.getName() + " :");
    } else {
      label = new JLabel("   " + itemDefinition.getName() + " * :" );
    }
    label.setSize(new Dimension(getSize().width, HEIGHT));
    return label;
  }

  private Component getInputObject(XmlEditorTreeNodeItemDefinition itemDefinition) throws XmlEditorException{
    Component component = null;
    int type = itemDefinition.getType();
    switch(type){
      case XmlEditorDataType.TOKENS:
        component = new JComboBox(getItems(itemDefinition.getValue()));
        break;
      case XmlEditorDataType.BOOLEAN:
        component = new JComboBox(getBooleanValues());
        break;
      case XmlEditorDataType.STRING:
        component = new JTextField();
        ((JTextField)component).setAutoscrolls(true);        
        break;
      case XmlEditorDataType.INTEGER:
        component = new JFormattedTextField(getNumberFormatter());
        break;
      default:
        throw new XmlEditorException("No existe el tipo de dato solicitado");
    }
    return component;
  }

  private JFormattedTextField.AbstractFormatter getNumberFormatter() {
    return new NumberFormatter(new DecimalFormat("##########"));
  }

  private Vector getBooleanValues() {
    Vector items = new Vector();
    items.add("FALSE");
    items.add("TRUE");
    cboBoxDefaults.add("FALSE");
    return items;
  }

  private Vector getItems(Object values) {
    Vector items = new Vector();
    Enumeration enumeration = (Enumeration) values;
    for(int i = 0 ; enumeration.hasMoreElements() ; i++) {
      Facet facet = (Facet) enumeration.nextElement();
      items.add(facet.getValue().toUpperCase());
      if(i == 0) {
        cboBoxDefaults.add(facet.getValue().toUpperCase());
      }
    }
    return items;
  }

  /**
   * Borra todos los campos de un panel
   */
  public void eraseInputFields() {
    Enumeration inputComponents = getInputComponents().elements();
    for(int i = 0 ; inputComponents.hasMoreElements() ;) {
      Object object = inputComponents.nextElement();
      if(object instanceof JTextField) {
        ((JTextField)object).setText("");
      } else if(object instanceof JComboBox) {
        ((JComboBox)object).setSelectedItem(cboBoxDefaults.elementAt(i));
        i++;
      }
    }
    validate();
  }

  public void fillFrom(XmlEditorTreeModelNode modelNode) {
      Vector vector = modelNode.getAttributes();
    Enumeration inputComponents = getInputComponents().elements();
    for(int i = 0 ; inputComponents.hasMoreElements() && vector.size()>i; i++) {
      Object object = inputComponents.nextElement();
      if(object instanceof JTextField) {
        ((JTextField)object).setText((String)vector.elementAt(i));
      } else if(object instanceof JComboBox){
        if(isInBox(vector.elementAt(i).toString().toUpperCase(), (JComboBox)object)){
          ((JComboBox)object).setSelectedItem(((String)vector.elementAt(i)).toUpperCase());
        }else{
          JOptionPane.showMessageDialog(this, "El valor " + vector.elementAt(i) + " no es valido para el atributo. Sera reemplazado", "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    }
  }

  private boolean isInBox(String s, JComboBox jComboBox) {
    for(int i=0; i<jComboBox.getItemCount(); i++){
      if(jComboBox.getItemAt(i).toString().equalsIgnoreCase(s)){
        return true;
      }
    }
    return false;
  }

  public boolean isErased() {
    boolean returnVal = true;
    Enumeration enumeration = getInputComponents().elements();
    while(enumeration.hasMoreElements()) {
      Object object = enumeration.nextElement();
      if(object instanceof JTextField) {
        if(!((JTextField)object).getText().equals("")) {
          returnVal = false;
          break;
        }
      }
    }
    return returnVal;
  }

  public Vector getInputComponents() {
    if(inputComponents == null) {
      inputComponents = new Vector();
    }
    return inputComponents;
  }

  public Vector getElements() {
    return elements;
  }

  public Vector getCboBoxDefaults() {
    return cboBoxDefaults;
  }
}
