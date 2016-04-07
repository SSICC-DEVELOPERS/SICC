package com.calipso.xmleditor;

import javax.swing.*;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: jbassino
 * Date: 25/06/2004
 * Time: 14:08:17
 * To change this template use Options | File Templates.
 */
public class XmlEditorMenu extends JMenuBar implements ActionListener, MenuListener {

  private static final int LIMIT = 20;
  private static final String defaultEmpty = "empty...";

  private JMenuItem mnuItemNewFromXSD;
  private JMenuItem mnuItemLoadFromXSD;
  private JMenuItem mnuItemLoadJustXML;
  private JMenuItem mnuItemLoadXSD;
  private JMenuItem mnuUnloadXSD;
  private JMenuItem mnuItemGenerateReportFromSQL;
  private JMenuItem mnuCheckParametersRSD;
  private JMenuItem mnuCheckParametersRSDErrors;
  private JMenuItem mnuItemGenerateReportLayout;
  private JMenu mnuRecentXml;
  private JMenu mnuRecentXsd;
  private LinkedList listRecentXml = new LinkedList();
  private LinkedList listRecentXsd = new LinkedList();
  private XmlEditorUI xmlEditorUI;
  private JMenuItem mnuItemSave;
  private JMenuItem mnuItemSaveAs;
  private JMenuItem mnuItemGenerateReportView;
    private JMenuItem mnuCheckAllReports;
    private JMenuItem mnuCheckReport;


