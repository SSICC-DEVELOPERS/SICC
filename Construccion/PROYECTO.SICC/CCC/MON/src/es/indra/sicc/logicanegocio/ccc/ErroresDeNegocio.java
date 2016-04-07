/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.ccc;


/**
 * En esta clase se definen constantes que hacen referencia
 * a codigos de errores de negocio del módulo CCC.
 */
public class ErroresDeNegocio {
    //CCC-0002 No se puede modificar este lote al estar aprobado y/o contabilizado
    public final static String IMPOSIBLE_MODIFICAR_LOTE_APROBADO_CONTABILIZADO = "0340002";

    //CCC-0004 Para realizar la operación seleccionada sobre el lote, éste debe estar en estado solicitado
    public final static String LOTE_EN_ESTADO_NO_SOLICITADO = "0340004";

	//CCC-0005 Para rechazar un lote este no debe haber sido contabilizado
	public final static String IMPOSIBLE_RECHAZAR_LOTE_CONTABILIZADO = "0340005";
	
    //CCC-0012 No existe el movimiento de cuentas corrientes al que se hace referencia
    public final static String MOVIMIENTO_CUENTAS_INEXISTENTE = "0340012";

    //CCC-0013 No existe el cargo de abono directo al que se hace referencia
    public final static String CARGO_ABONO_DIRECTO_INEXISTENTE = "0340013";

    //CCC-0014 No existe una marca situación asociada al tipo de abono elegido
    public final static String MARCA_SITUACION_ASOCIADA_INEXISTENTE = "0340014";

    //CCC-0015 (El movimiento no se puede retroceder porque ha sido modificado)
    public final static String IMPOSIBLE_RETROCEDER_MOVIMIENTO_MODIFICADO = "0340015";
    public final static String NUMERO_COLUMNAS_INCORRECTO = "0340020";
    public final static String CLIENTE_NO_RECONOCIDO = "0340021";
    public final static String MARCA_NO_RECONOCIDA = "0340022";
    public final static String MEDIO_PAGO_NO_RECONOCIDO = "0340023";
    public final static String MONEDA_NO_RECONIDIDA = "0340024";
    public final static String NO_TODAS_LAS_APLICACIONES_BORRADAS = "0340025";
    public final static String TIPOS_ABONO_MAL_CONFIGURADOS = "0340026";
    public final static String ANADIDO_BLOQUEO_FINANCIERO = "0340027";
    public final static String CLIENTE_YA_BLOQUEADO = "0340028";
	public final static String PASADOS_A_PROCESADO = "0340033";
    // CCC-0034 Sólo se pueden pasar a procesados los reclamos en estado solicitado
    public final static String IMPOSIBLE_PASAR_A_PROCESADO_RECLAMO_NO_SOLICITADO = "0340034";
    public final static String EXISTENCIA_TRATAMIENTOS_POSTERIORES = "0340036";

    
    // CCC-0038: Uno de los lotes que se intenta borrar no cumple las condiciones necesarias
    public final static String LOTE_NO_CUMPLE_CONDICIONES = "0340038"; 
	public final static String NUMERO_DOC_NO_CORRECTO = "0340039";
	public final static String CLIENTE_NO_ASIGNADO_PARA_MARCA = "0340040";

	// CCC-0042: No existe el TipoAbonoSubproceso indicado
	public final static String TIPO_ABONO_SUBPROCESO_INEXISTENTE = "0340042";

	// CCC-0043: No existe el subproceso indicado
	public final static String SUBPROCESO_INEXISTENTE = "0340043";

	// CCC-0048: CCC-0045: El contenido de alguno de los parámetros recibidos no es válido. 
	public final static String CONTENIDO_PARAMETROS_NO_ES_VALIDO = "0340045";

	//CCC-0046 La divisa no es válida para el pais actual
	public final static String DIVISA_NO_VALIDA_PARA_PAIS_ACTUAL = "0340046";

	// CCC-0048: CCC-0048: El registro está cerrado. Para poder modificarlo debe abrirlo antes. 
	public final static String REGISTRO_CERRADO_NO_ES_MODIFICABLE = "0340048";

    // CCC-0055:Canal no reconcido:. 
	public final static String CANAL_NO_RECONOCID0 = "0340055";

