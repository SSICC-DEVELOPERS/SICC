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

public class CodigosError {
   /*
    * Estos códigos se pueden usar en cualquier módulo y caso de uso.
    * También podrían estar en alguna clase de MARE, no?
    */
   public static String CASO_DE_USO_INDEFINIDO = "0000";
   public static String ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS = "0001";
   public static String ERROR_DE_LECTURA_EN_BASE_DE_DATOS = "0002";
   public static String ERROR_DE_ACCESO_A_BASE_DE_DATOS = "0003";
   public static String ERROR_DE_CLAVE_DUPLICADA = "0004";
   public static String ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE = "0005";
   public static String ERROR_DE_BORRADO_DE_DATOS = "0006";
  

   // Ficheros
   public static String ERROR_ARCHIVO_NO_ENCONTRADO = "0009";
   public static String ERROR_DE_LECTURA_DE_ARCHIVO = "0010";
   public static String ERROR_DE_ARCHIVO = "0011";

   // Fechas
   public static String ERROR_DE_FORMATO_FECHA = "0012";

   // Sesion
   public static String ERROR_NO_PAIS_SESSION = "0013";
   public static String ERROR_NO_IDIOMA_SESSION = "0014";
   public static String ERROR_NO_MARE_CREDENTIALS_SESSION = "0015";
   public static String ERROR_PARAMETROS_INCORRECTOS = "0016";
   public static String ERROR_NO_MARCA_SESSION = "0017";
   public static String ERROR_NO_CANAL_SESSION = "0018";
   public static String ERROR_NO_ACCESO_SESSION = "0019";
   public static String ERROR_NO_SUBACCESO_SESSION = "0020";
   public static String ERROR_NO_SOCIEDAD_SESSION = "0021";
   public static String ERROR_INTEGRIDAD_INSERCION = "0022";
   public static String ERROR_INTEGRIDAD_ACTUALIZAR = "0023";
   public static String ERROR_ELIMINAR_NO_EXISTE = "0024";
   public static String ERROR_ASOCIACION_ESTRUCTURAL = "0025";
   public static String ERROR_LONGITUD_CODIGO_CLIENTE = "0026";
   public static String INFO_REGISTROS_ELIMINADOS_EXITO = "0027";
   public static String INFO_CONFIRMACION_ELIMINAR = "0028";
   public static String ERROR_OPERACION_BORRADO = "0029";
   public static String ERROR_VINCULOS_INVALIDOS = "0030";
   public static String ERROR_BORRADO_VARIAS_LISTAS = "0031";
   public static String ERROR_NO_ZONA_SESSION = "0032";
   
   
   //nuevos códigos de error
   public static String ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB = "0101";
   public static String ERROR_AL_PEDIR_UN_SERVICIO_MARE = "0102";
   public static String ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO = "0201";
   public static String ERROR_CAMPO_CON_LONGITUD_MAYOR_A_LA_PERMITIDA = "0202";

   public static String ERROR_VINCULO_DE_JERARQUIA_NO_VALIDO = "0204";
   
   //Modulo Gestion de Menu
   public static final String ERROR_CLAVE_TRIVIAL = "0301";
   public static final String ERROR_CLAVE_UTILIZADA = "0302";
   public static final String ERROR_CLAVE_CADUCADA = "0303";
   public static final String ERROR_ROLES = "0304";
   public static final String ERROR_BORRADO_PERFIL = "0305";
   public static final String USUARIO_DESHABILITADO = "0306";
   public static final String USUARIO_CLAVE_LONGITUD_MINIMA = "0307";
   public static final String USUARIO_NO_VALIDO = "0308";
   public static final String USR_SUST_NO_VALIDO = "0309";
   public static final String USR_SUST_NO_EXISTE = "0310";
   public static final String ERROR_CLAVE_INVALIDA = "0311";
   public static final String ERROR_ARCHIVO_RASTREO = "300040001";
   public static final String ERROR_CLAVES_DISTINTAS = "0315";
   public static final String ERROR_NOT_CONNECT = "0316";
   
   public static String ERROR_NO_IND_IMPUESTO = "30111";
   
   // Druida Transaccion
   public static String ERROR_OBTENER_PAIS_USUARIO = "0401";
   public static String ERROR_OBTENER_IDIOMA_USUARIO = "0402";

   //SICC NDG para USO GEstor Interfaces
   public static String ERROR_DE_LECTURA_DE_INTERFAZ ="0501";
   public static String ERROR_DE_ESCRITURA_DE_INTERFAZ ="0502";
   public static String ERROR_DE_CIERRE_DE_INTERFAZ ="0503";
   public static String ERROR_DE_ENVIO_DE_INTERFAZ ="0504";
   
   //SICC para utilizacion de reportes mediante sub-sistema batch
   public static String ERROR_DE_LECTURA_BLOB = "0601";
   public static String ERROR_REPORTE_ENCOLADO = "0602";
   public static String ERROR_REPORTE_EJECUTANDOSE = "0603";
   public static String ERROR_REPORTE_FIN_ERRONEO = "0604";
   public static String ERROR_REPORTE_ABORTADO = "0605";
   
}
