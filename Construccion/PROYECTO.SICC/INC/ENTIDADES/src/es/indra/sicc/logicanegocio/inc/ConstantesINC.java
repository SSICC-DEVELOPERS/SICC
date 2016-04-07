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
 *
 * Autor : Dante Castiglione
 */
package es.indra.sicc.logicanegocio.inc;

public class ConstantesINC {
    public static final Long OID_DIRIGIDO_A_CONSULTORAS = new Long(1);
    public static final Long OID_DIRIGIDO_A_GERENTE = new Long(2);
    public static final Long OID_BASE_CALCULO_MONTO = new Long(1);
    public static final Long OID_BASE_CALCULO_UNIDADES = new Long(2);
    public static final Long OID_BASE_CALCULO_NPEDIDOS = new Long(3);
    public static final Long OID_BASE_CALCULO_RECOMENDADAS = new Long(4);
    public static final Long OID_ESTADO_SOLICITADA_AUTORIZACION = new Long(10);
    public static final Integer IND_ACTIVO = new Integer(1);
    public static final Integer IND_INACTIVO = new Integer(0);
    public static final Long ESTATUS_FUTURO_NUEVA = new Long(2);
    public static final String ENTIDAD_CANAL = "SEG_CANAL";
    public static final Integer NUM_ATRIBUTO = new Integer(1);
    public static final String ENTIDAD_DIRIGIDO_A = "INC_DIRIG";
    public static final String ENTIDAD_PLANTILLA_CONCURSO = "INC_PLANT_CONCU";
    //AGREGADO POR INCIDENCIA 21876 - dmaneiro - 07/12/2005
    public static final String ENTIDAD_TIPO_PREMIO = "INC_TIPO_PREMI";
    public static final String PUNTOS_VENTA_ECM = "PUNTOS_POR_VENTA_ECM_CLIENTE";
    public static final String DES_EXPRESION_PUNTAJE = "puntos";
    public static final String NOMBRE_SECUENCIA_NUMERO_PREMIO = "NUMERO_PREMIO";
    public static final Integer PESTANYA_PARAMETROS_GENERALES = new Integer(1);
    public static final Integer PESTANYA_PROGRAMA_NUEVAS = new Integer(2);
    public static final Integer PESTANYA_AMBITO_GEOGRAFICO = new Integer(3);
    public static final Integer PESTANYA_OBTENCION_PUNTOS = new Integer(4);
    public static final Integer PESTANYA_PRODUCTOS = new Integer(5);
    public static final Integer PESTANYA_PREMIOS = new Integer(6);
    public static final Integer PESTANYA_REQUISITOS_PREMIACION = new Integer(7);
    public static final Integer PESTANYA_DESPACHO_PREMIOS = new Integer(8);
    public static final Integer PESTANYA_CALIFICACION = new Integer(9);
    public static final Integer PESTANYA_GERENTES = new Integer(10);
    public static final Integer PESTANYA_CONSULTORAS = new Integer(11);
    public static final Integer PESTANYA_MULTINIVEL = new Integer(12);
    public static final Long OID_ESTADO_AUTORIZADO = new Long(12);
    public static final Long OID_ESTADO_SOLICITADA_APROBACION = new Long(9);
    public static final Long OID_ESTADO_APROBADO = new Long(11);
    public static final Long OID_ESTADO_RECHAZADA_AUTORIZACION = new Long(14);
    public static final Long OID_ESTADO_MODIFICACION = new Long(15);
    public static final Long OID_ESTADO_RECHAZADA_APROBACION = new Long(13);
    public static final Long TIPO_CAMBIO_PREMIADO_A_PREMIADO = new Long(2);
    public static final Long TIPO_CAMBIO_SIN_PREMIO = new Long(3);
    public static final Long TIPO_CAMBIO_MASIVO = new Long(1);
    public static final Long OID_ESTADO_RECHAZADA_SOLICITUD = new Long(8);
    public static final Long SITUACION_REGISTRO_VIGENTE = new Long(2);
    public static final Long SITUACION_REGISTRO_HISTORICA = new Long(1);
    public static final Long PRECIO_CONTABLE_SUSTITUTOS = new Long(0);
    
