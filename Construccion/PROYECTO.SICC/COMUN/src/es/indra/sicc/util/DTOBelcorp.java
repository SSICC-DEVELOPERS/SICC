/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.util;

import es.indra.mare.common.dto.BaseDruidaDTO;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Sistema:           Belcorp
 * Modulo:            COMUN
 * Componente:        DTOBelcorp
 * Fecha:             12/03/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-MAE-005-210
 *                    MAE Paquete Configuración  Maestro de Clientes
 *                    (Subido al portal el 06/03/2003)
 * Descripcion:       DTOBelcorp
 * @version           1.0
 * @autor             Verónica Iturrioz
 */
public class DTOBelcorp extends BaseDruidaDTO {
   /**
    * Agregado según las modificaciones en la versión 319 de SEG
    */
   private Long oidPais;
   private Long oidIdioma;

   public DTOBelcorp() {
      super();
   }

   /**
    *
    * @param atributo: Representa el nombre del atributo a localizar
    * @exception NoSuchElementException si no se encuentra el método get asociado
    * a atributo
    * @return Realiza mediante introspección (java.lang.reflect) la localización del
    * método get correspondiente al nombre del atributo pasado por parámetro
    * atributo y lo ejecuta devolviendo su valor.
    */
   private Object getObject(String atributo) throws NoSuchElementException {
      // arma el nombre del método get...() que se debe invocar
      String beginChar = atributo.substring(0, 1).toUpperCase();
      String restString = atributo.substring(1);
      String methodName = "get" + beginChar + restString;
      Method method = null;
      Class[] params = {  };

      try {
         method = this.getClass().getDeclaredMethod(methodName, params);
      } catch (Exception e) {
         // no se encuentra el método get o no se tiene acceso permitido 
         String salida = "Se produjo la excepcion " + e.getMessage() + "\n" +
            getStackTrace(e) + "\n" + "atributo = " + atributo;
         UtilidadesLog.debug("Se produjo la excepcion " + e.getMessage() + "\n" +
            getStackTrace(e) + "\n" + "atributo = " + atributo);
         throw new NoSuchElementException(salida);
      }

      Object[] args = {  };
      Object objectResult = null;

      try {
         objectResult = method.invoke(this, args);
      } catch (Exception ie) {
         UtilidadesLog.debug("Se produjo la excepcion " + ie.getMessage() +
            "\n" + getStackTrace(ie) + "\n" + "atributo = " + atributo);
         UtilidadesLog.debug(ie.getMessage());
      }

      return objectResult;
   }

   private String getStackTrace(Exception e) {
      ByteArrayOutputStream os = new ByteArrayOutputStream();
      PrintStream ps = new PrintStream(os);
      UtilidadesLog.debug(ps);
      return new String(os.toByteArray());
   }

   /**
    * @param atributo:Nombre del atributo al que se quiere asignar el valor.
    *        valor: valor a asignar a atributo
    * @exception NoSuchElementException si no se encuentra el método set asociado
    * a atributo
    * @return
    * Realiza mediante introspección la localización del método set correspondiente
    * al nombre del atributo pasado por parámetro y lo ejecuta estableciendo así
    * su valor.
    */
   private void setObject(String atributo, Object valor)
      throws NoSuchElementException {
      // arma el nombre del método set...() que se debe invocar
      String beginChar = atributo.substring(0, 1).toUpperCase();
      String restString = atributo.substring(1);
      String methodName = "set" + beginChar + restString;
      Method method = null;
      Class[] params = { valor.getClass() };

      try {
         method = this.getClass().getDeclaredMethod(methodName, params);
      } catch (Exception e) {
         // no se encuentra el método set o no se tiene acceso permitido 
         throw new NoSuchElementException();
      }

      Object[] args = { valor };

      try {
         method.invoke(this, args);
      } catch (Exception ie) {
         UtilidadesLog.debug(ie.getMessage());
      }
   }

   public java.sql.Date getDate(String key)
      throws ClassCastException, NoSuchElementException {
      return (Date) this.getObject(key);
   }

