package com.calipso.reportgenerator.javabeans;

import es.indra.mare.common.info.InfoException;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.beans.Customizer;
import java.awt.TextField;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;
import java.awt.event.ActionEvent;
import java.awt.event.TextEvent;

/**
 * Representa el Customizer del Bean de la aplicacion.
 */

public class ReportBeanCustomizer extends Panel implements Customizer, TextListener, ActionListener {

  private ReportBean source;
  private TextField configPath;
  private TextField userId;
  private TextField reportDefinitionId;
  private TextField reportViewId;
  private TextField propertiesPath;
  private JButton button;

  public ReportBeanCustomizer() {
    initialize();
  }

  /**
   * Inicializa los componentes del Customizer
   */
  private void initialize() {
    Panel mainPanel = new Panel(new GridLayout(5, 2));
    JLabel label = new JLabel("ConfigurationPath: ");
    mainPanel.add(label);
    configPath = new TextField();
    mainPanel.add(configPath);
    label = new JLabel("UserId: ");
    mainPanel.add(label);
    userId = new TextField();
    mainPanel.add(userId);
    label = new JLabel("ReportDefinitionId: ");
    mainPanel.add(label);
    reportDefinitionId = new TextField();
    mainPanel.add(reportDefinitionId);
    label = new JLabel("ReportViewId: ");
    mainPanel.add(label);
    reportViewId = new TextField();
    mainPanel.add(reportViewId);
    label = new JLabel("PropertiesPath: ");
    mainPanel.add(label);
    propertiesPath = new TextField();
    mainPanel.add(propertiesPath);
    button = new JButton("Ejecutar");
    mainPanel.add(button);
    button.addActionListener(this);
    add(mainPanel);
  }

  /**
   * Metodo que se ejecuta al invocar al Customizer
   * desde el BeanBox
   * @param bean
   */
  public void setObject(Object bean) {
    source = (ReportBean) bean;
    userId.setText(source.getUserId());
    reportDefinitionId.setText(source.getReportDefinitionId());
    reportViewId.setText(source.getReportViewId());
    propertiesPath.setText(source.getPropertiesPath());
    configPath.setText(source.getConfigPath());
  }

  /**
   * Evento que detecta cuando cambia el estado
   * de algun parametro del Customizer
   * @param e
   */
  public void textValueChanged(TextEvent e) {
    TextField tf = (TextField) e.getSource();
    if (tf == userId) {
      source.setUserId(userId.getText());
    } else if(tf == reportDefinitionId) {
      source.setReportDefinitionId(reportDefinitionId.getText());
    } else if(tf == reportViewId) {
      source.setReportViewId(reportViewId.getText());
    } else if(tf == propertiesPath) {
      source.setPropertiesPath(propertiesPath.getText());
    } else if(tf == configPath) {
      source.setConfigPath(configPath.getText());
    }
  }

  public void actionPerformed(ActionEvent e) {
    try {
      source.executeApp();
    } catch (InfoException e1) {
      e1.printStackTrace();
    }
  }
}