    public static final Long OID_TIPO_PRODUCTOS_VALIDOS = new Long(1);
    public static final Long OID_TIPO_PRODUCTOS_EXCLUIDOS = new Long(2);
    public static final Long OID_TIPO_PRODUCTOS_BONIFICADOS = new Long(3);
    public static final Long OID_TIPO_PRODUCTOS_EXIGIDOS = new Long(4);
    public static final Long OID_TIPO_PRODUCTOS_A_CALIFICAR = new Long(5);
    public static final Long OID_TIPO_PRODUCTOS_EXCLUIDOS_CALIFICACION = new Long(6);

    public static final Long OID_TIPO_CALIF_PROYECTADA = new Long(1);
    public static final Long OID_TIPO_CALIF_HISTORICA_INC = new Long(2);
    public static final Long OID_TIPO_CALIF_HISTORICA_INC_NIVELES = new Long(3);

    public static final Long OID_TIPO_VTA_CALIF_HISTORICA = new Long(1);
    public static final Long OID_TIPO_VTA_CALIF_PROYECTADA = new Long(2);
    
    public static final Long OID_TIPO_VTA_INC_INCREMENTAL = new Long(1);
    public static final Long OID_TIPO_VTA_INC_INCREMENTAL_NIVELES = new Long(2);
    

    public static final Long OID_AGRUPACION_SUBGERENCIA_VTA = new Long(1);
    public static final Long OID_AGRUPACION_REGION = new Long(2);
    public static final Long OID_AGRUPACION_ZONA = new Long(3);
    public static final Long OID_AGRUPACION_SECCION = new Long(4);
    public static final Long OID_AGRUPACION_GENERAL = new Long(5);

    public static final String DES_TIPO_VTA_CALIF_VENTA_PROYECTADA = "Venta proyectada";
    public static final String DES_TIPO_VTA_CALIF_VENTA_HISTORICA = "Venta histórica";


