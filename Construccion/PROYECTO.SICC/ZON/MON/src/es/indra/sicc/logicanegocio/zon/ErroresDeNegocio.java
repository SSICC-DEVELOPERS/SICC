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

package es.indra.sicc.logicanegocio.zon;

/**
 * En esta clase se definen constantes que hacen referencia
 * a codigos de errores de negocios.
 * 
 */

public class ErroresDeNegocio {
   /*
    * El patron seguido para las constantes es CasoDeUso_Error
    */

    
    public final static String ELIMINACION_ESTRGEOPOL_UNIDAD_GEOGRAFICA_EXISTENTE = "0010001";
	    
    public final static String PAIS_SIN_UNIDADES_GEOGRAFICAS = "0040001";
    public final static String PAIS_TIENE_UG_ASIGNADAS = "0050001";
    public final static String PAIS_DE_FICHERO_DIFERENTE_PAIS_ACTIVO = "0060001";
    public final static String CABECERA_FICHERO_NO_VALIDA = "0070001";
    public final static String NO_EXISTE_ESTRUCTURA_GEOPOLITICA = "0080001";
    public final static String EXISTE_MAS_DE_UN_TERRITORIO_POR_CODIGO_PAIS = "0090001";
    public final static String NO_EXISTE_TERRITORIO = "0100001";
    public final static String EXISTE_MAS_DE_UN_TIPOVIA_POR_CODIGO = "0110001";
    public final static String NO_EXISTE_TIPOVIA = "0120001";
    public final static String EXISTE_MAS_DE_UNA_VIA_POR_PAIS_NOMBRE_TIPO = "0130001";
    public final static String NO_EXISTE_VIA = "0140001";
    public final static String ERROR_AL_CREAR_VIA_SEGMENTO = "0150001";
    public final static String NO_EXISTE_VIA_SEGMENTO = "0160001";
    public final static String EXISTE_MAS_DE_UNA_VIA_SEGMENTO_POR_TERRITORIO_VIA = "0170001";
    public final static String DATO_DE_REGISTRO_ERRONEO = "0180001";
    public final static String NO_EXISTE_NUMERO_INDICADO = "0190001";
    public final static String VIA_INACTIVA = "0200001";
    public final static String UBIGEO_NO_EXISTE_PARA_TERRITORIO = "0210001";
    public final static String EXISTE_ESTRUCTURA_GEOPOLITICA = "0220001";
    public final static String PAIS_NO_TIENE_UNIDAD_GEOGRAFICA_A_DESASIGNAR = "0230001";
    public final static String UNIDAD_ADMINISTRATIVA_INCORRECTA = "0240001";
    public final static String UNIDAD_ADMINISTRATVA_SIN_GERENTE = "0250001";	
    public final static String NO_EXISTE_UNA_VIA_POR_PAIS_NOMBRE_TIPO = "0260001";
    public final static String NO_SE_ENCONTRO_NINGUNA_VIA_PARA_LOS_CRITERIOS_DEFINIDOS = "0270001";
    public final static String JERARQUIA_ADMINISTRATIVA_NO_UNICA = "0280001";
    public final static String DATOS_ENTRADA_INCORRECTOS = "0290001";
    public final static String NO_EXISTE_SEGMENTO_VIA = "0300001";
    public final static String NO_EXISTE_UNIDAD_ADMINISTRATIVA = "0310001";
    public final static String ERROR_EN_PARAMETROS = "0320001";
    public final static String NO_EXISTE_UBIGEO = "0330001";
    public final static String NO_EXISTE_CLIENTE_RESPONSABLE = "0340001"; //PENDIENTE INCIDENCIA


    //Errores de Procesamiento de Ficheros
    public final static String PAIS_NO_EXISTE = "0350001";
    public final static String MARCA_NO_EXISTE = "0360001";
    public final static String CANAL_NO_EXISTE = "0370001";
    public final static String TIPO_PERIODO_NO_EXISTE = "0380001";
    public final static String PERIODO_NO_EXISTE = "0390001";
    public final static String FICHERO_NO_DE_REZONIFICACION = "0410001";
    public final static String FICHERO_NO_DE_RETERRITORIALIZACION = "0400001";
    public final static String OPERACION_INCORRECTA = "0420001";
    public final static String RESPONSABLE_ELEGIDO_NO_GERENTE = "0310002";
    public final static String RESPONSABLE_ELEGIDO_NO_CONSULTORA = "0310003";
   
    //agregado por incidencia SiCC-20070239 (Sapaza)
    public final static String RESPONSABLE_YA_ASIGNADO = "0310004";
        
	  private ErroresDeNegocio() { }
}