   public Date getDate(String key, Date defaultValue) throws ClassCastException {
      try {
         return (Date) this.getObject(key);
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   public Timestamp getTimestamp(String key)
      throws ClassCastException, NoSuchElementException {
      return (Timestamp) this.getObject(key);
   }

   public Timestamp getTimestamp(String key, Timestamp defaultValue)
      throws ClassCastException {
      try {
         return (Timestamp) this.getObject(key);
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   /**
    * Realiza la invocación al método get correspondiente a la propiedad
    * con el valor del parámetro de key.
    * Si la propiedad no existe, eleva NoSuchElementException
    */
   public RecordSet getTable(String key)
      throws ClassCastException, NoSuchElementException {
      return (RecordSet) this.getObject(key);
   }

   /**
    * Realiza la invocación al método get correspondiente a la propiedad
    * con el valor del parámetro de key, si dicha propiedad existe.
    * Si no existe retorna el valor default pasado por parámetro
    */
   public RecordSet getTable(String key, RecordSet defaultValue)
      throws ClassCastException {
      try {
         return (RecordSet) this.getObject(key);
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   /**
    * @param key: atributo del dto
    *        value: valor a asignar al atributo key
    * @return asigna el valor de value al atributo determinado por key
    */
   public void addProperty(String key, Object value) {
      // arma el nombre del método set...() que se debe invocar
      String beginChar = key.substring(0, 1).toUpperCase();
      String restString = key.substring(1);
      String methodName = "set" + beginChar + restString;
      Method method = null;
      Class[] params = { value.getClass() };

      try {
         method = this.getClass().getDeclaredMethod(methodName, params);

         Object[] args = { value };
         method.invoke(this, args);
      } catch (Exception e) {
         // no se encuentra el método set o no se tiene acceso permitido 
         UtilidadesLog.debug("No existe " + e.getMessage());
      }
   }

   /**
    * @param key: atributo del dto
    *        value: valor a asignar al atributo key
    * @return asigna el valor de value al atributo determinado por key
    */
   public void addProperty(Object key, Object value) {
      // arma el nombre del método set...() que se debe invocar
      String beginChar = key.toString().substring(0, 1).toUpperCase();
      String restString = key.toString().substring(1);
      String methodName = "set" + beginChar + restString;
      Method method = null;
      Class[] params = { value.getClass() };

      try {
         method = this.getClass().getDeclaredMethod(methodName, params);

         Object[] args = { value };
         method.invoke(this, args);
      } catch (Exception e) {
         // no se encuentra el método set o no se tiene acceso permitido 
         UtilidadesLog.debug("No existe " + e.getMessage());
      }
   }

   /**
    * @param String key: determina el atributo que se debe limpiar
    * @return asigna null al atributo determinado por key
    */
   public void clearProperty(String key) {
      String beginChar = key.substring(0, 1).toUpperCase();
      String restString = key.substring(1);
      String methodName = "set" + beginChar + restString;

      Method[] methods = this.getClass().getDeclaredMethods();
      int i = 0;
      boolean find = false;
      Method method = null;

      while ((i < methods.length) && (!find)) {
         method = methods[i];

         if (method.getName().equalsIgnoreCase(methodName)) {
            find = true;
         }

         i = i + 1;
      }

      if (find) {
         Object[] args = { null };

         try {
            method.invoke(this, args);
         } catch (Exception e) {
            UtilidadesLog.debug(e.getMessage());
         }
      } else {
         UtilidadesLog.debug("No existe el atributo " + key);
      }
   }

   /**
    * @param String key: determina el atributo del dto que se debe limpiar
    * @return asigna null al atributo determinado por key
    */
   public void clearProperty(Object key) {
      String beginChar = key.toString().substring(0, 1).toUpperCase();
      String restString = key.toString().substring(1);
      String methodName = "set" + beginChar + restString;

      Method[] methods = this.getClass().getDeclaredMethods();
      int i = 0;
      boolean find = false;
      Method method = null;

      while ((i < methods.length) && (!find)) {
         method = methods[i];

         if (method.getName().equalsIgnoreCase(methodName)) {
            find = true;
         }

         i = i + 1;
      }

      if (find) {
         Object[] args = { null };

         try {
            method.invoke(this, args);
         } catch (Exception e) {
            UtilidadesLog.debug(e.getMessage());
         }
      } else {
         UtilidadesLog.debug("No existe el atributo " + key.toString());
      }
   }

   /**
    * Retorna true si existe en el dto un atributo con el valor del parametro  key
    */
   public boolean containsKey(String key) {
      try {
         Field field = this.getClass().getDeclaredField(key);

         return true;
      } catch (NoSuchFieldException e) {
         return false;
      }
   }

   public boolean containsKey(Object key) {
      try {
         Field field = this.getClass().getDeclaredField(key.toString());

         return true;
      } catch (NoSuchFieldException e) {
         return false;
      }
   }

   public boolean getBoolean(String key)
      throws ClassCastException, NoSuchElementException {
      return (((Boolean) this.getObject(key)).booleanValue());
   }

   public boolean getBoolean(String key, boolean defaultValue)
      throws ClassCastException {
      try {
         return (((Boolean) this.getObject(key)).booleanValue());
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   public Boolean getBoolean(String key, Boolean defaultValue)
      throws ClassCastException {
      try {
         return (Boolean) this.getObject(key);
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   public byte getByte(String key)
      throws ClassCastException, NoSuchElementException {
      return (((Byte) this.getObject(key)).byteValue());
   }

   public byte getByte(String key, byte defaultValue) throws ClassCastException {
      try {
         return (((Byte) this.getObject(key)).byteValue());
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   public Byte getByte(String key, Byte defaultValue) throws ClassCastException {
      try {
         return ((Byte) this.getObject(key));
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   public double getDouble(String key)
      throws ClassCastException, NoSuchElementException {
      return (((Double) this.getObject(key)).doubleValue());
   }

   public double getDouble(String key, double defaultValue)
      throws ClassCastException {
      try {
         return (((Double) this.getObject(key)).doubleValue());
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   public Double getDouble(String key, Double defaultValue)
      throws ClassCastException {
      try {
         return ((Double) this.getObject(key));
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   public float getFloat(String key)
      throws ClassCastException, NoSuchElementException {
      return (((Float) this.getObject(key)).floatValue());
   }

   public float geFloat(String key, float defaultValue)
      throws ClassCastException {
      try {
         return (((Float) this.getObject(key)).floatValue());
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   public Float getFloat(String key, Float defaultValue)
      throws ClassCastException {
      try {
         return ((Float) this.getObject(key));
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   public int getInt(String key)
      throws ClassCastException, NoSuchElementException {
      return (((Integer) this.getObject(key)).intValue());
   }

   public int getInt(String key, int defaultValue) throws ClassCastException {
      try {
         return (((Integer) this.getObject(key)).intValue());
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   public Integer getInteger(String key, Integer defaultValue)
      throws ClassCastException {
      try {
         return ((Integer) this.getObject(key));
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   /**
    * Retorna los nombres de los atributos del dto
    */
   public Iterator getKeys() {
      Field[] fields = this.getClass().getDeclaredFields();
      Collection fieldsNames = new ArrayList();

      for (int i = 0; i < fields.length; i++) {
         fieldsNames.add(fields[i].getName());
      }

      return fieldsNames.iterator();
   }

   /**
    * Retorna los nombres de los atributos del dto que comienzan con el prefijo
    * con el valor del parámetro prefix
    */
   public Iterator getKeys(String prefix) {
      Field[] fields = this.getClass().getDeclaredFields();
      Collection fieldsNames = new ArrayList();

      for (int i = 0; i < fields.length; i++) {
         if (fields[i].getName().startsWith(prefix)) {
            fieldsNames.add(fields[i].getName());
         }
      }

      return fieldsNames.iterator();
   }

   public long getLong(String key)
      throws ClassCastException, NoSuchElementException {
      return (((Long) this.getObject(key)).longValue());
   }

   public long getLong(String key, long defaultValue) throws ClassCastException {
      try {
         return (((Long) this.getObject(key)).longValue());
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   public Long getLong(String key, Long defaultValue) throws ClassCastException {
      try {
         return (Long) this.getObject(key);
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   public short getShort(String key)
      throws ClassCastException, NoSuchElementException {
      return (((Short) this.getObject(key)).shortValue());
   }

   public short getShort(String key, short defaultValue)
      throws ClassCastException {
      try {
         return (((Short) this.getObject(key)).shortValue());
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   public Short getShort(String key, Short defaultValue)
      throws ClassCastException {
      try {
         return (Short) this.getObject(key);
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   public String getString(String key) throws ClassCastException {
      return (String) this.getObject(key);
   }

   public String getString(String key, String defaultValue)
      throws ClassCastException {
      try {
         return (String) this.getObject(key);
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   /**
    * Invoca al método set de la propiedad llamda con el valor del parámetro key
    * y le pasa value como parámetro
    */
   public void setProperty(String key, Object value) {
      this.setObject(key, value);
   }

   /**
    * @param key: atributo del dto
    * @exception NoSuchElementException si no existe el atributo key en el dto
    * @return retorna el valor del atributo key
    */
   public Object getProperty(Object key) throws NoSuchElementException {
      return this.getObject(key.toString());
   }

   /**
    * @param key: atributo del dto
    *        defaultValue: si no existe el atributo key, se retorna defaultValue
    * @return retorna el valor del atributo key si existe, sino se retorna
    * defaultValue
    */
   public Object getProperty(Object key, Object defaultValue) {
      try {
         return this.getObject(key.toString());
      } catch (NoSuchElementException e) {
         return defaultValue;
      }
   }

   /**
    * @param key: atributo del dto
    * @exception NoSuchElementException si no existe el atributo key
    * @return devuelve el valor del atributo key y luego le asigna el valor null
    */
   public Object getAndRemoveProperty(Object key) throws NoSuchElementException {
      Object objectResult = this.getProperty(key);
      this.clearProperty(key);

      return objectResult;
   }

   /**
    * @param key: atributo del dto
    *        defaultValue: si no existe el atributo key, se retorna defaultValue
    * @return devuelve el valor del atributo key y luego le asigna el valor null,
    *         si existe. Sino existe se devuelve defaultValue.
    */
   public Object getAndRemoveProperty(Object key, Object defaultValue) {
      Object objectResult = this.getProperty(key, defaultValue);
      this.clearProperty(key);

      return objectResult;
   }

   /**
    * @return retorna los nombres de los atributos = valor :
    *
    */
   public String dumpToString() {
      StringBuffer result = new StringBuffer();
      Iterator it = getKeys();

      for (; it.hasNext();) {
         Object o = it.next();
         result.append(o + "=" + getProperty(o) + " : ");
      }

      return result.toString().substring(0, result.toString().length() - 3);
   }

   public Long getOidIdioma() {
      return oidIdioma;
   }

   public void setOidIdioma(Long newOidIdioma) {
      oidIdioma = newOidIdioma;
   }

   public Long getOidPais() {
      return oidPais;
   }

   public void setOidPais(Long newOidPais) {
      oidPais = newOidPais;
   }
}