    ///////////////////////////////////////////////////////////////////////
    // Desde aqui agregadas por Gustavo Viñales según Modelo INC4
    ///////////////////////////////////////////////////////////////////////
    public static final Long TIPO_VENTA_CATALOGO = new Long(3);
    public static final Long CODIGO_MODULO_ORIGEN = new Long(13);
    public static final Long TIPO_REQUISITO_MONTO = new Long(1);
    public static final Long TIPO_REQUISITO_UNIDADES = new Long(2);
    public static final Long TIPO_EXIGENCIA_CONSTANCIA = new Long(1);
    public static final Long TIPO_EXIGENCIA_ACTIVIDAD = new Long(2);
    public static final Long BASE_CALCULO_MONTO = new Long(1);
    public static final Long BASE_CALCULO_NUM_PEDIDOS = new Long(3);
    public static final Long BASE_CALCULO_UNIDADES = new Long(2);
    public static final Long BASE_CALCULO_RECOMENDADA = new Long(4);
    public static final Long TIPO_VINC_NINGUNO = new Long(1);
    public static final Long TIPO_CONSULTORA = new Long(1);
    public static final Long OPER_SOLIC_BOLSA_FALTANTES = new Long(17);
    public static final Long TIPO_VINC_RECOMENDANTE = new Long(3);
    public static final Long TIPO_VINC_RECOMENDADO = new Long(2);
    public static final Long TIPO_VINC_AMBOS = new Long(4);
    public static final int CAUSA_DESCALIF_CONSTANCIA = 2;
    public static final int CAUSA_DESCALIF_ACTIVIDAD = 1;
    public static final Long TIPO_GERENTE = new Long(2);
    public static final int CLIENTE_CALIFICADO = 0;
    public static final Long TIPO_MOVIMIENTO_ABONO = new Long(1);
    public static final Long TIPO_MOVIMIENTO_CARGO = new Long(2);
    public static final Long FORMA_PAGO_ENTIDAD_BANCARIA = new Long(2);
    public static final Long FORMA_PAGO_ABONO_CC = new Long(1);
    public static final Long TIPO_PREMIO_ARTICULO = new Long(2);
    public static final Long TIPO_PREMIO_MONETARIO = new Long(1);
    public static final Long TIPO_PREMIO_PUNTUACION = new Long(4);
    public static final Long TIPO_PREMIO_DESCUENTOS = new Long(3);
    public static final Long TIPO_PREMIO_MONETARIO_PUNTOS_CANTIDAD_FIJA = new Long(1);
    public static final Long TIPO_PREMIO_MONETARIO_PUNTOS_PUNTAJE_OBTENIDO = new Long(1);
    public static final Long TIPO_PREMIO_MONETARIO_PORCENTAJE_PUNTOS_PUNTAJE_OBTENIDO = new Long(2);
    public static final Long TIPO_PREMIO_MONETARIO_PUNTOS_PORCENTAJE = new Long(2);
    public static final Long OPER_SOLIC_DESPACHO_PREMIO_MON = new Long(13);
    public static final Long OPER_SOLIC_DESPACHO_PREMIO_ART = new Long(14);
    public static final Long BASE_INCUMPLIDA_ASISTENCIA_A_CURSOS = new Long(1);
    public static final Long BASE_INCUMPLIDA_EXIGENCIAS_CONCURSO = new Long(2);
    public static final Long BASE_INCUMPLIDA_EXIGENCIAS_PREMIACION = new Long(3);
    public static final Long BASE_INCUMPLIDA_PAGO_A_TIEMPO = new Long(4);
    //jrivas BLO-001
    public static final Long BASE_INCUMPLIDA_CLIENTE_BLOQUEADO = new Long(5);
    public static final Long MONTO_TIPO1 = new Long(1);
    public static final Long MONTO_TIPO2 = new Long(2);
    public static final Long MONTO_TIPO3 = new Long(3);
    public static final Long MONTO_TIPO4 = new Long(4);
    public static final Long TIPO_PREMIACION_BOLSA_PREMIOS = new Long(1);
    public static final Long TIPO_PREMIACION_POR_NIVELES = new Long(2);
    public static final Long TIPO_VENTA_NETA = new Long(1);
    public static final Long TIPO_VENTA_FACTURA = new Long(2);
    public static final Long TIPO_CUMPLIMIENTO_TOTAL = new Long(1);
    //////////////////////////////////////////////////////////////////////////
    // Hasta aqui agregadas/modificadas por Gustavo Viñales según Modelo INC4
    //////////////////////////////////////////////////////////////////////////
    public static final Long OID_TIPOVTA_VTA_CATALOGO = new Long(3);
    
    public static final String ULTIMAS_NOTICIAS = "Ulitmas Noticias"; //Cortaberria
    
    public static final Integer IND_GRUPO_PRODUCTO_0  = new Integer(0); // ConstantesINC Integer 0 
    public static final Integer IND_GRUPO_PRODUCTO_1 = new Integer(1); // ConstantesINC Integer 1 
    
    public static final Long OID_FORMA_CALC_BASE_CALC = new Long(1);
    public static final Long OID_FORMA_CALC_VARIABLES_VTA = new Long(2);    
    
    public static final Long OID_TIPO_PREM_NIVELES = new Long(2);    

    // Modificado por Sergio Platas según Inc.17473 - 19/05/2005
    public static final Long TIPO_PREMIO_PUNTUACION_PUNTAJE_OBTENIDO = new Long(3);
 
    public static final Integer VERSION_1 = new Integer(1);
    public static final Long OID_ESTADO_EN_CREACION = new Long(1);
    public static final Long OID_ESTADO_ACTIVO = new Long(2);
    
    public static final Long OID_TIPO_PREMIO_MONETARIO = new Long(1);
    public static final Long OID_TIPO_PREMIO_ARTICULO = new Long(2);
    public static final Long OID_TIPO_PREMIO_DESCUENTO = new Long(3);
    public static final Long OID_TIPO_PREMIO_PUNTOS = new Long(4);
    
