package es.indra.sicc.logicanegocio.mae;

public class ConstantesMAE  {	

  public static final String TXT_PRODUCTO_ACTIVO = "Activo";
  public static final String TXT_PRODUCTO_INACTIVO = "Inactivo";
  public static final String TXT_PRODUCTO = "Producto";
  public static final String TXT_SERVICIO = "Servicio";
  public static final String TXT_CAJA = "Caja";
  public static final String TXT_BOLSA = "Bolsa";
  public static final String TXT_VACIO = "";
  public static final String CAJA = "C";  
  
	public static final String TIPO_CLIENTE_INSTRUCTOR = "33";
	public static final String TIPO_CLIENTE_CONSULTORA  = "02";
	public static final String BLOQUEO_FINANCIERO = "02";       // cambio de acuerdo de inc. BELC300011609 idedough
	public static final String BLOQUEO_ADMINISTRATIVO  = "01";  // cambio de acuerdo de inc. BELC300011609 idedough
  
  //Agregado por  Hugo Mansi
  //Fecha: 20/12/2004
  //Incidencia BELC300011601
  public static final Long TIPO_COMUNICACION_TFNO = new Long(1);  
  public static final Long TIPO_COMUNICACION_EMAIL = new Long(3);
  public static final Long TIPO_COMUNICACION_FAX = new Long(2);   
  
  // Agregado por ssantana, 22/8/2005, a petición de Juan Pablo Bosnjak
  public static final String TIPO_COMUNICACION_TFNO_STRING = "TF";
  // Fin agregado ssantana, 22/8/2005
 
	// estatus  cliente posibles
	//01 Registrado 
	public static final String ESTATUS_REGISTRADO = "01";
	//02 Nuevo 
	public static final String ESTATUS_NUEVO = "02";
	//03 Normal 
	public static final String ESTATUS_NORMAL = "03";
	//04 Egresante 
	public static final String ESTATUS_EGRESANTE = "04";
	//05 Egresada 
	public static final String ESTATUS_EGRESADA = "05";
	//06 Reingreso 
	public static final String ESTATUS_REINGRESO = "06";
	//07 Retirado 
	public static final String ESTATUS_RETIRADO = "07";
	//08 Reactivado 
	public static final String ESTATUS_REACTIVADO = "08";
	//A Activo 
	public static final String PRODUCTO_ACTIVO = "A";
	public static final String CAMPO_CLIENTE   = "CLIENTES";

	public static final String CAMPO_PRODUCTO = "PRODUCTOS";
  
  /**
   * Autor Cortaberria
   * Fecha: 12/1/05
   */
  public static final Long  OID_TIPO_CLIENTE_CONSULTORA = new Long(2);
  public static final Long  OID_ESTATUS_NUEVA = new Long(2);
  
  // Agregado por Cristian Valenzuela - Fecha: 20/1/2005 
  
 
  // Agregado por Cristian Valenzuela - Fecha: 24/1/2005 
  public static final String TIPO_DOCUMENTO_DNI = "01";


  // Agregado por Julian Rivas - Fecha: 24/1/2005 
  public static final Long OID_SUBTIPO_CLIENTE_FINAL = new Long(2);
  public static final Long OID_SUBTIPO_GERENTE_REGION = new Long(3);
  public static final Long OID_SUBTIPO_GERENTE_ZONA = new Long(4);
  public static final Long OID_BLOQUEO_ADMINISTRATIVO =  new Long(1);
  public static final Long OID_BLOQUEO_FINANCIERO =  new Long(2);
  
 

  public static final String BOLSA = "B";
  
  public static final String PRODUCTO_INACTIVO = "I";
  
  public static final String TIPO_VINCULO_CONSULTORA_CLIENTEFINAL = "02";
  
  public static final Long OID_TIPO_CLIENTE_TRANSPORTISTA = new Long(6);
  public static final Long OID_TIPO_DIRECCION_DOMICILIO = new Long(1);
  public static final Long TIPO_COMUNICACION_TFNO_MOVIL = new Long(6);
  public static final Long OID_TIPO_CLASIFICACION_LIDER  = new Long(1);
  public static final Long OID_CLASIFICACION_LIDER  = new Long(1);
  
  /*Marta Aurora Montiel
   * 30/03/05  Incidencia BELC300015678
   * */
  public static final Long OID_TIPO_CLIENTE_GERENTE  = new Long(4);
  public static final Long TIPO_COMUNICACION_TFNO_TRABAJO  = new Long(7);

  public static final Long OID_TIPO_CLASIFICACION_ESTRELLA = new Long(3);
  public static final Long OID_CLASIFICACION_ESTRELLA = new Long(14);
  
  public static final String COD_TIPO_CLASIFICACION_DULPACYZONE = "23";
  public static final String COD_CLASIFICACION_DULPACYZONE = "01";
  
  /*Marta Aurora Montiel
   * 25/04/05  Incidencia  BELC300017115 
   * */
  public static final Long OID_ESTATUS_REINGRESADA = new Long(6);
  public static final Long OID_ESTATUS_EGRESADA = new Long(5);
  
