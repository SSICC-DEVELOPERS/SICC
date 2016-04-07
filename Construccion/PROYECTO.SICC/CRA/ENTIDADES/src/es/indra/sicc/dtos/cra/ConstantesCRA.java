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
package es.indra.sicc.dtos.cra;

public class ConstantesCRA  {

   public final static Long TIPO_FAC_MULTI = new Long(0);
   public final static Long TIPO_FAC_MONO = new Long(1);
   public final static Long TIPO_FAC_SEMA = new Long(2);
   public final static String CLAS_FAC = "FAC";
   public final static String DATO_MARCA = "oidMarca";
   public final static String DATO_CANAL = "oidCanal";
   public final static String DATO_PAIS = "oidPais";
   public final static String DATO_PERIODO = "oidPeriodo";
   public final static String DATO_ZONA = "oidZona";
   public final static String DATO_MODULO =  "oidModulo";
   public final static String DATO_VARIABLE_ENTORNO =  "variableEntorno";
   public final static Long CLASE_ACTIVIDAD_REPARTO = new Long(5);
   public final static Long CLASE_ACTIVIDAD_FACTURACION = new Long(2); // inc 21950
   public final static String COD_CLASE_ACTIVIDAD_FACTURACION = "FAC";   
   public final static String COD_CLASE_ACTIVIDAD_CURSO = "CUR";
   public final static String COD_CLASE_ACTIVIDAD_RECLAMOS = "CDR";
   public final static String COD_CLASE_ACTIVIDAD_CONFERENCIA_DE_VENTAS = "CVT";

   public final static Long DIARIO = new Long(1);
   public final static Long SEMANAL = new Long(7);

   public final static Long ACTIVIDAD_FIJA = new Long(0);
   public final static Long ACTIVIDAD_CON_ACTIV_ORIGEN = new Long(1);
   public final static Long ACTIVIDAD_CON_REFE_OTRO_PERIODO = new Long(2);

}