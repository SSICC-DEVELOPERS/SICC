package es.indra.sicc.util;


import java.lang.reflect.Method;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.math.BigDecimal;


/**
 * <p>Title: SICC</p>
 * <p>Description: Este DTO se utiliza para rellenar un DTO a partir de sus
 * parametros, de forma genérica</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Indra</p>
 * @author Gonzalo Herreros González
 * @version 1.0
 */
public class DTOGenerico {
   private static final String pattern = "dd/MM/yyyy";
   String[][] parametros = null; //Los parametros con los que rellenará el dto
   String nombreDTO = null; //La clase de dto que se quiere rellenar

   public DTOGenerico(String nombreDTO, String[][] parametros) {
      this.nombreDTO = nombreDTO;
      this.parametros = parametros;
   }

   /**
        * Esta variante del constructor básico recibe los parametros como una cadena
        * codificada con el formato de los parametros de una url
         * @param nombreDTO
         * @param parametros
         */
   public DTOGenerico(String nombreDTO, String parametros) {
      this(nombreDTO, decodificarCadenaParametros(parametros));
   }

   //Métodos publicos

   /**
   * Genera un dto especifico, basándose en los criterios especificados
   * @return Object
   * @throws IllegalAccessException
   */
   public Object toDTO() throws Exception {
      //ClassLoader cl = this.getClass().getClassLoader();
       ClassLoader cl = Thread.currentThread().getContextClassLoader();
      //Creamos el dto que nos han indicado
      Object dto = null;

      try {
         dto = (cl.loadClass(nombreDTO)).newInstance();
      } catch (Exception e) {
         System.err.println("No se pudo crear un dto de la clase: " +
            nombreDTO);

         //return null;
         throw e;
      }

      //Ahora rellenamos el dto con los parametros
      Map metodos = getSetters(dto); //Los setters publicos que tiene el dto
      Object[] parametroReflection = null; //El parametro con el que invocamos por reflection

      final String usuario = "usuario";
      final String password = "password";
        
        
      for (int i = 0; i < parametros.length; i++) {
         //obtenemos el "setter" correspondiente a la parametro
         String nombreMetodo = parametros[i][0];
         Method metodo = (Method) metodos.get(nombreMetodo);

         if (metodo == null){
            if(nombreMetodo.equalsIgnoreCase(usuario) || nombreMetodo.equalsIgnoreCase(password)) {
                continue;
            }
            throw new Exception("El dto: " + nombreDTO +
               " no tiene la propiedad: " + parametros[i][0]);
         }

         //Rellenamos el atributo con el valor del parametro    		
         try {
            String atributo = parametros[i][1];
            parametroReflection = getParameterReflection(metodo,
                  atributo);

            if (parametroReflection != null) {
               metodo.invoke(dto, parametroReflection);
            }
         } catch (Exception e) {
            System.err.println("Error al rellenar una propiedad");
            if(!nombreMetodo.equalsIgnoreCase(usuario) && !nombreMetodo.equalsIgnoreCase(password)){
                UtilidadesLog.error(e);
                throw e;
            }
         }
      }

      return dto;
   }

   //Métodos privados