  // gPineda - 06/03/2007
  public static final Long OID_ESTATUS_REACTIVADA = new Long(8);
  
  
  public static final Long TIPO_DOCUM_PASAPORTE = new Long(16);
  
  /* Maneiro Damasia
   * 16/06/05  Incidencia BELC300019180 
   * */
  public static final Long OID_ESTATUS_REGISTRADA = new Long(1);

  //jrivas 4/7/2005
  //Inc 16978
  public static final String TIPO_VINCULO_RECOMENDADA = "V2";  
  
  //Modificado: SICC-DMCO-MAE-GCC-006 - Cleal
  public static final Long IND_CLIEN_ACTIVO = new Long(1);
  public static final Long IND_CLIEN_INACTIVO = new Long(0);
  
  //Agregado por Incidencias 21107 a 21115
  public static final String TIPO_COMUN_FAX = "FX";

  public static final String TIPO_COMUN_EMAIL = "ML";
  
  public static final String TIPO_COMUN_TFNO = "TL";
  
  public static final String TIPO_COMUN_TMOVIL = "TM";
  
  //Agregado por incidencia BELC300022802 - eamores
  public static final String CODIGO_TIPO_COMUNICACION_EMAIL = "ML";
  
  public static final String CODIGO_TIPO_COMUNICACION_TFNO = "TF";
  
  public static final String CODIGO_TIPO_COMUNICACION_FAX = "FX";
  
  // vbongiov -- 10/08/2006 -- inc DBLG500001130
  public static final String CODIGO_TIPO_CONTACTO_IN = "I";
  public static final String CODIGO_TIPO_CONTACTO_OUT = "O";
  public static final String DESC_TIPO_CONTACTO_IN = "Inbound";
  public static final String DESC_TIPO_CONTACTO_OUT = "Outbound";
    
  //incidencia  V-INTDAT-10
  public static final String COD_TIPO_CLASIFICACION_LIDER  = "01";
  public static final String COD_CLASIFICACION_LIDER  = "01";
  
  //incidencia  V-INTPRD  
  public static final String COD_TIPO_DOCUM_PASAPORTE = "05"; 
 
  //Estados de Direcciones de los Cientes
  public static final Long IND_DIRECCION_ACTIVO = new Long(0);
  public static final Long IND_DIRECCION_ELIMINADO = new Long(1);
  
  //gPineda - 15/03/2007 - Sicc 20070112
  public static final String CODIGO_CONSULTORA_TIPO_NEGOCIO = "04";
  public static final String CODIGO_CONSULTORA_TIPO_OFICINA = "06";

  //    Agregado por HRCS - Fecha 03/04/2007 - Incidencia Sicc20070184
  public static final Long OID_TIPO_CLIEN_HIJADUPLA = new Long(5);
  public static final String COD_TIPO_CLIEN_HIJADUPLA = "10";
  
  public static final Long OID_SUBTIPO_CLIEN_HIJADUPLA = new Long(6);
  public static final String COD_SUBTIPO_CLIEN_HIJADUPLA = "01";
  
  public static final Long OID_TIPO_VINCULO_DUPLACYZONE = new Long(1);
  public static final String COD_TIPO_VINCULO_DUPLACYZONE = "01";  
  
  //Agregado por Sapaza - Fecha 09/08/2007 - Incidencia Sicc20070360
  public static final String TIPO_CLIENTE_GERENTE  = "04";
  public static final String COD_TIPO_CLASIFICACION_PRIVILEGE  = "11";
  public static final String COD_CLASIFICACION_PRIVILEGE  = "01";
  
  //    Agregado por HRCS - Fecha 15/08/2007 - Cambio Sicc20070361
  public static final String COD_MENSAJE_BIENVENIDA_DUPLACYZONE  = "MAE02";
  public static final String COD_MENSAJE_RECHAZO_DUPLACYZONE  = "MAE03";
  //    Agregado por HRCS - Fecha 11/09/2007 - Cambio Sicc20070385
  public static final String COD_TIPO_VINCULO_RECOMENDANTE = "03";
  public static final String COD_TIPO_DIRECCION_DOMICILIO = "01";
  
  
  //COL
  public static final String COD_VALOR_ACCION_AUTOMATICO = "A";
  public static final String COD_VALOR_ACCION_MANUAL = "M";
  public static final String COD_VALOR_ACCION_AMBOS = "B";
  
  public static final String COD_VALOR_USUARIO_BLOQUEAR = "L";
  public static final String COD_VALOR_USUARIO_DESBLOQUEAR = "D";
  public static final String COD_VALOR_USUARIO_AMBOS = "A";
  
  //COL
  
  // vbongiov -- SiCC20070455 MAE -- 18/12/2007
  public static final Long OID_TIPO_VINCULO_RECOMENDANTE_RECOMENDADA = new Long(9);  
  
  // vbongiov -- Cambio 20070458 -- 31/1/2008
  public static final String PROC_ASIG_ESTATUS_LOTES = "Asignar_estatus_en_lotes";
  //enguanco -- Cambio 
  
   public static final String  NUM_LINE_AFP= "24";
  
 }