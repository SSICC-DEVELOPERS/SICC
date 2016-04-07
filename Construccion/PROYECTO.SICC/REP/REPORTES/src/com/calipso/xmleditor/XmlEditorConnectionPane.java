package com.calipso.xmleditor;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import javax.swing.text.Document;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: jbassino
 * Date: 17/06/2004
 * Time: 15:56:50
 * To change this template use Options | File Templates.
 */
public class XmlEditorConnectionPane extends JDialog implements ActionListener{
  JButton btnAccept;
  JButton btnCancel;
  JTextField txtDriverName;
  JTextField txtUrl;
  JTextField txtUser;
  JPasswordField pswPassword;
  JTextArea txtQuery;
  JTextField txtReportName;
  private JTextField txtMetricStart;
  private boolean cancelled = false;

  /**
   * Obtiene la variable que indica si el panel ha sido cancelado.
   * @return
   */
  public boolean isCancelled() {
    return cancelled;
  }

  /**
   * Genera el panel de carga de parametros.
   * @param component
   */
  public XmlEditorConnectionPane(XmlEditorUI component, boolean modal, Map defaultParams){
    super(component, modal);
    setTitle("Ingrese SQL Query");
    getContentPane().setLayout(new GridBagLayout());
    GridBagConstraints constrain = new GridBagConstraints();


    txtReportName = new JTextField("Nombre del reporte", 50);
    addComponent(constrain, new JLabel("Nombre del Reporte "), 0, 0, 1, 1);
    addComponent(constrain, txtReportName, 0,1,1,5);

    txtMetricStart = new JTextField("Posicion de inicio de las metricas");
    addComponent(constrain, new JLabel("Inicio de metricas "), 1, 0, 1, 1);
    addComponent(constrain, txtMetricStart, 1,1,1,5);


    txtQuery = new JTextArea("Query");
    txtQuery.setBorder(txtMetricStart.getBorder());
    txtQuery.setAutoscrolls(false);
    txtQuery.setLineWrap(true);
    JScrollPane jScrollPane =  new JScrollPane(txtQuery);
    addComponent(constrain, new JLabel("Query "), 2, 0, 1, 1);
    addComponent(constrain, jScrollPane, 2,1,5,10);

    txtDriverName = new JTextField("Class Name ");
    if (defaultParams.containsKey(new String("DefaultConnectionClassName"))){
      txtDriverName.setText(defaultParams.get(new String("DefaultConnectionClassName")).toString());
    }
    addComponent(constrain, new JLabel("Class Name "), 7, 0, 1, 1);
    addComponent(constrain, txtDriverName, 7, 1, 1, 5);

    txtUrl = new JTextField("Local Url", 50);
    if (defaultParams.containsKey(new String("DefaultConnectionLocalUrl"))){
      txtUrl.setText(defaultParams.get(new String("DefaultConnectionLocalUrl")).toString());
    }
    addComponent(constrain, new JLabel("Local Url "), 8, 0, 1, 1);
    addComponent(constrain, txtUrl, 8, 1, 1, 5);

    txtUser = new JTextField("User");
    if (defaultParams.containsKey(new String("DefaultConnectionUser"))){
      txtUser.setText(defaultParams.get(new String("DefaultConnectionUser")).toString());
    }
    addComponent(constrain, new JLabel("User "), 9, 0, 1, 1);
    addComponent(constrain, txtUser, 9, 1, 1, 5);

    pswPassword = new JPasswordField("Password", 25);
    if (defaultParams.containsKey(new String("DefaultConnectionPassword"))){
      pswPassword.setText(defaultParams.get(new String("DefaultConnectionPassword")).toString());
    }
    addComponent(constrain, new JLabel("Password "), 10, 0, 1, 1);
    addComponent(constrain, pswPassword, 10, 1, 1, 5);

    JPanel pnlButton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    btnAccept = new JButton("Aceptar");
    btnAccept.addActionListener(this);
    pnlButton.add(btnAccept);
    btnCancel = new JButton("Cancelar");
    btnCancel.addActionListener(this);
    pnlButton.add(btnCancel);
    addComponent(constrain, pnlButton, 11, 4, 1,2);
    setResizable(false);
    pack();
  }

  /**
   * Agrega el item al panel con los parametros pasados para la GridBagConstraints.
   * @param constrain
   * @param component: el componente a agregar
   * @param row: el numero de fila en el que se agregara
   * @param col: el numero de columna en el que se agregara
   * @param height: las filas que ocupara
   * @param width: el numero de columnas que ocupara
   */
  private void addComponent(GridBagConstraints constrain, Component component, int row, int col, int height, int width) {
    if(!(component instanceof JButton)){
      constrain.fill = GridBagConstraints.HORIZONTAL;
    }else{
      constrain.anchor = GridBagConstraints.WEST;
    }
    constrain.gridy = row;
    constrain.gridx = col;
    constrain.gridheight = height;
    constrain.gridwidth = width;
    ((GridBagLayout)getContentPane().getLayout()).setConstraints(component, constrain);
    getContentPane().add(component);
  }

  public void actionPerformed(ActionEvent e) {
    this.dispose();
    if(e.getSource() == btnAccept){
      setCancelled(false);
    }else{
      setCancelled(true);
    }
    /*}else if(e.getSource() == btnAccept){
      listener.createReportDefinitionsFromSql(txtReportName.getText(),
                                      txtDriverName.getText(),
                                      txtUrl.getText(),
                                      txtUser.getText(),
                                      String.valueOf(pswPassword.getPassword()),
                                      txtQuery.getText(),
                                      Integer.valueOf(txtMetricStart.getText()).intValue());
    }*/
  }

  private void setCancelled(boolean b) {
    this.cancelled = b;
  }

  public String getReportName() {
    return txtReportName.getText();
  }

  public String getClassName() {
    return txtDriverName.getText();
  }

  public String getLocalUrl() {
    return txtUrl.getText();
  }

  public String getUser() {
    return txtUser.getText();
  }

  public char[] getPassword() {
    return pswPassword.getPassword();
  }

  public String getSqlText() {
    return txtQuery.getText();
  }

  public int getMetricStartPosition() {
    return Integer.valueOf(txtMetricStart.getText()).intValue();
  }

}