    public static final Long OID_TIPO_PREM_PTOS_CANT_FIJA = new Long(1);
    public static final Long OID_TIPO_PREM_PTOS_PORC_PUNTAJE_OBT = new Long(2);
    public static final Long OID_TIPO_PREM_PTOS_PUNTAJE_OBT = new Long(3);
    public static final Long OID_TIPO_PREM_MONET_CANT_FIJA = new Long(1);
    public static final Long OID_TIPO_PREM_MONET_PORC_PUNTAJE_OBT = new Long(2);
    public static final Long OID_TIPO_PREM_MONET_PUNTAJE_OBT = new Long(3);    
    public static final Long OID_TIPO_DET_METAS_BONO_ANUAL = new Long(3);
    public static final Long OID_TIPO_CUMPLIMIENTO_TOTAL = new Long(1);
    public static final Long OID_TIPO_DESCUENTO_IMPORTE = new Long(1);
    public static final Long OID_TIPO_DESCUENTO_PORCENTAJE = new Long(2);
    
    public static final String OPE_INC_COD_VENTA_FICTICIO = "INCCVF";
    
    //Agregado por enozigli 06/06/2005 segun DMCO INC8 e incidencia BELC300018839
    public static final Long TIPO_CALCULO_MULTINIVEL_RED = new Long(1);
    public static final Long TIPO_CALCULO_MULTINIVEL_HIJAS = new Long(2);
    //FIN Agregado por enozigli 06/06/2005 segun DMCO INC8 e incidencia BELC300018839
    
    //Agregado por splatas 07/06/2005 según DMCO INC8 e Incidencia 17475
    public static final Long TIPO_PREMIO_PUNTUACION_PORCENTAJE = new Long(2);
    
    //Agregado por splatas 08/06/2005  según DMCO INC8 e Incidencia 17471
    public static final Long TIPO_PREMIO_PUNTUACION_CANTIDAD_FIJA = new Long(1);
    
    public static final Integer PESTANYA_DATOS_GENERALES_RANKING = new Integer(1);
    public static final Integer PESTANYA_ALCANCE_GEOGRAFICO_RANKING = new Integer(2);
    public static final Integer PESTANYA_PARAMETROS_GERENTES_RANKING = new Integer(3);
    public static final Integer PESTANYA_PARAMETROS_CONSULTORAS_RANKING = new Integer(4);
    public static final Integer PESTANYA_PRODUCTOS_RANKING = new Integer(5);
    public static final Integer PESTANYA_PREMIOS_RANKING = new Integer(6);
    public static final Integer PESTANYA_VARIABLES_VENTA_RANKING = new Integer(7);
    public static final Integer OID_VAR_VENTA_RANK_PORC_COBRANZA = new Integer(8);
 
    //INC 19059
    //Jrivas 15/6/2005
    public static final Long OID_TIPO_INCREMENTO_PORCENTAJE = new Long(1);
    public static final Long OID_TIPO_INCREMENTO_CANTIDAD = new Long(2);
    public static final Long OID_FORMA_CALCULO_SUMATORIA = new Long(1);
    public static final Long OID_FORMA_CALCULO_PROMEDIO = new Long(2);
    public static final Long OID_FORMA_CALCULO_FACTORIZACION = new Long(3);
    
    public static final Long TIPO_ELECCION_DURANTE_CONCURSO = new Long(1);
    public static final Long TIPO_ELECCION_FINAL_CONCURSO = new Long(2);
    
    public static final Long OID_TIPO_EXIGENCIA_ACTIVIDAD = new Long(2);
    public static final Long OID_TIPO_PREM_BOLSA = new Long(1);
 
    //INC BELC300018104 enozigli 17/06/2005
    public static final Long VALOR_DEFECTO_MANT = new Long(1);
    
    //INC BELC300019173 cleal 21/06/2005
    public static final Long TIPO_DETERMINACION_METAS_FINAL_CONCURSO = new Long(2);
    public static final Long TIPO_DETERMINACION_METAS_BONO_ANUAL = new Long(3);
    
    //INC BELC300019220 cleal 21/06/2005
    public static final Long TIPO_DETERMINACION_METAS_POR_PERIODO = new Long(1);
    
