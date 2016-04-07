package es.indra.sicc.logicanegocio.intsys;

/*
 * 27/8/2005 - rgiorgi: se corrige la palabra "puntaje"
 * */
public class IIVR  {
    //IVR
    public static final String COD_INTERFAZ_IVR1 = "IVR-1";
    public static final String IVR1_CODIGO_REGION = "codigoRegion";
    public static final String IVR1_DESCRIPCION_REGION = "descripcionRegion";
    public static final String COD_INTERFAZ_IVR2 = "IVR-2";
    public static final String IVR2_CODIGO_CLIENTE = "codigoCliente";
    public static final String IVR2_NOMBRE_GERENTE = "nombreGerente";
    public static final String IVR2_CODIGO_BUZON = "codigoBuzon";
    public static final String IVR2_FECHA_NACIMIENTO = "fechaNacimiento";
    public static final String IVR2_TIPO_CLIENTE = "tipoCliente";
    public static final Long LONGITUD_MAX_GERENTE = new Long(75);
    public static final Long LONGITUD_MAX_CONSULTORA = new Long(57);
    public static final String COD_INTERFAZ_IVR3 = "IVR-3";
    public static final String IVR3_CODIGO_CLIENTE = "codigoCliente";
    public static final String IVR3_NOMBRE_CONSULTORA = "nombreConsultora";
    public static final String IVR3_CODIGO_BUZON = "codigoBuzon";
    public static final String IVR3_SALDO_CONSULTORA = "saldoConsultora";
    public static final String IVR3_CODIGO_SECCION = "codigoSeccion";
    public static final String IVR3_CODIGO_TERRITORIO = "codigoTerritorio";
    public static final String IVR3_FECHA_DOCUMENTO = "fechaDocumento";
    public static final String IVR3_INDICADOR_INCOBRABLE = "indicadorIncobrable";
    public static final String COD_INTERFAZ_IVR4 = "IVR-4";
    public static final String IVR4_CODIGO_CLIENTE = "codigoCliente";
    public static final String IVR4_CODIGO_PERIODO = "codigoPeriodo";
    public static final String IVR4_NUMERO_DOCUMENTO = "numeroDocumento";
    public static final String IVR4_IMPORTE_PENDIENTE = "importePendiente";
    public static final String COD_INTERFAZ_IVR10 = "IVR-10";
    public static final String IVR10_MOTIVO_ATENCION = "motivosAtencion";
    public static final String IVR10_DESCRIPCION_MOTIVO = "descripcionMotivo";
    public static final String COD_INTERFAZ_IVR9 = "IVR-9";
    public static final String IVR9_CODIGO_ZONA = "codigoZona";
    public static final String IVR9_CODIGO_ACTIVIDAD = "codigoActividad";
    public static final String IVR9_FECHA_ACTIVIDAD = "fechaActividad";
    public static final String IVR9_INDICADOR_FECHA = "indicadorFecha";
    public static final String C = "C";
    public static final String F = "F";
    public static final String R = "R";
    public static final String A  = "A";
    public static final String E  = "E";
    public static final String X  = "X";
    public static final String COD_INTERFAZ_IVR21 = "IVR-21";
    public static final String IVR21_ESTADO = "estado";
    public static final String IVR21_EXITO_LLAMADA = "exitoLlamada";
    public static final String COD_INTERFAZ_IVR11 = "IVR-11";
    public static final String IVR11_CODIGO_CONSULTORA  = "codigoConsultora";
    public static final String IVR11_NUMERO_SERVICIO_POSTVENTA  = "numeroServicioPostVenta";
    public static final String IVR11_CODIGO_OPERACION  = "codigoOperacion";
    public static final String IVR11_DESCRIPCION_PRODUCTO  = "descripcionProducto";
    public static final String IVR11_CODIGO_PRODUCTO  = "codigoProducto";
    public static final String IVR11_ESTADO_ATENDIDO  = "estadoAtendido";
    public static final String IVR11_ESTADO_OPERACION  = "estadoOperacion";
    public static final String IVR11_PERIODO_ATENCION  = "periodoAtencion";
    public static final String IVR11_MONTO_ATENCION_POSTVENTA  = "montoAtencionPostVenta";
    public static final String IVR21_IDENTIFICADOR = "identificador";

