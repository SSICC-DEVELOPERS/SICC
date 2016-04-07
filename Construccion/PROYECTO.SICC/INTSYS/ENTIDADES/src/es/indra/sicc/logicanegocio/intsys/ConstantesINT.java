package es.indra.sicc.logicanegocio.intsys;
import java.util.Calendar;
import java.util.Date;

public class ConstantesINT {
  public ConstantesINT()  {  }
        public static final String COD_IDIOMA_ES ="ES"; 
        public static final String COD_UNIDAD_MEDIDA_VOLUMEN ="VO";
        public static final String COD_UNIDAD_MEDIDA_PESO ="PE";
        public static final String OBSERV_SAM6  = "INT124-SAM6"; 
        public static final String COD_OP_INT124 = "INT124";
        public static final String RUV_ACTIVO = "A";
        public static final String COD_ATRIBUTO1 = "01";
        public static final String COD_ATRIBUTO2 = "02";
        public static final String COD_ATRIBUTO3 = "03"; 
        public static final String COD_ATRIBUTO4 = "04";
        public static final String COD_ATRIBUTO5 = "05";
        public static final String COD_ATRIBUTO6 = "06";
        public static final String COD_ATRIBUTO7 = "07";
        public static final String COD_ATRIBUTO8 = "08";
        public static final String COD_ATRIBUTO9 = "09";
        public static final String COD_ATRIBUTO10 = "10";
        public static final String COD_ATRIBUTO11 = "11";
        public static final String COD_ATRIBUTO12 = "12";
        
        public static final String TIPO_ASIENTO_VN = "VN";
        public static final String TIPO_ASIENTO_AB = "AB";
        public static final String TIPO_ASIENTO_TN = "TN";
        
        public static final String IMPORTE_01 = "01";
        public static final String IMPORTE_03 = "03";
      // vbongiov -- Cambio 20090922 -- 28/05/2009
        public static final String IMPORTE_04 = "04";
        
        public static final String IMPORTE_05 = "05"; //dblg846
        public static final String IMPORTE_07 = "07"; //dblg846
        public static final String IMPORTE_50 = "50";
        public static final String IMPORTE_55 = "55";
        public static final String IMPORTE_60 = "60";
        public static final String IMPORTE_70 = "70";
        public static final String IMPORTE_80 = "80";
        public static final String IMPORTE_84 = "84";
        public static final String IMPORTE_88 = "88";

        //cambio SAPFI-001  (SCS-07/05/08)
        public static final String IMPORTE_90 = "90";

        public static final String COD_VARIANTE_02 = "02";
        
        public static final String INDICADOR_DETALLE = "D";
        public static final String INDICADOR_CABECERA = "C";
        
        public static final String INDICADOR_FACTURA = "F";
        
        // BELC300013581
        public static final String TIPO_ASIENTO_CUENTA_CORRIENTE = "CR";
        // BELC300013581
        public static final String GLOSA_NO_TESORERIA = "Cuenta Corriente Consultoras";
        // BELC300013578
        public static final String INDICADOR_CUENTA_CORRIENTE = "C";
		public static final String CODIGO_COMPANIA_PERU = "001";
		public static final String CODIGO_CLIENTE_VIP = "VIP";
      
        
        public static final Long ESTADO_PENDIENTE  = new Long(1); 
        public static final Long ESTADO_ENVIADO  =new Long(2); 
        public static final Long ESTADO_CONFIRMADO =new Long(3); 
        public static final Long ESTADO_ANULADO=new Long(4);  
        public static final Long MODULO_INT =new Long(25);   
        
        //Incidencia BELC300015642
        public static final String CONTROL_NOVEDAD_NUEVO = "0";
        public static final String CONTROL_NOVEDAD_MODIFICADO = "1";
         
        // incidencia BELC300016071
        public static final Integer ANCHURA_GLOSA_SAPFI = new Integer(40); 
        public static final Date  FECHA_COBRANZAS_DESDE = ConstantesINT.obtenerFecha();

        public static final Long INTERFAZ_IVR_1  = new Long(1); 
        public static final Long INTERFAZ_IVR_2  = new Long(2); 
        public static final Long INTERFAZ_IVR_3  = new Long(3); 
        public static final Long INTERFAZ_IVR_4  = new Long(4); 
        public static final Long INTERFAZ_IVR_5  = new Long(5); 
        public static final Long INTERFAZ_IVR_6  = new Long(6); 
        public static final Long INTERFAZ_IVR_7  = new Long(7);
        public static final Long INTERFAZ_IVR_9  = new Long(10);
        public static final Long INTERFAZ_IVR_10 = new Long(11);
        public static final Long INTERFAZ_IVR_11 = new Long(12);
        public static final Long INTERFAZ_IVR_12 = new Long(13);
        public static final Long INTERFAZ_IVR_13 = new Long(14);
        public static final Long INTERFAZ_IVR_14 = new Long(15);
        public static final Long INTERFAZ_IVR_15 = new Long(16);
        //public static final Long INTERFAZ_IVR_20 = new Long(20);
        //public static final Long INTERFAZ_IVR_21 = new Long(21);

        public static final Long PRIORIDAD_GESTION = new Long(2);
        
        //BELC300019599
        public static final String DATAMART = "Datamart";
        
        //BELC300017812
        public static final String S = "S";
        
        //BELC300021581
        public static final String MARCA_GENERICA = "99";        
          
       //BELC300016080
       
       public static final String INDICADOR_ENVIADO = "E";
       public static final String VALOR_SICC_S = "S";
       public static final String VALOR_SICC_N = "N";
       
       
       
       // gPineda - 06/03/2007 - Cambio pedido sobre Estatus de consultoras
       public static final Long NRO_CAMP_SIN_PEDI = new Long(2);
       
       // hhernandez - 04/04/2007 - Cambio para enviarFuenteVentaReal
       public static final String CANAL_BPS = "1";
       
       private static java.util.Date obtenerFecha (){
        Calendar calAuxIni = Calendar.getInstance();
        calAuxIni.set(2000,0,1);
        return new Date(calAuxIni.getTimeInMillis());
       }   
       
       //public static String MARCA_TODAS = "TO";
       //CAMBIO POR JPB
       public static String MARCA_TODAS = "T";
       // Agregado por HRCS - Fecha 11/09/2007 - Cambio Sicc20070385
       public static final Long INDICADOR_ACTIVO = new Long(1);
       public static final Long INDICADOR_DESACTIVO = new Long(0);

  }