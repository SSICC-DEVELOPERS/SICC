package es.indra.sicc.util;

import es.indra.mare.common.exception.MareException;

import java.util.*;


/**
 * <p>Title: ExcepcionParametrizada</p>
 * <p>Description: Extiende MareException para poder parametrizar el mensaje de error</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Indra</p>
 * @author Gonzalo Herreros González
 * @version 1.0
 */
public class ExcepcionParametrizada extends MareException {
   public static final byte POSICION_INICIAL = 0; //Delante del mensaje de error
   public static final byte POSICION_FINAL = 1; //Detrás del mensaje de error
   public static final byte POSICION_MEDIO = 2; //Intercalado dentro del mensaje de error como en C#
   private byte posicion = POSICION_FINAL; //Por defecto anexamos al final
   private List parametros = new ArrayList();

   /**
    * Constructor
    *
    * @param message exception description
    */
   public ExcepcionParametrizada(String message) {
      super(message);
   }

   /**
    * Constructor
    *
    * @param cause wrapped original exception
    */
   public ExcepcionParametrizada(Throwable cause) {
      super(cause);
   }

   /**
    * Constructor
    *
    * @param message exception description
    * @param cause wrapped original exception
    */
   public ExcepcionParametrizada(String message, Throwable cause) {
      super(message, cause);
   }

   /**
    * Constructor
    *
    * @param message exception description
    * @param code error code
    */
   public ExcepcionParametrizada(String message, int code) {
      super(message, code);
   }

   /**
    * Constructor
    *
    * @param cause wrapped original exception
    * @param code error code
    */
   public ExcepcionParametrizada(Throwable cause, int code) {
      super(cause, code);
   }

   /**
    * Constructor
    *
    * @param message exception description
    * @param cause wrapped original exception
    * @param code error code
    */
   public ExcepcionParametrizada(String message, Throwable cause, int code) {
      super(message, cause, code);
   }

   /** Añade un parametro a la excepcion
    * Para añadir varios parametros la posicion elegida debe ser "medio"
    * @param param
    */
   public void addParameter(String param) {
      if ((parametros.size() > 0) && (posicion != POSICION_MEDIO)) {
         throw new IllegalArgumentException(
            "Para añadir más de un parametro se debe configuar la posicion medio");
      }

      parametros.add(param);
   }

   /** Devuelve la posicion que está configurada para los parametros
    * @return
    */
   public byte getPosicion() {
      return posicion;
   }

   /** Configura la posicion de los parametros dentro del mensaje de error
    * Puede ser: inicio si se pone delante del error, final si se concatena detras del error
    *  y medio si se sustituye dentro del error el patrón "{n}" donde n es el número de parametro.
    * @param b
    */
   public void setPosicion(byte b) {
      if ((b != POSICION_INICIAL) && (b != POSICION_FINAL) &&
             (b != POSICION_MEDIO)) {
         throw new IllegalArgumentException(
            "Se ha especificado una posicion no válida");
      }

      if ((b != POSICION_MEDIO) && (parametros.size() > 1)) {
         throw new IllegalArgumentException(
            "Se ha configurado más de un parametro, por tanto la posicion debe ser medio");
      }

      posicion = b;
   }

   /** Recibe el mensaje de error y los devuelve parametrizado
    * @param mensajeError
    * @return
    */
   public String obtenerErrorParametrizado(String mensajeError) {
      String parametroSimple = "";

      if (parametros.size() > 0) {
         parametroSimple = (String) parametros.get(0);
      }

      if (posicion == POSICION_INICIAL) {
         return parametroSimple + mensajeError;
      } else if (posicion == POSICION_FINAL) {
         return mensajeError + parametroSimple;
      } else if (posicion == POSICION_MEDIO) {
         String[] cadParametros = new String[parametros.size()];

         try {
            Object o = parametros.toArray(cadParametros);
            cadParametros = (String[]) o;
         } catch (Exception en) {
            UtilidadesLog.error(en);
         }

         return formateaCadenaParametros(mensajeError, cadParametros);
      } else {
         return mensajeError;
      }
   }

   /** Recibe una cadena con expresiones "{n}" y sustituye las expresiones por el parametro n
      *  obteniendolo del arrary de parametros (el primer parametro es el 0).
      *  Devuelve la cadena formateada con todos los parametros que ha podido sustituir
    * @param cadena
    * @param parametros
    * @return
    */
   private String formateaCadenaParametros(String cadena, String[] parametros) {
      if ((parametros == null) || (cadena == null)) {
         return cadena;
      }

      int pos = -1;
      String prefix;
      String postfix;
      String pattern;

      for (int i = 0; i < parametros.length; i++) {
         pos = cadena.indexOf("{" + i + "}");

         if (pos != -1) {
            pattern = "{" + i + "}";
            prefix = cadena.substring(0, pos);
            postfix = cadena.substring(pos + pattern.length(), cadena.length());
            cadena = prefix + parametros[i] + postfix;
         }
      }

      return cadena;
   }
}
