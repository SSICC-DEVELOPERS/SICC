package es.indra.sicc.util;

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mgu.manager.UserIDImpl;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.xml.XMLDocument;

import java.util.HashMap;
import org.jaxen.dom.DOMXPath;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;
import java.text.NumberFormat;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;


public class UtilidadesBelcorp {
   public static final String FORMATO_DEFAULT_HORA_MIN_SEG = "hh:mm:ss";
   public static final String FORMATO_DEFAULT_HORA_MIN = "hh:mm";
   public static final int POSICION_INICIO = 0;
   public static final int POSICION_FINAL = 1;

   public static String recogeCadena(String param) {
      if (param == null) {
         return "";
      } else {
         return param;
      }
   }

   public static void limpiarSession(javax.servlet.http.HttpSession session) {
      java.util.Enumeration variables = session.getAttributeNames();
      String nombre = "";

      while (variables.hasMoreElements()) {
         nombre = (String) variables.nextElement();

         if (!(nombre.equals("credenciales") || nombre.equals("propiedades") ||
                nombre.equals("cdosIdioma"))) {
            session.removeAttribute(nombre);
         }
      }
   }

   /* convierte el resultado de la funcion valorRowset de Druida a un array de
    * javascript con los elementos entre comillas simple
    * recibe el nombre del array de salida y el vector de datos.
    * */
   public static String obtenerStringJS(String nomArray, Vector vElementos) {
      Vector registro = new Vector();
      String campo = null;
      String cadena = "var " + nomArray + " = new Array(";

      for (int i = 0; i < vElementos.size(); i++) {
         registro = (Vector) vElementos.get(i);

         cadena = cadena + "[";

         for (int j = 0; j < registro.size(); j++) {
            if (j != 0) {
               cadena = cadena + ",";
            }

            campo = (String) registro.get(j);
            cadena = cadena + "'" + campo + "'";
         }

         if (i == (vElementos.size() - 1)) {
            cadena = cadena + "]";
         } else {
            cadena = cadena + "],";
         }
      }

      return cadena + ") ;";
   }

   /**
        * Fecha : 17/11/2003
        * Obtiene el IP cliente
        *
        * vbongiov
        * */
   public static synchronized String getIPCliente(DruidaBase lp) {
      return lp.getRequest().getRemoteAddr();
   }

   public static String replace(String s, String s1, String s2) {
      int i = 0;
      int j = 0;
      int k = s1.length();
      StringBuffer stringbuffer = null;
      String s3 = s;

      while ((j = s.indexOf(s1, i)) >= 0) {
         if (stringbuffer == null) {
            stringbuffer = new StringBuffer(s.length() * 2);
         }

         stringbuffer.append(s.substring(i, j));
         stringbuffer.append(s2);
         i = (j + k) - 1;
      }

      if (i != 0) {
         stringbuffer.append(s.substring(i));
         s3 = stringbuffer.toString();
      }

      return s3;
   }

   public static Long StringToLong(String str) throws MareException {
      try {
         return Long.decode(str);
      } catch (Exception e) {
         throw new MareException(e);
      }
   }

   public static Integer StringToInteger(String str) throws MareException {
      try {
         return Integer.decode(str);
      } catch (Exception e) {
         throw new MareException(e);
      }
   }

   public static Character StringToCharacter(String str)
      throws MareException {
      try {
         return new Character(str.toCharArray()[0]);
      } catch (Exception e) {
         throw new MareException(e);
      }
   }

   /**
        * Fecha : 09/12/2003
        * Fecha con formato solicitado
        *
        * vbongiov
        * */
   /**
    * Formatos validos
    *
    * dd/mm/aa
    * dd/mm/aaaa
    * mm/dd/aaaa
    * mm/dd/aa
    * dd-mm-aaaa
    * dd-mm-aa
   */
   public static String fechaFormateada(Date fecha, String formato) {
      String formatoFecha = formato.replace('m', 'M'); //minute por MONTH, viene solo fecha.

      SimpleDateFormat simpledateformat = new SimpleDateFormat(formatoFecha);

      String dateString = simpledateformat.format(fecha);

      return dateString;
   }

   /**
        * Fecha : 10/12/2003
        * Hora con formato solicitado
        *
        * vbongiov
        * */
   /**
    * Formatos validos
    *
    * hh:mm:ss
    * hh:mm
    *
   */
   public static String horaFormateada(Date fecha, String formato) {
      String horaFormatedad;

      SimpleDateFormat formatter = new SimpleDateFormat(
            "yyyy.MM.dd 'at' HH:mm:ss");

      String horaString = formatter.format(fecha);

      int index = horaString.indexOf(":");

      String hora = horaString.substring((index - 2), index);
      String minutos = horaString.substring((index + 1), (index + 3));
      String segundos = horaString.substring((index + 4), (index + 6));

      if (formato.equals(FORMATO_DEFAULT_HORA_MIN_SEG)) {
         horaFormatedad = hora + ":" + minutos + ":" + segundos;
      } else if (formato.equals(FORMATO_DEFAULT_HORA_MIN)) {
         horaFormatedad = hora + ":" + minutos;
      } else {
         horaFormatedad = "Formato no encontrado";
      }

      return horaFormatedad;
   }