    public static final Long OID_VAR_VTA_RANKING_PORC_COBR = new Long(18);
    
    public static final Long TIPO_RANKING_EVOLUTIVO   = new Long(1);
    public static final Long TIPO_RANKING_INTERACTIVO = new Long(2);
    
    public static final Long TIPO_RESULTADO_RANKING_ASPIRANTE = new Long(1);
    public static final Long TIPO_RESULTADO_RANKING_GANADOR   = new Long(2);
    
    
    public static final Long PREMIOS_CONSUELO_NRO_CONCURSO = new Long(1);
    public static final Long PREMIOS_CONSUELO_CLIENTES = new Long(2);
    public static final Long PREMIOS_CONSUELO_FICHERO = new Long(3);
    
    // INC 19878 - Diego Morello, 18/07/2005
    public static final Long OPER_SOLIC_PREMIO_CONSUELO = new Long(16);
    public static final Long BASE_CALCULO = new Long(1);
    
    public static final Long OID_AGRUPACION_SUBGERENCIA_VTA_RANKING = new Long(2);
    public static final Long OID_AGRUPACION_REGION_RANKING = new Long(3);
    public static final Long OID_AGRUPACION_ZONA_RANKING = new Long(4);
    public static final Long OID_AGRUPACION_SECCION_RANKING = new Long(5);
    public static final Long OID_AGRUPACION_GENERAL_RANKING = new Long(1);
    public static final Long OID_AGRUPACION_TERRITORIO_RANKING = new Long(6);
    public static final Long VARIABLES_VENTA = new Long(2);
    
    public static final Long OID_MENSAJE_RANKING = new Long(13);
    
    public static final String TEXTO_DESCRIPCION_ANULACION = "Cargo por Anulación";
    
    
    public static final Long OID_VIG_CONCU_VIGENTE = new Long(1);
    public static final Long OID_VIG_CONCU_NO_VIGENTE = new Long(2);
    
    public static final Long OID_VIG_CONCU_ANULADO = new Long(4);
    
    //Agregado por cvalenzu - versionado
    public static final Long OID_VIG_CONCU_EN_PROCESO = new Long(3);
    public static final Long OID_ESTADO_EN_CAMBIO = new Long(4);
    //FIN - Agregado por cvalenzu - versionado
    
    /* Agregado por ssantana, versionado, 23/05/2006 */
    public static final Long OID_VIG_CONCU_CERRADO_VERSIO = new Long(5);
    public static final Long OID_VIG_CONCU_CERRADO  = new Long(6);
    /* Fin Agregado por ssantana, versionado, 23/05/2006 */
    
    // vbongiov -- 31/05/2006 -- inc DBLG500000731
    public static final String ENTIDAD_MOTIVOS_PREM_CONS = "INC_MOTIV_PREMI_CONSU";
    
    // vbongiov -- 17/07/2006 -- inc DBLG500000997
    public static final String DESC_ANULACION_PTJE_EGRESOS = "Anulación  de puntos por egresadas";
    
    // jrivas 16/8/2006 inc. BELC300023774 
    public static final String DESC_PUNTAJE_PERIODO = "Puntaje del período";
    
    // HRCS 07/02/2007
    public static final String DESC_ENTREGA_PREMIO = "Entrega de Premio";
    
    // HRCS 14/02/2007
    public static final String DESC_FALTA_ACTIVIDAD = "Por falta de Actividad";
    
    // HRCS 14/02/2007
    public static final String DESC_FALTA_CONSTANCIA = "Por falta de Constancia";
    
    //Brecha INC-003 6-9-07 jrivas
    public static final String TIPO_ENTREGA_CENTRO_SERVICIO = "C";
    
    // vbongiov -- Cambio 20090828 -- 8/06/2009
    public static final Long OID_CRIT_STOCK_AGOTADO  = new Long(1);
    public static final Long OID_CRIT_EXISTEN_X_UNIDADES  = new Long(2);
    public static final Long OID_CRIT_INMED_SIGUI_DESPACHO  = new Long(3);
    
    // vbongiov -- Cambio 20090942 -- 28/07/2009
     public static final Long OID_CLAS_CONCUR_RECONOCIMIENTO = new Long(6);
     
