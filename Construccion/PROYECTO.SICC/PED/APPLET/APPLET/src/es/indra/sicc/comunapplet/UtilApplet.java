package es.indra.sicc.comunapplet;

import es.indra.sicc.comunapplet.exceptions.AppletException;
import java.awt.Component;

import java.util.Properties;

public class UtilApplet {

  public static void procesarError(Exception e, Component c){
    AppletException me;
    int code;
    Properties prop;
    String message;
    String title;

    if(e != null){
      if(e instanceof AppletException){ 
        me = (AppletException)e;
        code = me.getCode();

        //se asigna el bundle por defecto
        //PropertiesApplet.setProperties();
        title = PropertiesApplet.getPropertie(ConstantesApplet.TITULO_ERROR, ConstantesBundlesApplet.APPLET_MENSAJES_BUNDLE);

        //Si el mensaje fué seteado por el Servlet
        if(code == -1 ||
          (me.getMessage() != null && !"".equals(me.getMessage().trim()))) {
          message = me.getMessage();
        }else{
          //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_ERRORS_BUNDLE);
          message = PropertiesApplet.getPropertie(code, ConstantesBundlesApplet.APPLET_ERRORS_BUNDLE);
        }
        //System.out.println("Mensaje: " + message);
        if( message == null ){
          PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_MENSAJES_BUNDLE);
          message = PropertiesApplet.getPropertie(code, ConstantesBundlesApplet.APPLET_MENSAJES_BUNDLE);
          if (message != null) {
            Dialogos.mensajeError(title, message, c);  
          }
          //Dialogos.mensajeError(  );
          //JOptionPane.showMessageDialog( (Component)this.getView(), ConstantesNDG.NDG_ERROR_NO_DOCUMENTADO, ConstantesNDG.NDG_TITULO_MENSAJE_ERROR, JOptionPane.ERROR_MESSAGE );
        }else{
          Dialogos.mensajeError(title, message, c);
          //JOptionPane.showMessageDialog( (Component)this.getView(), message, ConstantesNDG.NDG_TITULO_MENSAJE_ERROR, JOptionPane.ERROR_MESSAGE );
        }
      }
    }
  }
} 