    public static final String COD_INTERFAZ_IVR20 = "IVR-20";
    public static final String IVR20_CODIGO_CLIENTE = "codigoCliente";
    public static final String IVR20_TELEFONO1 = "telefono1";
    public static final String IVR20_PRIORIDAD = "prioridad";
    public static final String IVR20_ZONA = "codigoZona";
    public static final String IVR20_REGION = "region";
    public static final String IVR20_COMPANIA_TELEF = "companiaTelef";
    public static final String IVR20_NOMBRE_CONSULTORA = "nombreConsultora";
    
    public static final String COD_INTERFAZ_IVR14  = "IVR-14";
    public static final String IVR14_CODIGO_PRODUCTO  = "codigoProducto";
    public static final String IVR14_DESCRIPCION_PRODUCTO  = "descripcionProducto";
    
    public static final String COD_INTERFAZ_IVR15  = "IVR-15";
    public static final String IVR15_NUMERO_DOCUMENTO  = "numeroDocumento";
    public static final String IVR15_ESTADO  = "estado";
    
    public static final String COD_INTERFAZ_IVR13 = "IVR-13";
    
    public static final String IVR13_CODIGO_CLIENTE = "codigoCliente";
    public static final String IVR13_NIVEL_RIESGO = "nivelRiesgo";
    public static final String IVR13_LINEA_CREDITO = "lineaCredito";
    public static final	String IVR13_CREDITO_DISPONIBLE = "creditoDisponible"; 
    
    public static final	String COD_INTERFAZ_IVR5 = "IVR-5";
    public static final	String IVR5_CODIGO_CONSULTORA = "codigoConsultora";
    public static final	String IVR5_PERIODO_FIN_CONCURSO = "periodoFinConcurso";
    public static final	String IVR5_NUMERO_CONCURSO = "numeroConcurso";
    public static final	String IVR5_TIPO_CONCURSO = "tipoConcurso";
    public static final	String IVR5_PUNTAJE_OBTENIDO = "puntajeObtenido";
    public static final	String V = "V";
    public static final	String I = "I";
    public static final	String T = "T";
    
    
    //IVR6
    public static final	String COD_INTERFAZ_IVR6 = "IVR-6";
    public static final	String IVR6_CODIGO_CONSULTORA = "codigoConsultora";
    public static final	String IVR6_NUMERO_CONCURSO = "numeroConcurso";
    public static final	String IVR6_BASE_INCUMPLIDA = "baseIncumplida";
    public static final	String IVR6_CAMPANIA_INCUMPLIDA = "campanaIncumplida";
    public static final	String IVR6_SALDO_CONSULTORA = "saldoConsultora";
    public static final String IVR6_FECHA_SALDO = "fechaSaldo";
     public static final String COD_INTERFAZ_IVR7 = "IVR-7"; 

    public static final String IVR7_NUMERO_CONCURSO = "numeroConcurso"; 

    public static final String IVR7_NUMERO_NIVEL = "numeroNivel"; 

    public static final String IVR7_PUNTAJE_REQUERIDO = "puntajeRequerido"; 

    public static final String IVR7_CAMPANA_DESPACHO = "campanaDespacho";
    
    public static final String COD_INTERFAZ_IVR12 = "IVR-12";
	public static final String IVR12_NUMERO_CONCURSO = "numeroConcurso";
	public static final String IVR12_NUMERO_NIVEL = "numeroNivel";
	public static final String IVR12_CODIGO_PREMIO = "codigoPremio";
	public static final String IVR12_UNIDADES = "unidades";    

 


}