package es.indra.sicc.logicanegocio.cob;

public class ConstantesCOB 
{
  public static final Long IND_TELEFONO_ACTIVO = new Long(1);
  public static final Long ESTADO_USUARIO_ACTIVO = new Long(1);
  public static final Long TIPO_BALANCEO_CONSULTORA = new Long(2);
  public static final Long TIPO_BALANCEO_SALDO = new Long(1);

   //Estados Asignacion de Cobranzas
  public static final Long OID_ESTA_ASIG_CANCELDA_CG = new Long(2);
  public static final Long OID_ESTA_ASIG_CANCELDA_SG = new Long(3);
  public static final Long OID_ESTA_ASIG_REASIGNADA = new Long(4);
  public static final Long OID_ESTA_ASIG_ETAPA_POST = new Long(5);
  public static final Long OID_ESTA_ASIG_ABIERTA = new Long(6);

  public static final int TIPO_USUARIO_COB_JEFE = 2;
  public static final int TIPO_USUARIO_COB_SUPERVISOR = 1;
  public static final int TIPO_USUARIO_COB_GESTOR = 0;
  public static final Long OID_ESTADO_ETAPA_POSTERIOR = new Long(5);
  public static final Long OID_ESTADO_ETAPA_CANCELADA_SG = new Long(3);
  public static final Long OID_ESTADO_ETAPA_CANCELADA_CG = new Long(2);
  public static final Long OID_VALOR_ENT_ETAPA_ANT = new Long(1);
  public static final Long OID_VALOR_NOMINAL_VIVO = new Long(2);
  
  public static final int OID_CRI_ORD_CONS_NUEVAS = 1;
  public static final int OID_CRI_ORD_CONS_INCID = 2;
  public static final int OID_CRI_ORD_MAYOR_RIESGO = 3;
  public static final int OID_CRI_ORD_ETAPA_DEUDA = 4;
  public static final int OID_CRI_ORD_LLAMADA_DEL_DIA = 5;
  public static final int OID_CRI_ORD_MAYOR_SALDO_PEND = 6;
  
  public static final String  OPERACION_COB070 = new String("COB070");
  public static final String  OPERACION_COB072 = new String("COB072");
  public static final String  OPERACION_COB077 = new String("COB077");
  
  //Incidencia BELC300016428 mamontie
  public static final String COD_ACCION_LLAMADA_TELEFONICA = new String("1");
}