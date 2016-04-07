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

package es.indra.sicc.logicanegocio.cra;

/**
 * En esta clase se definen constantes que hacen referencia
 * a codigos de errores de negocios.
 * 
 */
 
public class ErroresDeNegocio {

   /*
    * El patron seguido para las constantes es CasoDeUso_Error
    */

   public final static String VALIDAR_ELIMINACION_PERIODO_ANTERIOR = "0110001";
   public final static String VALIDAR_ELIMINACION_PERIODO_CON_ACTIVIDADES = "0110002";
   public final static String VALIDAR_MODIFICAR_CRONOGRAMA = "0240001";   
   public final static String VALIDAR_INSERCION_ACTIVIDAD_ORIGEN = "0050001";   
   public final static String VALIDAR_ELIMINACION_ACTIVIDAD = "0050002";
   public final static String VALIDAR_VINCULOS_ACTIVIDAD = "0050003";
   public final static String VALIDAR_ELIMINAR_PERIODO = "0110003";
   public final static String VALIDAR_MODIFICAR_PERIODO = "0100001";
   public final static String GRUPO_ZONA_REFERENCIADO = "0010001";
   public final static String VALIDAR_MODIFICAR_CRONOGRAMA_FECHA_REFERENCIADA = "0240003";   
   public final static String VERIFICAR_CICLOS_MODIFICAR_ACTIVIDAD = "0030001";
   public final static String YA_SE_GRABO_LA_MATRIZ_DE_DIAS_POR_HOY = "0040001";
   public final static String NO_EXISTE_CALENDARIO_PARA_ANIO_INDICADO = "0060003";
   public final static String YA_EXISTE_UN_CALENDARIO_PARA_EL_ANIO_INDICADO = "0060004";
   public final static String CALENARIO_YA_TIENE_CRONOGRAMA_ASOCIADO = "0060005";
   public final static String ERROR_EN_PROCESO = "0070001";
   public final static String GRUPOS_DE_ZONA_SIN_DATOS = "0070002";
   public final static String ACTIVIDAD_FUERA_DEL_PERIODO = "0080001";
   public final static String PERIODOS_CORPORATIVOS_MAL_GENERADOS = "0110004";
   public final static String GEN_0013 = "0070013";
   public final static String PERIODO_ACTUAL_NO_ECONTRADO = "0110005";
   public final static String DATOS_DE_PERIODO_NO_ECONTRADO = "0800005";
   public final static String NOMBRE_DE_GRUPO_EXISTENTE = "0800007";
   public final static String NO_EXISTE_PERIODO_PARA_MARCA_CANAL_INDICADOS = "0240004";
   
}