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
package es.indra.sicc.logicanegocio.bel;

public class ConstantesBEL  {
    public static final Long BEL001 = new Long(27);  //8595
    public static final Long BEL002 = new Long(2);  //8595 
    public static final Long BEL003 = new Long(3);
    public static final Long BEL004 = new Long(4);//incidencia 12188
    public static final Long PED001 = new Long(30);  
    public static final Long PED215 =  new Long(31); 
    public static final Long PED305  = new Long(32); 
    public static final Long PED110 = new Long(33);  
    public static final Long EDU001  = new Long(22); 
    public static final Long EDU002  = new Long(23);
    public static final Long INC020  = new Long(14);
    public static final Long INC030  = new Long(15);
    public static final Long INC040  = new Long(16);
    public static final Long INC050  = new Long(17);
    public static final String COD_EST_LIBRE_DISP = "LD";
    public static final String COD_PED001 = "PED001";
    public static final Character FPAGO_NUMERODIAS = new Character('N');      
    public static final Character FPAGO_ACTIVIDAD = new Character('A');         
    public static final Character FPAGO_DURACION = new Character('D');        
    public static final Character FPAGO_FINAL = new Character('F'); 
    
    public static final Long MAV012  = new Long(10); //8478
    public static final Long MAV023  = new Long(11); //8478
    public static final Long OID_ESTADO_LIBRE_DISPOSICION  = new Long(1); //8837
    public static final String CODIGO_ESTADO_LIBRE_DISPOSICION  = "LD"; //Agregado JPB
    public static final Character CAJA_ABIERTA = new Character('A');
    public static final Character CAJA_CERRADA = new Character('C');
    public static final Character CAJA_CUADRADA = new Character('C');
    public static final Character CAJA_DESCUADRADA = new Character('D');  
    public static final Character TIPO_CAJA_PRINCIPAL = new Character('P');
    public static final Character TIPO_CAJA_NORMAL = new Character('N');
    public static final Character TIPO_CAJA_FUERTE = new Character('F');
    public static final Long TIPO_MP_EFECTIVO = new Long(1);
    public static final Long TIPO_MP_NOTA_CREDITO = new Long(5);
    public static final Long TIPO_MP_VENTA_CCC = new Long(6);
    public static final Long TIPO_MP_CHEQUE = new Long(3);
    public static final Long TIPO_MP_TARJETA = new Long(2);
    public static final Long TIPO_MP_VALES_COMPRA = new Long(4);
    public static final Long TIPO_MP_DIFERENCIA = new Long(7);
    public static final Long TIPO_MP_DEPOSITO_BANCO = new Long(8);
    public static final Long TIPO_MP_OTROS = new Long(9);
    public static final Long OID_TIPO_CAJA_PRINCIPAL = new Long(1);
    public static final Long OID_TIPO_CAJA_NORMAL = new Long(2);
    public static final Long OID_TIPO_CAJA_FUERTE = new Long(3);
    public static final Long CCC064 = new Long(36);
    public static final Long CCC065 = new Long(34);
    public static final Character CONTROL_ALMACEN_ACTIVADO = new Character('A');
    
    public static final Long ESTADO_HOJA_DEMANDA_CREADO = new Long(1);
    public static final Long ESTADO_HOJA_DEMANDA_ENVIADO = new Long(2);
    public static final Long ESTADO_HOJA_DEMANDA_CONFIRMADO = new Long(3);
    public static final Long ESTADO_HOJA_DEMANDA_INGRESADO = new Long(4);
    
    public static final Long OP_ACTUALIZAR_HOJA_DEMANDA = new Long(3);
    public static final Long OP_INGRESO_FISICO_HOJA_DEMANDA = new Long(4);
    public static final Long OP_GENERAR_REGISTRO_ABASTECIMIENTO = new Long(6);
    public static final String INDICADOR_INGRESO = "I";
    public static final String INDICADOR_SALIDA = "S";
    public static final String INDICADOR_TRASPASO = "T";
    public static final String SIGNO_SUMA = "+";
    public static final String SIGNO_RESTA = "-";    
    
    public static final Long FAC075 = new Long(43); //Aniadida por incidencia 13573    
    public static final String BEL_CAJA = "BEL_CAJA";  //jquiroga
    public static final Long BEL005 = new Long(5);  //jquiroga
    public static final String COD_INT083 = "INT083";
    public static final Long INT083 = new Long(24);
    
    public static final String COD_REC052 = "REC052";
    public static final String COD_REC046 = "REC046";

    public static final Long REC034 = new Long(8);
    
    public static final Long INT161 = new Long(35);
    
    public static final Long REC039 = new Long(21); // BELC300015203
    
    public static final String COD_REC034 = "REC034"; //BELC300014949
    public static final String COD_REC051 = "REC051"; //BELC300015997 

    public static final String COD_CON002 = "CON002"; 
    public static final String COD_CON001 = "CON001";
    
    public static final String BEL_FORMA_PAGO = "BEL_FORMA_PAGO";
    
    //Cortaberria Fecha: 26/05/2005 
    //codigo para la generacion de numero de lotes provenientes de NDG
    public static final String COD_PED110 = "PED110";
    
    // vbongiov -- 16/08/2006
    public static final Long INC010 = new Long(13);
    
    //agregado por incidencia BELC300024362 
    public static final Long DTO017 = new Long(9);
    
    // vbongiov -- GCC-COL-REC-001 -- 26/12/2007
    public static final String COD_REC057 = "REC057";
    public static final String COD_REC056 = "REC056";
    
    public static final String COD_REC058 = "REC058";
}