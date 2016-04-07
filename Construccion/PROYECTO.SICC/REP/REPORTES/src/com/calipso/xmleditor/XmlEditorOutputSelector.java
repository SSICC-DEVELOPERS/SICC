package com.calipso.xmleditor;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: 06-oct-2003
 * Time: 15:12:55
 * To change this template use Options | File Templates.
 */

//No utilizada
public class XmlEditorOutputSelector extends JDialog implements ActionListener {

  private JButton btAccept;
  private JButton btCancel;
  private DefaultTreeModel model;
  private JTextField field;

  public XmlEditorOutputSelector(Frame owner, boolean modal, DefaultTreeModel model) throws HeadlessException {
    super(owner, modal);
    setTitle("Path destino");
    this.model = model;
    initialize();
  }

  private void initialize() {
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(createCenterPanel(), BorderLayout.CENTER);
    getContentPane().add(createSouthPanel(), BorderLayout.SOUTH);
    setWindowLocation();
    pack();
    setVisible(true);
  }

  private void setWindowLocation() {
    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setLocation((screenSize.width - getPreferredSize().width) / 2, (screenSize.height - getPreferredSize().height) / 2);
  }

  private JPanel createSouthPanel() {
    GridBagLayout bagLayout = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();
    JPanel panel = new JPanel(bagLayout);

    btAccept = new JButton("Aceptar");
    btAccept.addActionListener(this);
    panel.add(btAccept);
    constraints.weightx = 30;
    constraints.weighty = 1;
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.anchor = GridBagConstraints.EAST;
    constraints.fill = GridBagConstraints.PAGE_START;
    bagLayout.setConstraints(btAccept, constraints);

    btCancel = new JButton("Cancelar");
    btCancel.addActionListener(this);
    panel.add(btCancel);
    constraints.weightx = 1;
    constraints.weighty = 1;
    constraints.gridx = 1;
    constraints.gridy = 0;
    constraints.anchor = GridBagConstraints.EAST;
    constraints.fill = GridBagConstraints.HORIZONTAL;
    bagLayout.setConstraints(btCancel, constraints);

    return panel;
  }

  private JPanel createCenterPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());
    field = new JTextField(20);
    panel.add(field);
    return panel;
  }

  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == btAccept) {
      try{
        XmlEditorXmlGenerator.generateFrom(model, field.getText());
      }catch(XmlEditorException ex){
        ((XmlEditorUI)getOwner()).showException(ex);
      }
      dispose();
    } else if(e.getSource() == btCancel) {
      dispose();
    }
  }
}