    /**
   * Crea el menu superior de la aplicacion.
   * @param ui
   */
  public XmlEditorMenu(XmlEditorUI ui) {
    xmlEditorUI = ui;
    JMenu mnuFile = new JMenu("Archivo");
    JMenu mnuNew = new JMenu("Nuevo");
    JMenu mnuLoad = new JMenu("Cargar");
    JMenu mnuLoadXml = new JMenu("XML");
    JMenu mnuCreateXml = new JMenu("Generar XML");
    JMenu mnuChecks = new JMenu("Verificaciones");
    JMenu mnuRecent = new JMenu("Recientes");
    mnuRecentXml = new JMenu("Recientes XML");
    mnuRecentXsd = new JMenu("Recientes XSD");
    mnuRecent.add(mnuRecentXml);
    mnuRecent.add(mnuRecentXsd);
    mnuRecentXml.addMenuListener(this);
    mnuRecentXsd.addMenuListener(this);

    mnuItemNewFromXSD = new JMenuItem("Nuevo desde actual XSD");
    mnuItemNewFromXSD.addActionListener(this);
    mnuNew.add(mnuItemNewFromXSD);

    mnuItemLoadFromXSD = new JMenuItem("Usar xsd");
    mnuItemLoadFromXSD.addActionListener(this);
    mnuLoadXml.add(mnuItemLoadFromXSD);

    mnuItemLoadJustXML = new JMenuItem("No usar xsd");
    mnuItemLoadJustXML.addActionListener(this);
    mnuLoadXml.add(mnuItemLoadJustXML);

    mnuLoad.add(mnuLoadXml);

    mnuItemLoadXSD = new JMenuItem("XSD");
    mnuItemLoadXSD.addActionListener(this);
    mnuLoad.add(mnuItemLoadXSD);

    mnuLoad.add(mnuRecent);

    mnuItemGenerateReportFromSQL = new JMenuItem("Crear Reporte desde SQL");
    mnuItemGenerateReportFromSQL.addActionListener(this);
    mnuCreateXml.add(mnuItemGenerateReportFromSQL);

    mnuItemGenerateReportView = new JMenuItem("Crear ReportView de ReportDefinition");
    mnuItemGenerateReportView.addActionListener(this);
    mnuCreateXml.add(mnuItemGenerateReportView);

    mnuItemGenerateReportLayout = new JMenuItem("Generar ReportLayout");
    mnuItemGenerateReportLayout.addActionListener(this);
    mnuCreateXml.add(mnuItemGenerateReportLayout);
    mnuCreateXml.setMnemonic("g".charAt(0));

    mnuItemSave = new JMenuItem("Guardar XML");
    mnuItemSave.addActionListener(this);

    mnuItemSaveAs = new JMenuItem("Guardar como XML");
    mnuItemSaveAs.addActionListener(this);

    mnuUnloadXSD = new JMenuItem("Descargar xsd");
    mnuUnloadXSD.addActionListener(this);

    mnuCheckParametersRSD = new JMenuItem("Verificar parametros en RSD");
    mnuCheckParametersRSD.addActionListener(this);
    mnuChecks.add(mnuCheckParametersRSD);

    mnuCheckParametersRSDErrors = new JMenuItem("Verificar parametros en RSD, solo errores");
    mnuCheckParametersRSDErrors.addActionListener(this);
    mnuChecks.add(mnuCheckParametersRSDErrors);

    mnuCheckAllReports = new JMenuItem("Verificar todos los reportes");
    mnuCheckAllReports.addActionListener(this);
    mnuChecks.add(mnuCheckAllReports);

    mnuCheckReport = new JMenuItem("Verificar reporte");
    mnuCheckReport.addActionListener(this);
    mnuChecks.add(mnuCheckReport);

    mnuFile.add(mnuNew);
    mnuFile.add(mnuLoad);
    mnuFile.add(mnuUnloadXSD);
    mnuFile.add(mnuItemSave);
    mnuFile.add(mnuItemSaveAs);
    mnuFile.setMnemonic("a".charAt(0));

    add(mnuFile);
    add(mnuCreateXml);
    add(mnuChecks);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == mnuItemLoadFromXSD) {
      getXmlEditorUI().loadFromXml(false,"");
    }else if (e.getSource() == mnuItemLoadJustXML) {
      getXmlEditorUI().loadFromXml(true,"");
    }else if (e.getSource() == mnuItemLoadXSD) {
      getXmlEditorUI().loadFromXsd();
    }else if (e.getSource() == mnuItemGenerateReportFromSQL) {
      getXmlEditorUI().getParametersFromPane();
    }else if (e.getSource() == mnuItemGenerateReportView){
      getXmlEditorUI().generateReportView();
    }else if (e.getSource() == mnuItemGenerateReportLayout) {
      getXmlEditorUI().generateReportLayout();
    }else if (e.getSource() == mnuItemSave){
      getXmlEditorUI().save(true);
    }else if (e.getSource() == mnuUnloadXSD){
      getXmlEditorUI().unLoadxsd();
    }else if (e.getSource() == mnuItemSaveAs){
      getXmlEditorUI().save(false);
    }else if (e.getSource() == mnuCheckParametersRSD){
      getXmlEditorUI().checkParametersRSDs(false);
    }else if (e.getSource() == mnuCheckParametersRSDErrors){
      getXmlEditorUI().checkParametersRSDs(true);
    }else if (e.getSource() == mnuCheckAllReports){
      getXmlEditorUI().checkAllReports();
    }else if (e.getSource() == mnuCheckReport){
      getXmlEditorUI().checkReport("EMPTY","RD_REP-135");
    }else if (isRecentMenu(e.getSource())) {
      getXmlEditorUI().openRecent(((JMenuItem) e.getSource()).getName());
    }
  }

  public XmlEditorUI getXmlEditorUI() {
    return xmlEditorUI;
  }

  public void setXmlEditorUI(XmlEditorUI xmlEditorUI) {
    this.xmlEditorUI = xmlEditorUI;
  }

  public void menuSelected(MenuEvent e) {
    if (e.getSource() == mnuRecentXml) {
      addMenuItems(mnuRecentXml, listRecentXml);
      listRecentXml = new LinkedList();
    }
    else
      if (e.getSource() == mnuRecentXsd) {
        addMenuItems(mnuRecentXsd, listRecentXsd);
        listRecentXsd = new LinkedList();
      }
  }

  /**
   * Agrega los items de la lista al menu
   * @param menu
   * @param list
   */
  private void addMenuItems(JMenu menu, LinkedList list) {
    if (list.isEmpty() && menu.getMenuComponents().length == 0) {
      JMenuItem empty = new JMenuItem(defaultEmpty);
      empty.setName(defaultEmpty);
      menu.add(empty);
    } else {
      if (!list.isEmpty()) {
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
          String s = (String) iterator.next();
          if(!hasItem(menu, s)){
            JMenuItem item = new JMenuItem(getNameFor(s));
            item.setName(s);
            item.addActionListener(this);
            menu.add(item);
          }
        }
      }
      if (menu.getMenuComponents().length > 1 && menu.getMenuComponents()[0].getName().equalsIgnoreCase(defaultEmpty)) {
        menu.remove(0);
      }
    }
  }

  /**
   * Verifica si el menu contiene algun item con nombre igual al parametro s.
   * @param menu
   * @param s
   * @return
   */
  private boolean hasItem(JMenu menu, String s) {
    Component[] components = menu.getMenuComponents();
    for(int i=0; i<components.length; i++){
      if(components[i].getName()==s){
        return true;
      }
    }
    return false;
  }

  /**
   * Verifica si el source de una accion pertenece a alguno de los menus de objetos utilizados recientemente
   * @param source
   * @return
   */
  private boolean isRecentMenu(Object source) {
    if (!doIsRecentMenu(mnuRecentXml, source)) {
      return doIsRecentMenu(mnuRecentXsd, source);
    }
    return true;
  }

  /**
   * Verifica si el source de un evento pertenece al menu especificado
   * @param menu
   * @param source
   * @return
   */
  private boolean doIsRecentMenu(JMenu menu, Object source) {
    Component[] array = menu.getMenuComponents();
    String name = ((JMenuItem) source).getName();
    for (int i = 0; i < array.length; i++) {
      if (array[i].getName().equalsIgnoreCase(name)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Obtiene un nombre para menu a partir de un path
   * @param s
   * @return
   */
  private String getNameFor(String s) {
    int index = Math.max(s.lastIndexOf("\\"), s.lastIndexOf("/"));
    return s.substring(index + 1).trim();
  }

  public void menuDeselected(MenuEvent e) {
  }

  public void menuCanceled(MenuEvent e) {
  }

  /**
   * Agrega el parametro a la lista de XSDs seleccionados recientemente
   * @param file
   */
  public void addXsdRecentItem(String file) {
    addItem(listRecentXsd,file);
  }

  /**
   * Agrega el parametro a la lista de XMLs seleccionados recientemente
   * @param file
   */
  public void addXmlRecentItem(String file) {
    addItem(listRecentXml, file);
  }

  /**
   * Agrega el objeto a la lista verificando que no halla llegado al tope de items y que no sea un item repetido
   * @param list
   * @param path
   */
  private void addItem(LinkedList list, String path) {
    if(!list.contains(path)){
      if(list.size() < LIMIT){
        list.addLast(path);
      }
    }
  }

}
