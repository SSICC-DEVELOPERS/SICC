/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 */
package es.indra.sicc.dtos.pre;

/**
 * 
 * pperanzola - 20/10/2005 - [1] Se agregan la constantes según el SICC-DMCO-PRE_MAE_INT-GCC-001
 */

public class ConstantesPRE {
    public static final int ORDEN_COMPRA = 1;    
    public static final int REEMPLAZO = 2;
    public static final int ALTERNATIVO = 3;
    public static final int RECUPERACION = 4;
    public static final char LINEAS_NEGOCIO = 'L';
    public static final char RANGO_PAGINAS = 'R';
    public static final char PRODUCTOS = 'P';
    public static final String MF = "MF";
    public static final int INDIVIDUAL = 1;
    public static final int COMPUESTA_FIJA = 2;
    public static final int COMPUESTA_VARIABLE = 3;
    public static final int CONDICIONADA = 4;
    public static final int INDIVIDUAL_VS_GRUPO = 5;
    public static final int COMPUESTA_FIJA_VS_GRUPO = 6;
    public static final int COMPUESTA_VARIABLE_VS_GRUPO = 7;
    public static final String MAV = "MAV";
    public static final String GUIA_PRODUCTOS = "GuiaProductos";
    public static final int PAQUETE_FICHERO_GP = 200;
    public static final int LONG_TIPO = 3;
    public static final int LONG_SERIE = 3;   
    public static final String ESTIMADOS_VENTA = "Es";    
    public static final String SI = "SI";
    public static final String NO = "NO";
    public static final String MONEDA_PAIS = "Moneda del País";
    public static final long CUADRE_MAYOR_POR_UNIDADES = 1;
    public static final long CUADRE_MENOR_POR_UNIDADES = 2;
    public static final long CUADRE_FACTOR_MULTIPLO = 3;
    public static final long CUADRE_TOTAL_MONTOS = 4;
    public static final long CUADRE_TOTAL_UNIDADES = 5;
    public static final String Y = "Y";
    public static final String O = "O";
    public static final String ENTIDAD_ARGUMENTO_VENTA = "ArgumentoVenta";
    public static final String ENTIDAD_CICLO_VIDA = "CicloVida";
    public static final String ENTIDAD_CATALOGO = "Catalogo";
    public static final String ENTIDAD_CONDICION_PROMOCION = "CondicionPromocion";
    public static final String ENTIDAD_TIPO_OFERTA = "TipoOferta";   
    public static final Long CICLO_VIDA_00 = Long.valueOf("4");
    public static final Long TIPO_OFERTA_00 = Long.valueOf("29");
    public static final long CUADRE_POR_UNIDADES = 1;
    public static final long CUADRE_POR_MONTOS = 2;
    
    /*agregado enoziglia 06/09/2005 referencia: SICC-DMCO-PRE-201-354-P0012-CUV*/
    public static final Long MENOR_NUMERO_CUV = Long.valueOf("95001");
    public static final Long MAXIMO_CUV_ADICIONAL = Long.valueOf("100000");
    /*fin agregado enoziglia 06/09/2005 referencia: SICC-DMCO-PRE-201-354-P0012-CUV*/
    public static final Long MAYOR_NUMERO_CUV = Long.valueOf("99999");
    
    // /* [1]
    public static final String OPERACION_ALTA = "alta";
    public static final String OPERACION_BAJA = "baja";
    public static final String OPERACION_MODIFICACION = "modificacion";
    //*/

    // vbongiov -- Cambio 20080746 -- 29/10/2008
    public static final String COD_PROGR_NUEVAS_MARKETING = "50";
    public static final String COD_MATERIAL_NUEVAS = "91";
}