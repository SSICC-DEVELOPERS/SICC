package es.indra.sicc.logicanegocio.mav;

import java.lang.Character;


public class ConstantesMAV {
    public static final int DESPACHO_PEDIDO = 1;
    public static final int DESPACHO_PEDIDO_SERVICIO = 2;
    public static final int DESPACHO_INI_PERIODO = 3;
    public static final int DESPACHO_FIN_PERIODO = 4;
    public static final int T_ESTAD_PROCESO_PENDIENTE = 1;
    public static final int T_ESTAD_PROCESO_COMPLETADO = 2;
    public static final int T_ESTAD_PROCESO_INICIADO = 3;
    public static final int T_ESTAD_PROCESO_GENERADO = 4;
    public static final int CRITERIO_ASIGNA_ATRIBUTOS = 1;
    public static final int CRITERIO_ASIGNA_VARIABLES = 2;
    public static final int CRITERIO_ASIGNA_FORMULA = 3;
    public static final Long SUBCRI_TODOS = new Long(1);
    public static final Long SUBCRI_CUMPLE = new Long(2);
    public static final Long SUBCRI_ANIVERSARIO = new Long(3);
    public static final Long SUBCRI_EDAD = new Long(4);
    public static final Long SUBCRI_PED_SUP_MONTO = new Long(5);
    public static final Long SUBCRI_PED_SUP_MONTO_MARCA = new Long(6);
    public static final Long SUBCRI_PED_SUP_MONTO_U_NEGOCIO = new Long(7);
    public static final Long SUBCRI_PED_SUP_MONTO_NEGOCIO = new Long(8);
    public static final Long SUBCRI_PED_SUP_MONTO_CATALOGO = new Long(9);
    public static final Long SUBCRI_ACTIVAS_FINALES = new Long(10);
    public static final Long SUBCRI_INGRESOS = new Long(11);
    public static final Long SUBCRI_REINGRESOS = new Long(12);
    public static final Long SUBCRI_EGRESOS = new Long(13);
    public static final Long SUBCRI_NUMERO_PEDIDOS = new Long(14);
    public static final Long SUBCRI_ASISTENCIA_CURSO = new Long(15);
    public static final Long SUBCRI_ASISTENCIA_CONFE = new Long(16);
    public static final Long SUBCRI_INGRESOS_FORMULA = new Long(18);
    public static final Long SUBCRI_REINGRESOS_FORMULA = new Long(19);
    public static final Long SUBCRI_EGRESOS_FORMULA = new Long(20);
    public static final Long SUBCRI_NUMERO_PEDIDOS_FORMULA = new Long(21);
    public static final Long SUBCRI_NUMERO_ZONAS = new Long(22);
    public static final Long FORMA_COBRO_GRATIS = new Long(1);
    public static final Long FORMA_COBRO_FACTURADO = new Long(2);
    public static final Long ESTADO_ENVIO_PENDIENTE = new Long(2);
    public static final Long ESTADO_ENVIO_SIN_AUTORIZACION = new Long(1);

    //8381
    public static final Long ESTADO_ENVIO_AUTORIZADO = new Long(3);
    public static final Long ENVIO_SOLICITUD_TODAS = new Long(1);
    public static final Long ENVIO_SOLICITUD_PRIMERA = new Long(2);
    public static final Character INDICADOR_PENDIENTE_ENVIO = new Character("P".charAt(0));
    public static final Character INDICADOR_ENVIADO = new Character("E".charAt(0));
    
    // Agregado por SICC20070356 - Rafael Romero - 29/08/2007
    // Codigos de campos valores por defecto nueva entrada completar datos BP
    public static final String CODIGO_CAMPO_VD_NEBP_CANA     = "001";
    public static final String CODIGO_CAMPO_VD_NEBP_ACCE     = "002";
    public static final String CODIGO_CAMPO_VD_NEBP_SUB_ACCE = "003";
    public static final String CODIGO_CAMPO_VD_NEBP_TIP_OFER = "004";
    public static final String CODIGO_CAMPO_VD_NEBP_TIP_CLIE = "005";
    public static final String CODIGO_CAMPO_VD_NEBP_SBT_CLIE = "006";
    public static final String CODIGO_CAMPO_VD_NEBP_CIC_VIDA = "007";
    public static final String CODIGO_CAMPO_VD_NEBP_CRI_ASIG = "008";
    public static final String CODIGO_CAMPO_VD_NEBP_TIP_DESP = "009";
    
    //Sbuchelli nuevas actividades asignacion por atributos
    
     public static final Long SUBCRI_PED_NO_SUP_MONTO = new Long(23);
     public static final Long SUBCRI_PED_NO_SUP_MONTO_MARCA = new Long(24);
     public static final Long SUBCRI_PED_NO_SUP_MONTO_U_NEGOCIO = new Long(25);
     public static final Long SUBCRI_PED_NO_SUP_MONTO_NEGOCIO = new Long(26);
     public static final Long SUBCRI_PED_NO_SUP_MONTO_CATALOGO = new Long(27);
     
     // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
     public static final Long SUBCRI_INSCRIPCION_DUPLA_CYZONE = new Long(28);
     
    // sapaza -- PER-SiCC-2010-0674 -- 29/11/2010
    public static final Long SUBCRI_ACTIVAS_FINALES_FORMULA = new Long(17);
    public static final Long SUBCRI_TIPOLOGIA_CLIENTES = new Long(29);
     
    // sapaza -- PER-SiCC-2010-0699 -- 12/12/2010
    public static final String CODIGO_UNIQUE_CONSTRAINT = "ORA-00001";
    public static final String UNIQUE_CONSTRAINT = "unique constraint";
    
}