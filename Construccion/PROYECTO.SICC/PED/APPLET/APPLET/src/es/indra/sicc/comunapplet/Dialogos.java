package es.indra.sicc.comunapplet;

import es.indra.sicc.comunapplet.ConstantesApplet;
import es.indra.sicc.comunapplet.PropertiesApplet;

import java.awt.Component;

import javax.swing.JOptionPane;
//import es.indra.sicc.ped.applet.properties.PropertiesApplet;

public final class Dialogos {

  public static boolean mensajeSINO(int message, Component parent, boolean seleccionar ) 
  { 
    //TODO si es que se puede
     return mensajeSINO(message, parent);
  }
  public static boolean mensajeSINO(int message, Component parent)
  {
    String msg = PropertiesApplet.getPropertie(message, ConstantesBundlesApplet.APPLET_MENSAJES_BUNDLE);
    String titulo = PropertiesApplet.getPropertie(ConstantesApplet.TITULO_CONFIRMACION, ConstantesBundlesApplet.APPLET_MENSAJES_BUNDLE);
    return mensajeSINO(titulo, msg, parent);
  }
  
  public static boolean mensajeSINO(String titulo, String Message, Component parent)
  {
    int i = JOptionPane.showConfirmDialog(parent,Message, titulo, JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);  
    return (i == JOptionPane.YES_OPTION) ? true : false;    
  }
  
  public static int mensajeSINO(String titulo, String Message, Component parent,int icon)
  {
    return JOptionPane.showConfirmDialog(parent,Message, titulo, JOptionPane.YES_NO_OPTION,icon);  
  }
  
  public static void mensajeAceptar(int message, Component parent) 
  {
    String msg = PropertiesApplet.getPropertie(message, ConstantesBundlesApplet.APPLET_MENSAJES_BUNDLE);
    String titulo = PropertiesApplet.getPropertie(ConstantesApplet.TITULO_CONFIRMACION, ConstantesBundlesApplet.APPLET_MENSAJES_BUNDLE);
    mensajeAceptar(titulo, msg, parent);
  }
  
  public static void mensajeAceptar(int message, String anexo, Component parent) 
  {
    String msg = PropertiesApplet.getPropertie(message, ConstantesBundlesApplet.APPLET_MENSAJES_BUNDLE);
    String titulo = PropertiesApplet.getPropertie(ConstantesApplet.TITULO_CONFIRMACION, ConstantesBundlesApplet.APPLET_MENSAJES_BUNDLE);
    mensajeAceptar(titulo, msg + " " + anexo, parent);
  }
  
  public static void mensajeAceptar(String titulo, String Message, Component parent)
  {
    JOptionPane.showMessageDialog(parent,Message, titulo, JOptionPane.PLAIN_MESSAGE);  
  }
  public static void mensajeAceptar(String titulo, String Message, Component parent, int icon)
  {
    JOptionPane.showMessageDialog(parent,Message, titulo, icon);  
  }
  public static void mensajeAlerta(String titulo, String Message, Component parent)
  {
    JOptionPane.showMessageDialog(parent,Message, titulo,JOptionPane.WARNING_MESSAGE);    
  }
  
  public static void mensajeError(int message, Component parent){ 
    //PropertiesApplet.setProperties();
    String titulo = PropertiesApplet.getPropertie(ConstantesApplet.TITULO_ERROR, ConstantesBundlesApplet.APPLET_MENSAJES_BUNDLE);
    String msg = PropertiesApplet.getPropertie(message, ConstantesBundlesApplet.APPLET_MENSAJES_BUNDLE);
    mensajeError(titulo, msg, parent);
  }
  
  public static void mensajeError(int message, String message2, Component parent){ 
    //PropertiesApplet.setProperties();
    String titulo = PropertiesApplet.getPropertie(ConstantesApplet.TITULO_ERROR, ConstantesBundlesApplet.APPLET_MENSAJES_BUNDLE);
    String msg = PropertiesApplet.getPropertie(message, ConstantesBundlesApplet.APPLET_MENSAJES_BUNDLE);
    msg += message2;
    mensajeError(titulo, msg, parent);
  }
  
  public static void mensajeError(String titulo, String Message, Component parent)
  {
    JOptionPane.showMessageDialog(parent,Message, titulo,JOptionPane.ERROR_MESSAGE);    
  }
}