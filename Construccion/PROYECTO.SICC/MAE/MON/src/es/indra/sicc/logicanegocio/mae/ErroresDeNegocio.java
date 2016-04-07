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

package es.indra.sicc.logicanegocio.mae;

/**
 * En esta clase se definen constantes que hacen referencia
 * a codigos de errores de negocios.
 * pperanzola - 20/10/2005 - [1] se modifica según el modelo GCC-PRE-MAE-INT-001
 */
 
public class ErroresDeNegocio {

   /*
    * El patron seguido para las constantes es CasoDeUso_Error
    */

   public final static String MANTENIMIENTO_MATERIALES_PROD_INEXISTENTE = "0170001";
   public final static String CODIGO_SAP_INEXISTENTE 					= "0180001";
   public final static String UNID_ADM_SIN_CONSULTORAS 					= "0190001";  
   public final static String IMPU_POR_UBIGEO_BUSCARC 					= "0200001";
   public final static String PAIS_NO_PERMITE_USUARIO_AUTOMATICO 		= "0210001";
   public final static String CANTIDAD_CLIENTES_SUPERA_RANGO 			= "0220001";
   public final static String SUBSISTEMA_REIMPRESION_NO_IMPLEMENTADO 	= "0230001";
   public final static String CODIGO_SAP_INTRODUCIDO_YA_EXISTE 			= "0240001";
   public final static String PRODUCTO_QUE_DESEA_ANADIR_AL_KIT_NO_EXISTE= "0250001";
   public final static String IGEOREFERENCIADOR_NOT_READY 				= "0260001";
   public final static String NRO_POSICIONES_CON_PESO_INCORRECTO 		= "0260003";
   public final static String MAE_0011 									= "0260002";
   public final static String MAE_0005 									= "0260004";
   public final static String MAE_0025 									= "0270001";
   public final static String MAE_0027 									= "0270002";
   public final static String NO_EXISTE_NOMBRE_O_NUMERO_VIA             = "0290001";
   public final static String PRODUCTO_YA_FORMA_KIT                     = "0300001";
   public final static String PRODUCTO_NO_ACTIVO                        = "0310001";
   public final static String MAE_0024 									= "0320001";
   public final static String MAE_0030 									= "0000030";
   public final static String MAE_0032 									= "0000032";
   public final static String MAE_0034 									= "0000034";
   public final static String MAE_0035 									= "0000035"; //[1]
   public final static String MAE_0037 									= "0320002"; 
   public final static String NO_HAY_EJECUTIVOS_CUENTA_ASIGNADOS				= "0330001";
   public final static String NO_SE_HALLO_UA_PARA				= "0330002";
   public final static String MAE_0038                  = "0330003"; // "Cierre de periodo ya ejecutado: no puede reasignar Estatus en lote" 
   public final static String MAE_0039                  = "0330004"; // "Cierre de región {0} no ejecutado: no puede reasignar Estatus en lote"
   
   /* Cambio COL-BLO-001 - dmorello, 14/03/2008 */
   public final static String MAE_0040                  = "0000040"; // Nivel de gravedad ya existe; introduzca otro nivel de gravedad
   public final static String MAE_0041                  = "0000041"; // El nivel de gravedad del tipo de bloqueo seleccionado es mayor
                                                                     // al tipo de bloqueo actual, no se permite la modificación
                                                                     
   // vbongiv -- 17/01/2008 -- Cambio SiCC20070461 MAE
   public final static String PROBLEMAS_ESTATUS         = "0000042"; 
   
   // vbongiv -- 31/01/2008 -- Cambio 20070458
   public final static String MAE_0043         = "0000043";                                                                      
}