   /**
         * Fecha : 13/4/2004
         * Fecha de String con formato
         *
         * vbongiov
         * */
   public static Date getDatefromSICCStringFormat(String date, String format)
      throws Exception {
      String formatoFecha = format.replace('m', 'M'); //minute por MONTH, viene solo fecha.

      SimpleDateFormat simpledateformat = new SimpleDateFormat(formatoFecha);

      Date fecha = simpledateformat.parse(date);

      return fecha;
   }

   /***
   * Genera un conector XML, a partir de un Rowsert que contiene los datos a cargar.
   * @param rowsetId, Identificador del rowset.
   * @param datos, Rowset con los datos a cargar.
   * @param colums, Indica las columnas del rowset a completar.
   */
   public static DruidaConector generarConector(String rowsetID,
      RecordSet datos, Vector columns) throws DOMException, Exception {
      StringBuffer salida = new StringBuffer();
      int sizeColums = datos.getColumnCount();
      int sizeRows = datos.getRowCount();

      if (columns == null) {
         columns = new Vector();
      }

      Vector columsDesc = datos.getColumnIdentifiers();

      DruidaConector conectorValoresPosibles = new DruidaConector();
      XMLDocument xmlDoc = new XMLDocument();
      Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");
      Element e_rows = docDestino.createElement("ROWSET");
      e_rows.setAttribute("ID", rowsetID);
      docDestino.getDocumentElement().appendChild(e_rows);

      for (int i = 0; i < sizeRows; i++) {
         Element e_row = docDestino.createElement("ROW");
         e_rows.appendChild(e_row);

         for (int j = 0; j < sizeColums; j++) {
            if (columns.contains(columsDesc.elementAt(j))) {
               Element e_campo2 = docDestino.createElement("CAMPO");
               e_campo2.setAttribute("NOMBRE",
                  columsDesc.elementAt(j).toString());
               e_campo2.setAttribute("TIPO", "OBJECTO");
               e_campo2.setAttribute("LONGITUD", "50");

               Text txt = docDestino.createTextNode(((datos.getValueAt(i, j) == null)
                     ? "" : datos.getValueAt(i, j).toString()));
               e_campo2.appendChild(txt);
               e_row.appendChild(e_campo2);
            }
         }
      }

      conectorValoresPosibles.setXML(docDestino.getDocumentElement());

      return conectorValoresPosibles;
   }

   /**
        * Fecha : 26/01/2004
        * Copia un objeto
        *
        * Julian Rivas
        * */
   public static Object deepCopy(Object oldObj) throws MareException {
      ObjectOutputStream oos = null;
      ObjectInputStream ois = null;

      try {
         ByteArrayOutputStream bos = new ByteArrayOutputStream();
         oos = new ObjectOutputStream(bos);

         oos.writeObject(oldObj);
         oos.flush();

         ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
         ois = new ObjectInputStream(bin);

         return ois.readObject();
      } catch (Exception e) {
         UtilidadesLog.debug("Exception en deepCopy = " + e);
         throw new MareException(e);
      } finally {
         try {
            oos.close();
            ois.close();
         } catch (Exception ex) {
            UtilidadesLog.debug("Exception en deepCopy = " + ex);
            throw new MareException(ex);
         }
      }
   }

   /*
    * Retorna la fecha formateada como String seg�n el formato que hay en
    * sesi�n.
    * */
   public static String fechalongToString(DruidaBase lp, long fecha) {
      String formato = null;

      try {
         formato = UtilidadesSession.getFormatoFecha(lp);
      } catch (Exception e) {
         formato = "";
      }

      return UtilidadesBelcorp.fechaFormateada(new java.sql.Date(fecha), formato);
   }

   /*
    * Genera un DTOError con la descripcion, codigo y severidad de la exception
    * recibida. Requiere la LP para obtener el idioma y el pais (codigos ISO, ej. es, ES).
    * */
   public static final DTOError recuperarDatosException(Exception e,
      DruidaBase lp) {
      BelcorpError belcorpError = new BelcorpError();
      DTOError dtoError = null;

      try {
         dtoError = belcorpError.obtenerError(e,
               UtilidadesSession.getIdioma_ISO(lp), UtilidadesSession._ISO(lp));
      } catch (Exception ex) {
         dtoError = belcorpError.obtenerError(e); //Si falla usa el idioma default
      }finally{
          if(dtoError.getSeveridad()==9999){
              //es un error de seguridad, por lo que le sacamos la session
               Enumeration enumeration = lp.getRequest().getSession().getAttributeNames();
               HttpSession httpsession = lp.getRequest().getSession();
               if (httpsession != null) {
                   for (; enumeration.hasMoreElements(); httpsession.removeAttribute((String)enumeration.nextElement())) {
                   }
                   httpsession.invalidate();
               }
          }
      }

      return dtoError;
   }