    // vbongiov -- Cambio 20080811 -- 26/08/2009
    public static final Long OID_TIPO_CONCURSO_VENTAS = new Long(1);
    public static final Long OID_TIPO_PREMIACION_SORTEO = new Long(3);    
    public static final Long OID_TIPO_PREMIO_SORTEO = new Long(5);
    
    // vbongiov -- Cambio 20090929 -- 18/09/2009
    public static final Long OID_ESTADO_MORO_REGISTRADO = new Long(1);
    public static final Long OID_ESTADO_MORO_PASO_PED_CAMP_ANT = new Long(2);
    public static final Long OID_ESTADO_MORO_DEUDORA_CIERRE_Z_PER_MAX = new Long(3);
    public static final Long OID_ESTADO_MORO_AL_DIA_CIERRE_Z = new Long(4);    
   
    public static final String TIPO_CIERRE_ZONA = "Z"; 
   
    public static final Long OID_CAMP_ANT_PREMIACION = new Long(1);
    public static final Long OID_CAMP_FINAL_VIGENCIA = new Long(2);
    
    // sapaza -- PER-SiCC-2010-0403 -- 07/07/2010
    public static final Long OID_REGLA_VALIDAR_CANAL_PREMIACION = new Long(1);
    public static final Long OID_REGLA_VALIDAR_MARCA_PREMIACION = new Long(2);
    public static final Long OID_REGLA_VALIDAR_PAIS_PREMIACION = new Long(3);
    public static final Long OID_REGLA_EXIGENCIA_CURSOS = new Long(4);    
    public static final Long OID_REGLA_EXIGENCIA_CUOTA_MINIMA = new Long(5);    
    public static final Long OID_REGLA_PAGO_TIEMPO = new Long(6);    
    public static final Long OID_REGLA_EXIGENCIA_PERIODO_DESPACHO = new Long(7);    
    public static final Long OID_REGLA_VALIDAR_DEUDA_CON_PERIODO_DESPACHO = new Long(8);    
    public static final Long OID_REGLA_VALIDAR_DEUDA_SIN_PERIODO_DESPACHO = new Long(9);    
    public static final Long OID_REGLA_VALIDAR_DEUDA_CIERRE = new Long(10);    
    public static final Long OID_REGLA_VALIDAR_DEUDA_CIERRE_ACTUAL = new Long(11);
    public static final Long OID_REGLA_VALIDAR_CANDIDATA_GANADORA = new Long(12);
    public static final Long OID_REGLA_EXIGENCIA_PRODUCTOS = new Long(13);
    public static final Long OID_REGLA_EXIGENCIA_NUMERO_PERIODOS = new Long(14);
    public static final Long OID_REGLA_EXIGENCIA_NUMERO_PEDIDOS = new Long(15);
    public static final Long OID_REGLA_EXIGENCIA_MONTO_MINIMO_PREMIACION = new Long(16);
    public static final Long OID_REGLA_EXIGENCIA_MONTO_MINIMO_CONCURSO = new Long(17);
    public static final Long OID_REGLA_VALIDACION_ACTIVIDAD = new Long(18);
    public static final Long OID_REGLA_VALIDACION_CONSTANCIA = new Long(19);
    public static final Long OID_REGLA_VALIDACION_CLIENTE_DESCALIFICADO = new Long(20);
 
    // sapaza -- PER-SiCC-2010-0513 -- 11/10/2010
    public static final String TEXTO_VENTA_ECM = "Puntaje por venta ECM";
    public static final String COD_TIPO_PEDIDO_ECM = "SOCR";
    public static final String COD_ECM = "ECM";
 
    // sapaza -- PER-SiCC-2011-0279 -- 07/06/2011
    public static final String COD_TIPO_PEDIDO_DEVOLUCION_NORMAL = "SDDN";
 
    // sapaza -- PER-SiCC-2011-0721 -- 22/02/2012 
    public static final String TEXTO_PUNTAJE_RETAIL = "PUNTOS_POR_VENTA_RETAIL";
    
}