   /**
   *<p>Convierte el valor recibido en el argumento apropiado para llamar al
   *metodo indicado. Este método sólo se puede utilizar para "setters", es
   *decir, métodos que reciben un único parametro. </p>
   *<p>NOTA: Este métodos sólo soporta setters cuyos parametros sean un String,
   *una primitiva o un wrapper de primitiva;  salvo  los char y Character.</p>
   * @param metodo
   * @param valor
   * @return Object[]
   */
   private Object[] getParameterReflection(Method metodo, String valor) {
      if ((valor == null) || (valor.length() == 0)) {
         return new Object[] { null };
      }

      Object[] result = new Object[1]; //Solamente tenemos un parametro: valor
      Class[] parametros = metodo.getParameterTypes();

      if (parametros.length != 1) {
         System.err.println("El método " + metodo.getName() +
            " no es un \"setter\"");
         throw new IllegalArgumentException();
      }

      String tipoDatos = parametros[0].getName();

      ParsePosition p = null;
      SimpleDateFormat d = null;

      if (tipoDatos.equals("java.lang.String")) {
         result[0] = valor;
      } else if (tipoDatos.equals("byte") ||
             tipoDatos.equals("java.lang.Byte")) {
         result[0] = Byte.valueOf(valor);
      } else if (tipoDatos.equals("short") ||
             tipoDatos.equals("java.lang.Short")) {
         result[0] = Short.valueOf(valor);
      } else if (tipoDatos.equals("int") ||
             tipoDatos.equals("java.lang.Integer")) {
         result[0] = Integer.valueOf(valor);
      } else if (tipoDatos.equals("long") ||
             tipoDatos.equals("java.lang.Long")) {
         result[0] = Long.valueOf(valor);
      } else if (tipoDatos.equals("float") ||
             tipoDatos.equals("java.lang.Float")) {
         result[0] = Float.valueOf(valor);
      } else if (tipoDatos.equals("double") ||  tipoDatos.equals("java.lang.Double"))  {
         result[0] = Double.valueOf(valor);
	  } else if( tipoDatos.equals("java.math.BigDecimal") ){
		  result[0] = new BigDecimal(valor);
      } else if (tipoDatos.equals("boolean") ||  tipoDatos.equals("java.lang.Boolean")) {
         if (valor == null) {
            result[0] = null;
         } else {
            result[0] = Boolean.valueOf(valor);
         }
      } else if (tipoDatos.equals("char") ||
             tipoDatos.equals("java.lang.Character")) {
         result[0] = new Character(valor.charAt(0));
      } else if (tipoDatos.equals("java.util.Date") ||
             tipoDatos.equals("java.sql.Date")) {
         //asumimos que el string de entrada esta en formato dd/MM/yyyy
         p = new ParsePosition(0);
         d = new SimpleDateFormat(pattern);

         if (tipoDatos.equals("java.util.Date")) {
            result[0] = d.parse(valor, p);
         } else {
            result[0] = new java.sql.Date(d.parse(valor, p).getTime());
         }
      } else { //La propiedad debe ser una primitiva, un wrapper de primitiva o un String
         System.err.println("El objeto que recibe el método: " +
            metodo.getName() + " no es válido como propiedad");
         throw new IllegalArgumentException();
      }

      return result;
   }

   /**
   * Obtiene por reflexion la lista de "setters" de propiedades del objeto.
   * Devuelve  un map con el nombre de la propiedad y el setter correspondiente
   * @param object
   * @return Map
   */
   private Map getSetters(Object object) {
      Map result = new HashMap();

      Method[] metodos = object.getClass().getMethods();
      String nombre = null;
      String propiedad = null;

      for (int i = 0; i < metodos.length; i++) {
         nombre = metodos[i].getName();

         //Sólo nos interesan los "setters", siguiendo la especificacion JavaBean
         if (nombre.startsWith("set") && (nombre.length() > 3)) {
            //Quitamos el prefijo "set"
            propiedad = nombre.substring(3, nombre.length());

            //ponemos la primera letra en minuscula
            propiedad = Character.toLowerCase(propiedad.charAt(0)) +
               propiedad.substring(1, propiedad.length());

            //Añadimos el setter con el nombre de la propiedad como key
            result.put(propiedad, metodos[i]);
         }
      }

      return result;
   }

   /**
   * Obtiene los pares de parametros que contiene la cadena (formeada como los
   * parametros de una url) y devuelve un String[N][2] de pares atributo-valor.
   * @param cadena
   * @return String[][]
   * 17/04/2006 - [1] pperanzola - se modifica para que acepte el caracter "&"
   */
   private static String[][] decodificarCadenaParametros(String cadena) {
      ArrayList resultado = new ArrayList();
      StringTokenizer stringTokenizer = new StringTokenizer(cadena, "&");
      String aux = null;
      int index = 0;
      String[] atributo = null; //Un atributo se compone de un nombre y un valor asociado 
      String attrtmp; // [1] atributo temporal para conoces si tenia un & en el string original
      while (stringTokenizer.hasMoreElements()) {
         aux = stringTokenizer.nextToken();
         index = aux.indexOf('=');

         if (index == -1) {
            throw new IllegalArgumentException("Al parametro le falta el =");
         } else {
            atributo = new String[2];
            atributo[0] = aux.substring(0, index); //A la izquierda del =
            attrtmp = aux.substring(index + 1, aux.length()); // [1] a la derecha del =
            attrtmp = attrtmp.replaceAll(";druida;amp;","&");//[1]
            atributo[1] = attrtmp; //[1]
            //[1] atributo[1] = aux.substring(index + 1, aux.length()); //A la derecha del =
            resultado.add(atributo); //Añadimos el atributo recien creado a la lista
         }
      }

      return listToArray(resultado);
   }

   /**
   * Se utiliza por el metodo decodificarCadenaParametros para convertir el
   * arraylist dinámico en un array estático
   * @param lista
   * @return String[][]
   */
   private static String[][] listToArray(List lista) {
      String[][] resultado = new String[lista.size()][];
      Object[] objetos = lista.toArray();

      if (objetos == null) {
         return null;
      }

      for (int i = 0; i < objetos.length; i++) {
         resultado[i] = (String[]) objetos[i];
      }

      return resultado;
   }
}