   /*
    * M�todo utilizado para internacionalizar el error en DruidaTransaction
    * */
   public static final void lanzarPaginaErrorDT(Exception e, DruidaBase lp)
      throws Exception {
      DTOError dtoError = UtilidadesBelcorp.recuperarDatosException(e, lp);
      throw new Exception(dtoError.getDescripcionError());
   }

   /*
    * 22/03/2004 - Agrega un registro en blanco en el recordset con c�digo vacio.
    * Se le puede especificar si va al inicio o al final.
    * */
   public static synchronized void agregarRegistroVacio(RecordSet rs,
      int posicion) throws Exception {
      int cantidadColumnas;
      Object[] newRecord;

      if (rs != null) {
         cantidadColumnas = rs.getColumnCount();
         newRecord = new Object[cantidadColumnas];

         newRecord[0] = new String(""); //Le asignamos un c�digo vacio

         for (int i = 1; i < newRecord.length; i++) {
            newRecord[i] = new String("");
         }

         if (posicion == POSICION_INICIO) {
            rs.insertRow(0, newRecord);
         } else if (posicion == POSICION_FINAL) {
            rs.addRow(newRecord);
         } else {
            throw new IllegalArgumentException(
               "la posicion recibida no es correcta");
         }
      }
   }

   public static void seleccionarValorCombo(String campo, String valor,
      DruidaConector conector, String nombreRowset) {
      try {
         DOMXPath xpath = new DOMXPath("//ROWSET[@id='" + nombreRowset +
               "']/ROW[CAMPO[@nombre='" + campo + "']='" + valor + "']");

         Element element = (Element) xpath.selectSingleNode(conector.getXML());

         if (element == null) {
            xpath = new DOMXPath("//ROWSET[@id='" + nombreRowset +
                  "']/ROW[CAMPO[@nombre='" + campo + "' and @valor='" + valor +
                  "']");
            element = (Element) xpath.selectSingleNode(conector.getXML());

            if (element == null) {
               return;
            }
         }

         element.setAttribute("check", "S");
      } catch (Exception e) {
         ;
      }
   }

   /**
     * Fecha : 23/8/2004
     * N�mero formateado con miles y decimales seg�n el pais
     *
     * vbongiov
     * */
   public static String formateaNumeroSICC(String valor, int tipoFormato, DruidaBase lp)throws Exception {
     //*Formatea numero Double que se expresan como Exponencial*/ 
     int posicion = valor.indexOf("E");
     if (posicion>-1){
        int c = new Integer(valor.substring(posicion+1)).intValue();
        UtilidadesLog.debug("Posiciones a mover: "+c);
        char[] chars = valor.toCharArray();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i<posicion;i++){
            if (chars[i] != '.'){
                if (i==(c+2)){
                    buffer.append(".");
                }
                buffer.append(chars[i]);
            }
        }
        valor= buffer.toString();
     }
     /*Fin Formateo*/
     String separadorDecimal = UtilidadesSession.getSeparadorDecimales(lp);
     String separadorMiles = ((separadorDecimal.equals("."))) ? "," : ".";

     UtilidadesLog.debug("separadorDecimal:"+ separadorDecimal);
     UtilidadesLog.debug("separadorMiles:"+ separadorMiles);     
      
     StringTokenizer tokens = new StringTokenizer(valor, ".");
     StringBuffer buffer = new StringBuffer();

     //El numero tiene separador decimal, por lo tanto tiene decimales.
     if (tokens.countTokens() == 2) {
       buffer.append(agregaMiles(tokens.nextToken(),separadorMiles));
       buffer.append(separadorDecimal);
       buffer.append(tokens.nextToken());
     } else {
      //No tiene separador decimal
       buffer.append(agregaMiles(tokens.nextToken(),separadorMiles));
     }

     valor = buffer.toString();      

     return valor;
   }

   /**
     * Fecha : 23/8/2004
     * N�mero formateado con miles seg�n el pais
     *
     * vbongiov
     * */ 
   private static String agregaMiles(String valor, String separadorMiles)throws Exception {

		Double valorD = new Double(valor);
		NumberFormat numberFormatter;

		numberFormatter = NumberFormat.getNumberInstance(Locale.US);
		String valorDS = numberFormatter.format(valorD);

		StringTokenizer tokens = new StringTokenizer(valorDS,",");
		StringBuffer buffer = new StringBuffer();

		while (tokens.hasMoreTokens()) {
			 buffer.append(tokens.nextToken());
			 buffer.append(separadorMiles);
		}                      

		valor= buffer.toString();

		return valor.substring(0,valor.length()-1);

	}
  
}
