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
 */

package es.indra.sicc.logicanegocio.car;
import java.math.BigDecimal;

public class ConstantesCAR  {
    public ConstantesCAR() {
    }

    public static final Long ESTATUS_NOAPLICA  = new Long(1);
    public static final Long ESTATUS_PENDIENTE = new Long(2);  
    public static final Long ESTATUS_BLOQUEADO = new Long(3);  
    public static final Long ESTATUS_LIBERADO  = new Long(4);  
    public static final Long ESTATUS_APROBADO  = new Long(5);  
    public static final Long ESTATUS_REASIGNADO = new Long(6); 
    public static final Long ESTATUS_RECHAZADO = new Long(7); 
    public static final Long JERARQUIA_J1= new Long(2); 
    public static final Long MAX_OID_ASIG_CODI_CONF  = new Long(999999999);
    public static final Long TIPO_REEVALUACION_LC = new Long(2);
    public static final Long TIPO_REEVALUACION_NR = new Long(1);
    public static final Long REDONDEO_DECIMAL = new Long(0);
    public static final Long REDONDEO_UNIDAD = new Long(1);
    public static final Long REDONDEO_DECENA = new Long(2);
    public static final Long REDONDEO_CENTENA = new Long(3);
    public static final String MENSAJE1 = new String("Las solicitudes");
    public static final String MENSAJE2 = new String("están bloqueadas");
    public static final String ASUNTO_MENSAJE = new String("Solicitudes bloqueadas");
    public static final Long NIVEL_RIESGO_NUEVAS  = new Long (4 );
    public static final String AUMENTAR_LC  = "A";
    public static final String DISMINUIR_LC  = "D";
     
     
    //autor Cortaberria    
    public static final BigDecimal VAL_MAXI = new BigDecimal(9999999999.99);
    public static final Long PARAM_NR_PEDIDOS_PERIODO = new Long(1);
    public static final Long PARAM_NR_DIAS_MORA = new Long(2);
    public static final Long PARAM_NR_DIAS_DEUDA = new Long(3);
    public static final Integer MIN_DIAS = new Integer(0);
    public static final Integer MAX_DIAS = new Integer(42);
    
}