	// CCC-0056: ACCESO no reconcido:. 
	public final static String ACCESO_NO_RECONOCID0 = "0340056";

	// CCC-0057: SUBACCESO no reconcido:. 
	public final static String SUBACCESO_NO_RECONOCID0 = "0340057";

	// CCC-0059: No se pudo encontrar la Marca por Tipo de Abono correspondiente:. 
	public final static String MARCA_POR_TIPO_ABONO_NO_ENCONTRADA = "0340059";
	
	
	public final static String CCC_0055 =    "0340055"; 
	public final static String CCC_0056 =    "0340056"; 
	public final static String CCC_0057 =    "0340057"; 
	public final static String CCC_0059 =    "0340059"; 


    public final static String CCC_0001=    "0340001";
    public final static String CCC_0002=    "0340002";
    public final static String CCC_0003=    "0340003";
    public final static String CCC_0004=    "0340004";
    public final static String CCC_0005=    "0340005";
    public final static String CCC_0006=    "0340006";
    public final static String CCC_0007=    "0340007";
    public final static String CCC_0008=    "0340008";
    public final static String CCC_0009=    "0340009";
    public final static String CCC_0010=    "0340010";
    public final static String CCC_0011=    "0340011";
    public final static String CCC_0012=    "0340012";
    public final static String CCC_0013=    "0340013";
    public final static String CCC_0014=    "0340014";
    public final static String CCC_0015=    "0340015";
    public final static String CCC_0016=    "0340016";
    public final static String CCC_0017=    "0340017";
    public final static String CCC_0018=    "0340018";
    public final static String CCC_0019=    "0340019";
    public final static String CCC_0020=    "0340020";
    public final static String CCC_0021=    "0340021";
    public final static String CCC_0022=    "0340022";
    public final static String CCC_0023=    "0340023";
    public final static String CCC_0024=    "0340024";
    public final static String CCC_0025=    "0340025";
    public final static String CCC_0026=    "0340026";
    public final static String CCC_0027=    "0340027";
    public final static String CCC_0028=    "0340028";
    public final static String CCC_0029=    "0340029";
    public final static String CCC_0030=    "0340030";
    public final static String CCC_0031=    "0340031";
    public final static String CCC_0032=    "0340032";
    public final static String CCC_0033=    "0340033";
    public final static String CCC_0034=    "0340034";
    public final static String CCC_0035=    "0340035";
    public final static String CCC_0036=    "0340036";
    public final static String CCC_0037=    "0340037";    
    public final static String CCC_0038=    "0340038";
    public final static String CCC_0041=    "0340041";
    public final static String CCC_0043=    "0340043";
	public final static String CCC_0044=    "0340044";
    public final static String CCC_0045=    "0340045";
    public final static String CCC_0046=    "0340046";
	public final static String CCC_0047=    "0340047";
    public final static String CCC_0048=    "0340048";
	//Se agrega esto por diferencias con el SOURCESAFE de Argentina
	public final static String CCC_0049 =    "0340049";
	public final static String CCC_0051 =    "0340051";
	public final static String CCC_0052 =    "0340052"; //No se ha podido realizar el retroceso de cuenta
    public final static String CCC_0058 =    "0340058";
	
  public final static String CCC_0060 =    "0340060";
	
  // CCC-0050: La deuda del cliente es menor o igual que cero
	public final static String DEUDA_CLIENTE_MENOR_IGUAL_CERO = "0340050";
	// CCC-0049: El importe aplicado por el movimiento del banco es un { 0 } % superior a la deuda del cliente { 1}
	// usamos el 53 porque el 49 ya estaba siendo utilizado
	public final static String IMPORTE_MOV_BANC_SUPERIOR_DEUDA = "0340053";

	public final static String MOV_CC_NO_EXISTE_O_NO_PERTENECE_A_COD_CLIENT = "0340054";

    public final static String PROCESO_BLOQUEADO_PARA_USUARIO =    "0340061";
    
     // vbongiov -- 24/06/2008
    public final static String CUPON_EXISTENTE = "0340062";
    //enguanco -- 28/10/2008
       public final static String CCC_0061 = "0340063";
       public final static String CCC_0062 = "0340064";
       
       // vbongiov -- 24/06/2008
       public final static String RUTA_ARCHIVO_INEXISTENTE = "0340065";
}
