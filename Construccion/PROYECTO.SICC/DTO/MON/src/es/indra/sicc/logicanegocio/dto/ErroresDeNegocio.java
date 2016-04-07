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

package es.indra.sicc.logicanegocio.dto;

/**
 * En esta clase se definen constantes que hacen referencia
 * a codigos de errores de negocios.
 * 
 */

public class ErroresDeNegocio {
   /*
    * El patron seguido para las constantes es CasoDeUso_Error.
	 * Los 3 primeros nro son el codigo del caso de uso (arbitrario)
	 * Los 4 restantes son el identificador de error dentro del caso de uso
	 * 
	 * ej: 0010001 Error 1 del caso 1
	 *     0010002 Error 2 del caso 1
	 *     
	 * Para utilizar esto desde el MON se utiliza:
    *
	 *		 if( periodoActual == null ) { 
	 *			codigoError = ErroresDeNegocio.GENERAR_NUMSOLIC_PERIODOENCURSO_INVALIDO;
	 *			  throw new MareException(null, null, 
	 *					UtilidadesError.armarCodigoError(CodigosModulos.DTO, "", codigoError));
	 *		 } 
    */
//  public final static String INSERCION_TIPOMEDIOPAGO_SOLICITUD_CREDITO_INVALIDO = "0010001";
//  public final static String GENERAR_NUMSOLIC_PERIODOENCURSO_INVALIDO           = "0020001";
//  public final static String GENERAR_POSICION_HAY_LINEAS_ANULADAS               = "0030001";

    public final static String GENERAR_DTO_CLIENTE_NO_EXISTENTE                     = "0010001";
    public final static String NO_SE_ELIMINARON_TODAS_LAS_MATRICES_0002	 	        = "0010002";
    public final static String DEBE_SELECCIONAR_MATRIZ_0003					        = "0010003";
    public final static String DATOS_GENERALES_GUARDADOS_0004				        = "0010004";
    public final static String ALCANCE_TIPO_CLIENTE_GUARDADO_0005			        = "0010005";
    public final static String DESCUENTO_A_CLIENTE_GUARD_0006 				        = "0010006";
    public final static String ALCANCE_ADMINISTRATIVO_GUARDADO_0007			        = "0010007";	
    public final static String BASE_DE_CALCULO_GUARDADA_0008				        = "0010008";
    public final static String BASE_DE_APLICACION_GUARDADA_0009 			        = "0010009";
    public final static String DESCUENTO_GUARDADO_EXITOSAMENTE_0010 		        = "0010010";	
    public final static String NO_PUEDE_BORRARSE_UN_DESCUENTO_ACTIVO_0011	        = "0010011";
    public final static String Indicador_afecta_a_facturas_0012	                    = "0010012";
    public final static String NO_EXISTE_EL_CODIGO_DE_CLIENTE_0013	                = "0010013";
    public final static String ERROR_EN_PERIODO_0014	                            = "0010014";
    public final static String DESCUENTO_NO_ACTIVABLE_POR_BASE_APLICACION_0015      = "0010015";
    public final static String DESCUENTO_NO_ESTA_APROBADO_0016                      = "0010016";
    public final static String CLIENTE_CON_BLOQUEO_FINANCIERO_0017                  = "0010017";
    public final static String DESCUENTO_ERRONEO_0018                               = "0010018";
    public final static String PERIODO_INICIAL_NO_VIGENTE                           = "0010019";    
    public final static String MATRIZ_DE_DESCUENTO_EN_USO                           = "0010020";   
    public final static String NO_PUEDE_BORRARSE_DESCUENTO_QUE_ESTUBO_ACTIVO_0021   = "0010021";
    
    public final static String DTO_0022 = "Error de parametrización para generación de solicitud de abono por importe de descuento";

    private ErroresDeNegocio() { 
    }
  
}